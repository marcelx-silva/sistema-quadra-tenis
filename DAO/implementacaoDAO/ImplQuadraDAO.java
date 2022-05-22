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
	
	public List<Quadra> obterQuadraHabilitadas(boolean habilitado){}
	
	public List<Quadra> obterQuadraBloqueadas(boolean bloqueado){}
	
	public Quadra obterQuadraPeloId(int id) {}
	
	public boolean CadastrarQuadra(Quadra q) {}
	
	public boolean AlterarDadosQuadra(String alteracao, int escolha) {}
	
	public boolean HabilitarQuadra(int id, boolean habilitado) {}
	
	public boolean BloquearQuadra(int id, boolean bloqueado) {}
	
	public boolean DeletarQuadra(int id) {}
	
}
