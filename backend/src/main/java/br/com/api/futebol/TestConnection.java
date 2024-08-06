package br.com.api.futebol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/futebol?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
