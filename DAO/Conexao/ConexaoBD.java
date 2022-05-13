package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.Driver;

public class ConexaoBD {
	
	public Connection conectaBD() {
		
		Connection c = null;
		
		try {
			
			String urlConexao = "";
			String usuAdmin = "";
			String senhaAdmin = "";
			
			//Driver driver = new Driver();
			//DriverManager.registerDriver(driver);
			
			c = DriverManager.getConnection(urlConexao,usuAdmin,senhaAdmin);
		
			
		
		}catch(SQLException e) {
			throw new  RuntimeException("Erro na Conexão",e);
		}
		
		return (c);
	}
}
