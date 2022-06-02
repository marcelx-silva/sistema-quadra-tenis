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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexao.ConexaoBD;


public class ImplQuadraDAO implements QuadraDAO{
	
	QueriesQuadra q = new QueriesQuadra(); 
	
	@Override
	public List<Quadra> obterTodasQuadras() throws IOException, SQLException{
		
		List<Quadra> quadrasLista = new ArrayList<>();
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
		q.queriesQuadra.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("SELECT_ALL_FROM_ALL_QUADRA"));
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			String nome = rs.getString("qua_nome");
			String endereco = rs.getString("qua_endereco");
			TipoQuadra tipo = UtilidadesConversao.transformaInteiroEmTipoQuadra(rs.getInt("qua_id_tipo"));
			boolean cobertura = rs.getBoolean("qua_cobertura");
			boolean arquibancada = rs.getBoolean("qua_arquibancada");
			boolean descanso = rs.getBoolean("qua_area_descanso");
			boolean bloqueada = rs.getBoolean("qua_bloqueado");
			Quadra quadra = new Quadra(nome, endereco, tipo, cobertura, arquibancada, descanso, bloqueada);
			quadrasLista.add(quadra);
		}
		
		List<Quadra> quadrasListaCopia = new ArrayList<>();
		quadrasListaCopia.addAll(quadrasLista);
		
		return quadrasListaCopia;
		
	}
	
	@Override
	public List<Quadra> obterQuadrasHabilitadas(boolean habilitado) throws IOException, SQLException{
		
		List<Quadra> quadraLista = new ArrayList<Quadra>();
		
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA");
		q.queriesQuadra.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("SELECT_DISABLE_QUADRA"));
		stmt.setBoolean(1, habilitado);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			String id = rs.getString("qua_id");
			String nome = rs.getString("qua_nome");
			String endereco = rs.getString("qua_endereco");
			int tipo = rs.getInt("qua_id_tipos");
			boolean coberta = rs.getBoolean("qua_cobertura");
			boolean arquibancada = rs.getBoolean("qua_arquibancada");
			boolean descanso = rs.getBoolean("qua_area_descanso");
			boolean bloqueada = rs.getBoolean("qua_bloqueado");
			Quadra quadra = new Quadra(id, nome, endereco, tipo, coberta, arquibancada, descanso, bloqueada);
			quadraLista.add(quadra);
		}
		
		//
		ConexaoBD.encerrarConexaoBD(null, stmt);
		
		return quadraLista;
	}
	
	@Override
	public List<Quadra> obterQuadraBloqueadas(boolean bloqueado){ 
		List<Quadra> quadrasLista = new ArrayList<>();
		
		try {
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA");
			q.queriesQuadra.load(in);
			in.close();
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("SELECT_ALL_BLOCKEDL_QUADRA"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				String nome = rs.getString("qua_nome");
				String endereco = rs.getString("qua_endereco");
				TipoQuadra tipo = UtilidadesConversao.transformaInteiroEmTipoQuadra(rs.getInt("qua_id_tipo"));
				boolean cobertura = rs.getBoolean("qua_cobertura");
				boolean arquibancada = rs.getBoolean("qua_arquibancada");
				boolean descanso = rs.getBoolean("qua_area_descanso");
				boolean bloqueada = rs.getBoolean("qua_bloqueado");
				Quadra quadra = new Quadra(nome, endereco, tipo, cobertura, arquibancada, descanso, bloqueada);
				quadrasLista.add(quadra);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		List<Quadra> quadrasListaCopia = new ArrayList<>();
		quadrasListaCopia.addAll(quadrasLista);
		
		return quadrasListaCopia;
		
	}
	@Override
	public Quadra obterQuadraPeloNome(String nome) throws CourtNotFoundException {
		
		Quadra qua = null;
		
		try {
			
			q.consultaQuadra();
			
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("SELECT_FROM_QUADRA_BY_QUA_NOME"));
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
					
				String nomeQuadra = rs.getString("qua_nome");
				String endereco = rs.getString("qua_endereco");
				TipoQuadra tipo = UtilidadesConversao.transformaInteiroEmTipoQuadra(rs.getInt("qua_id_tipo"));
				boolean cobertura = rs.getBoolean("qua_cobertura");
				boolean arquibancada = rs.getBoolean("qua_arquibancada");
				boolean descanso = rs.getBoolean("qua_area_descanso");
				boolean bloqueada = rs.getBoolean("qua_bloqueado");
				qua = new Quadra(nomeQuadra, endereco, tipo, cobertura, arquibancada, descanso, bloqueada); 
				
			}else {
				throw new CourtNotFoundException("Não foi encontrada nenhuma quadra com o nome: " + nome);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		return qua;
	}
	
	@Override
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
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("VERIFY_QUADRA_BY_QUA_NOME"));
			stmt.setString(1, qua.getNome());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				throw new CourtAlreadyRegisteredException("Uma quadra com esse nome já foi cadastrada!");
			}
		
			stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("INSERT_INTO_QUADRA"));
		
			stmt.setString(1, qua.getNome());
			stmt.setString(2, qua.getEndereco());
			stmt.setBoolean(3, qua.isPossuiCobertura());
			stmt.setBoolean(4, qua.isPossuiArquibancada());
			stmt.setBoolean(5, qua.isPossuiAreaDescanso());
			stmt.setInt(6, UtilidadesConversao.transformaTipoQuadraEmInteiro(qua.getTipo()));
	
			stmt.executeUpdate();
			
			return true;
		
	}catch(SQLException e) {

		e.printStackTrace();
		return false;
		
	}catch(IOException e) {

		e.printStackTrace();
		return false;
	}}
	
	@Override
	public boolean AlterarDadosQuadra(Quadra qua, String alteracao, int escolha) { 
		try {
			q.DMLQuadra();
			FileInputStream in = new FileInputStream("DML_QUADRA.properties");
			q.queriesQuadra.load(in);
			in.close();
			
			PreparedStatement stmt;
			
			switch(escolha) {
			
				case 1:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_NOME"));
					stmt.setString(1, alteracao);
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 2:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_ENDERECO"));
					stmt.setString(1, alteracao);
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 3:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_COBERTURA"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 4:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_ARQUIBANCADA"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 5:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_AREA_DESCANSO"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				case 6:
					stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("UPDATE_QUADRA_TIPO"));
					stmt.setBoolean(1, UtilidadesConversao.transformaString(alteracao));
					stmt.setString(2, qua.getNome());
					stmt.executeUpdate();
					break;
					
				default:
					UtilidadesGUI.exibeMensagem("Opção Inválida!");
					break;
			}
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean HabilitarQuadra(int id, boolean habilitado) { return false;}
	
	@Override
	public boolean BloquearQuadra(int id, boolean bloqueado) { return false;}
	
	@Override
	public boolean DeletarQuadra(int id) { return false;}
	
}
