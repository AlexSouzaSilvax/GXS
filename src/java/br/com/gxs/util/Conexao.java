package br.com.gxs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    static Connection conn;

    public static void main(String[] args) throws SQLException {

        Connection con = Conexao.getConnection();
    }

    public static Connection getConnection() {
        try {
            if (conn != null) {
                if (!conn.isClosed()) {
                    return conn;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            String url = "jdbc:mysql://127.0.0.1/GXS";

            String usuario = "root";
            String senha = "";
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            con = DriverManager.getConnection(url, usuario, senha);
            conn = con;

            System.out.println("conectou");
            return con;
        } catch (Exception e) {
            System.out.println("nao conectou");
            e.printStackTrace();
            return null;
        }
    }
}
