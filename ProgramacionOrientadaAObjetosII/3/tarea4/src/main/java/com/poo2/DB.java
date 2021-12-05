package com.poo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class DB {
    private static DB instance = null;
    private Connection conn = null;

    public static final Integer SQLExceptionExitStatus = 1;

    public static final String dbName = "db.sqlite3";
    public static final String connectionStringPrefix = "jdbc:sqlite:";

    public static boolean sqlite3JDBCDriverExists() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (final ClassNotFoundException e) {
            return false;
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public void connect(String db) throws SQLException {
        conn = DriverManager.getConnection(connectionStringPrefix + db);
        System.out.println("Connection to " + db + " successful");
    }

    public void connect() throws SQLException {
        connect(dbName);
    }

    public void disconnect() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Closed connection to db");
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
    
    public Statement execQuery(String query) throws SQLException {
        Statement s = conn.createStatement();
        s.execute(query);
        return s;
    }

    public Integer lastInsertRowId() throws SQLException {
        var rs = execQuery("SELECT last_insert_rowid();").getResultSet();

        boolean dummy = rs.next();
        assert dummy: "last_insert_rowid() gave no results";

        return rs.getInt("last_insert_rowid()");
    }

    public ArrayList<Book> getBooks(String field, String value) {
        var books = new ArrayList<Book>();
        String query = "SELECT * FROM libro";
        
        if (field != null && value != null) {
            value.replaceAll("'", "\\'"); // Escape any `'` to avoid injections
            query += " WHERE " + field + " = '" + value + "';";
        } else {
            query += ";";
        }

        try {
            var s = execQuery(query);
            var rs = s.getResultSet();
            while (rs.next()) {
                var id = rs.getInt("id");
                var name = rs.getString("nombre");
                var author = rs.getString("autor");
                var description = rs.getString("descripcion");
                var genere = rs.getString("genero");
                var edition = rs.getInt("edicion");

                books.add(new Book(id,
                                   name,
                                   author,
                                   description,
                                   genere,
                                   edition));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public ArrayList<Book> getBooks(String field, Integer value) {
        var books = new ArrayList<Book>();
        String query = "SELECT * FROM libro";
        
        if (field != null && value != null) {
            query += " WHERE " + field + " = " + value + ";";
        } else {
            query += ";";
        }

        try {
            var s = execQuery(query);
            var rs = s.getResultSet();
            while (rs.next()) {
                var id = rs.getInt("id");
                var name = rs.getString("nombre");
                var author = rs.getString("autor");
                var description = rs.getString("descripcion");
                var genere = rs.getString("genero");
                var edition = rs.getInt("edicion");

                books.add(new Book(id,
                                   name,
                                   author,
                                   description,
                                   genere,
                                   edition));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public ArrayList<Book> getBooks() {
        return getBooks(null, (String)null);
    }

    public void saveBook(final Book b) {
        try {
            var s = conn.prepareStatement(
                "INSERT INTO libro "
                + "(nombre, autor, descripcion, genero, edicion) "
                + "VALUES (?,?,?,?,?);"
            );
            s.setString(1, b.getName());
            s.setString(2, b.getAutor());
            s.setString(3, b.getDescripcion());
            s.setString(4, b.getGenero());
            s.setInt(5, b.getEdition());
            s.executeUpdate();

            b.setId(lastInsertRowId());
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
