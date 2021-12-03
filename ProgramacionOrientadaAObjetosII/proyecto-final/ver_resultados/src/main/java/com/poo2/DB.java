package com.poo2;

import static com.poo2.Answer.Answers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public void saveAnswer(Answer ans) {
        try {
            PreparedStatement s = conn.prepareStatement(
                "INSERT INTO respuestas (id_pregunta,respuesta,fecha) "
                + "VALUES (?,?,?);"
            );
            s.setInt(1, ans.getQuestionId());
            s.setInt(2, ans.getAnswer().val);
            s.setString(3, ans.getDate());
            s.executeUpdate();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Question> getQuestions() {
        var questions = new ArrayList<Question>();

        try {
            var s = execQuery("SELECT * FROM preguntas;");
            var rs = s.getResultSet();

            while (rs.next()) {
                var id = rs.getInt("id");
                var text = rs.getString("texto");
                questions.add(new Question(id, text));
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    /**
     * @param date A string in the format "yyyy-mm-dd"
     */
    public ArrayList<Answer> getAnswers(String date) {
        var answers = new ArrayList<Answer>();

        try {
            var s = execQuery("SELECT * FROM respuestas WHERE fecha = '"
                              + date + "';");
            var rs = s.getResultSet();

            while (rs.next()) {
                var questionId = rs.getInt("id_pregunta");
                var answer = Answers.valueOf(rs.getInt("respuesta"));
                var ansDate = rs.getString("fecha");
                assert ansDate.equals(date);
                assert answer != Answers.undefined;

                // Because of the use case, it doesnt matter that the date
                // doesnt match, we wont need it.
                answers.add(
                    new Answer(questionId, answer)
                );
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return answers;
    }
}
