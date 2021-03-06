package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.cj.jdbc.Driver;

public class ConexaoBD {
	
	public static Connection conectaBD() {
		
		Connection c = null;
		
		try {
			
			String urlConexao = "jdbc:mysql://127.0.0.1:3306/sistema_clube_tenis";
			String usuAdmin = "root";
			String senhaAdmin = "5432es";
			
			//Driver driver = new Driver();
			//DriverManager.registerDriver(driver);
			
			c = DriverManager.getConnection(urlConexao,usuAdmin,senhaAdmin);
		
			
		
		}catch(SQLException e) {
			throw new  RuntimeException("Erro na Conex�o",e);
		}
		
		return (c);
	}
	
	public static void encerrarConexaoBD(Connection c){
			
		if(c != null) {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void encerrarConexaoBD(Connection c, PreparedStatement stmt){
		
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		encerrarConexaoBD(c);
	}
	
	public static void encerrarConexaoBD(Connection c, PreparedStatement stmt, ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		encerrarConexaoBD(c,stmt);
	}
	
	
}
