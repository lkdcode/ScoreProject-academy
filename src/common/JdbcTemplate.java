package common;

import java.sql.*;

public class JdbcTemplate {

    public static Connection getConnection() {
        Connection conn;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "academy", "1234");

            conn.setAutoCommit(false);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static boolean isConnection(Connection conn) {
        boolean valid = true;

        try {
            if (conn != null || conn.isClosed()) {
                valid = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return valid;
    }

    public static void commit(Connection conn) {
        if (isConnection(conn)) {
            try {
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void rollback(Connection conn) {
        if (isConnection(conn)) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
