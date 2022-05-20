package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {
	
	public static Connection getConexao() throws SQLException {
        String conexao = "jdbc:mysql://127.0.0.1:3306/mysql";
        
        return DriverManager.getConnection(conexao,"root","@Project123");
	}
	
}
