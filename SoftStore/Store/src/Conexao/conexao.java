package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexao {

    private static final String Drive = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/lojaTest";
    private static final String USUARIO_POSTGRES = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection getConnection()   {
        try {
            Class.forName(Drive);
            return DriverManager.getConnection(URL, USUARIO_POSTGRES, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("ERRO ! Não foi possivel conectar." + e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERRO! Não foi possivel fecha a conexão" + e);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement pstm) {
        closeConnection(con);
        try {
            if (pstm != null) {
                pstm.close();

            }
        } catch (Exception e) {
            throw new RuntimeException("ERRO! Não foi possivel fecha o PreparedStatement" + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (Exception e) {
            throw new RuntimeException("ERRO! Não foi possivel fecha o ResultSet" + e);
        }
    }
}
