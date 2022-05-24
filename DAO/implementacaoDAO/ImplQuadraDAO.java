package implementacaoDAO;

import java.util.ArrayList;
import java.util.List;

import Dominio.Quadra;
import interfaceDAO.QuadraDAO;
import queries.QueriesQuadra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import conexao.ConexaoBD;


public class ImplQuadraDAO implements QuadraDAO{
	
	QueriesQuadra q = new QueriesQuadra(); 
	//TODO: consertar a diferen�a de tipagem de TipoQuadra 
	@Override
	public List<Quadra> obterTodasQuadras() throws IOException, SQLException{
		
		List<Quadra> quadrasLista = new ArrayList<>();
		FileInputStream in = new FileInputStream("QUERY_CONSULTA_QUADRA");
		q.queriesQuadra.load(in);
		in.close();
		PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(q.queriesQuadra.getProperty("SELECT_ALL_FROM_ALL_QUADRA"));
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Quadra quadra = new Quadra("","","",null,false,false,false);
			quadra.setCodigo(rs.getString("qua_id"));
			quadra.setNome(rs.getString("qua_nome"));
			quadra.setEndereco(rs.getString("qua_endereco"));
			quadra.setTipo(rs.getInt("qua_id_tipo"));
			quadra.setPossuiCobertura(rs.getBoolean("qua_cobertura"));
			quadra.setPossuiArquibancada(rs.getBoolean("qua_arquibancada"));
			quadra.setPossuiAreaDescanso(rs.getBoolean("qua_area_descanso"));
			quadra.setEstaBloqueada(rs.getBoolean("qua_bloqueado"));
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
	public List<Quadra> obterQuadraBloqueadas(boolean bloqueado){}
	
	@Override
	public Quadra obterQuadraPeloId(int id) {}
	
	@Override
	public boolean CadastrarQuadra(Quadra q) {}
	
	@Override
	public boolean AlterarDadosQuadra(String alteracao, int escolha) {}
	
	@Override
	public boolean HabilitarQuadra(int id, boolean habilitado) {}
	
	@Override
	public boolean BloquearQuadra(int id, boolean bloqueado) {}
	
	@Override
	public boolean DeletarQuadra(int id) {}
	
}
