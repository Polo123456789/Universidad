package poo.proyecto_final;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface LlenadorDeParametros {
    void apply(PreparedStatement s) throws SQLException;
}
