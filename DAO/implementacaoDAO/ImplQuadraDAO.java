package implementacaoDAO;

import java.util.ArrayList;
import java.util.List;

import Dominio.Quadra;
import Enum.TipoQuadra;
import Exceptions.CourtAlreadyRegisteredException;
import Exceptions.CourtNotFoundException;
import interfaceDAO.QuadraDAO;
import queries.QueriesQuadra;
import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexao.ConexaoBD;


public class ImplQuadraDAO implements QuadraDAO{
	
	QueriesQuadra q = new QueriesQuadra(); 
	
	
	@Override
	public List<Quadra> obterTodasQuadras() throws IOException, SQLException{
		
		List<Quadra> quadrasLista = new ArrayList<Quadra>();
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
		q.queriesQuadra.load(in);
		in.close();
		
		Connection con =  ConexaoBD.conectaBD();
		PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("SELECT_ALL_FROM_ALL_QUADRA"));
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			Quadra quadra = montaQuadra(rs); 
			quadrasLista.add(quadra);
		}
		
		ConexaoBD.encerrarConexaoBD(con, stmt, rs);
		
		List<Quadra> quadrasListaCopia = new ArrayList<Quadra>();
		quadrasListaCopia.addAll(quadrasLista);
		
		return quadrasListaCopia;
		
	}
	

	public List<Quadra> obterQuadrasHabilitadas(boolean habilitado) throws IOException, SQLException{
		
		List<Quadra> quadraLista = new ArrayList<Quadra>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
		q.queriesQuadra.load(in);
		in.close();
		
		Connection con =  ConexaoBD.conectaBD();
		PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("SELECT_DISABLE_QUADRA"));
		stmt.setBoolean(1, habilitado);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			Quadra quadra = montaQuadra(rs); 
			quadraLista.add(quadra);
		}
		
		ConexaoBD.encerrarConexaoBD(con, stmt, rs);
		
		return quadraLista;
	}
	
	public List<Quadra> obterQuadraBloqueadas(boolean bloqueado){ 
		List<Quadra> quadrasLista = new ArrayList<Quadra>();
		
		try {
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("SELECT_ALL_BLOCKED_QUADRA"));
			stmt.setBoolean(1, bloqueado);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Quadra quadra = montaQuadra(rs); 
				quadrasLista.add(quadra);
			}
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return quadrasLista;
		
	}
	
	public Quadra obterQuadraPeloNome(String nome) throws CourtNotFoundException {
		
		Quadra qua = null;
		
		try {
			
			q.consultaQuadra();
			
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("SELECT_FROM_QUADRA_BY_QUA_NOME"));
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
					
				qua = montaQuadra(rs); 
				
			}else {
				throw new CourtNotFoundException("N??o foi encontrada nenhuma quadra com o nome: " + nome);
			}
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		return qua;
	}
	
	public Quadra obterQuadraPeloID(String id) throws CourtNotFoundException {
		
		Quadra qua = null;
		
		try {
			
			q.consultaQuadra();
			
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("SELECT_FROM_QUADRA_BY_QUA_ID"));
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
					
				qua = montaQuadra(rs); 
				
			}else {
				throw new CourtNotFoundException("N??o foi encontrada nenhuma quadra com o id: " + id);
			}
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		return qua;
	}
	

	public boolean CadastrarQuadra(Quadra qua) throws CourtAlreadyRegisteredException{ 
		
		
		try {
			q.DMLQuadra();
			q.consultaQuadra();
			FileInputStream in = new FileInputStream("DML_QUADRA.properties");
			FileInputStream in2 = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
			q.queriesQuadra.load(in);
			q.queriesQuadra.load(in2);
			in.close();
			in2.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("VERIFY_QUADRA_BY_QUA_NOME"));
			stmt.setString(1, qua.getNome());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				throw new CourtAlreadyRegisteredException("Uma quadra com esse nome j?? foi cadastrada!");
			}
		
			stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("INSERT_INTO_QUADRA"));
		
			stmt.setString(1, qua.getNome());
			stmt.setString(2, qua.getEndereco());
			stmt.setBoolean(3, qua.isPossuiCobertura());
			stmt.setBoolean(4, qua.isPossuiArquibancada());
			stmt.setBoolean(5, qua.isPossuiAreaDescanso());
			stmt.setInt(6, UtilidadesConversao.transformaTipoQuadraEmInteiro(qua.getTipo()));
	
			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt, rs);
			return true;
		
	}catch(SQLException e) {

		e.printStackTrace();
		return false;
		
	}catch(IOException e) {

		e.printStackTrace();
		return false;
	}
	}
	

	public boolean AlterarDadosQuadra(Quadra qua, String alteracao, int escolha) { 
		try {
			q.DMLQuadra();
			FileInputStream in = new FileInputStream("DML_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = null;
			
			switch(escolha) {
			
				case 1:
					stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_NOME"));
					stmt.setString(1, alteracao);
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 2:
					stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_ENDERECO"));
					stmt.setString(1, alteracao);
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 3:
					stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_COBERTURA"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 4:
					stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_ARQUIBANCADA"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 5:
					stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_AREA_DESCANSO"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 6:
					stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_TIPO"));
					stmt.setInt(1, Integer.valueOf(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Op????o Inv??lida!");
					break;
			}
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public boolean HabilitarQuadra(String nome, boolean habilitado) { 
	
		try {
			q.DMLQuadra();
			FileInputStream in = new FileInputStream("DML_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_HABILITADO"));
			stmt.setBoolean(1, habilitado);
			stmt.setString(2, nome);
			
			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		}catch(IOException e) {
			e.printStackTrace();
			return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean BloquearQuadra(String nome, boolean bloqueado) {
		
		try {
			q.DMLQuadra();
			FileInputStream in = new FileInputStream("DML_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_BLOQUEADO"));
			stmt.setBoolean(1, bloqueado);
			stmt.setString(2, nome);
			
			stmt.executeUpdate();
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		}catch(IOException e) {
			e.printStackTrace();
			return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean DeletarQuadra(String nome) { 
	
		try {
			q.DMLQuadra();
			FileInputStream in = new FileInputStream("DML_QUADRA.properties");
			in.close();
			
			Connection con =  ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(q.queriesQuadra.getProperty("DELETE_QUADRA"));
			stmt.setString(1, nome);
			stmt.executeUpdate();
			
			ConexaoBD.encerrarConexaoBD(con, stmt);
			return true;
			
		}catch(IOException e) {
			e.printStackTrace();
			return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Quadra montaQuadra(ResultSet rs) throws SQLException {

		String nome = rs.getString("qua_nome");
		String endereco = rs.getString("qua_endereco");
		TipoQuadra tipo = UtilidadesConversao.transformaInteiroEmTipoQuadra(rs.getInt("qua_id_tipo"));
		boolean cobertura = rs.getBoolean("qua_cobertura");
		boolean arquibancada = rs.getBoolean("qua_arquibancada");
		boolean descanso = rs.getBoolean("qua_area_descanso");
		boolean bloqueada = rs.getBoolean("qua_bloqueado");
		return new Quadra(nome, endereco, tipo, cobertura, arquibancada, descanso, bloqueada);
	}
	
}
