package implementacaoDAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import Dominio.Manutencao;
import Dominio.Quadra;
import Enum.TipoQuadra;
import Exceptions.CourtNotFoundException;
import Exceptions.MaintenanceNotFoundException;
import Utilitario.UtilidadesConversao;
import Utilitario.UtilidadesGUI;
import conexao.ConexaoBD;
import interfaceDAO.ManutencaoDAO;
import queries.QueriesManutencao;
import implementacaoDAO.ImplQuadraDAO;
import java.time.format.DateTimeFormatter;

public class ImplManutencaoDAO implements ManutencaoDAO {

	QueriesManutencao qm = new QueriesManutencao();
	ImplQuadraDAO quadraDAO = new ImplQuadraDAO();
	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Override
	public List<Manutencao> obterTodasManutencoes() {
		
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			qm.consultaManutencao();
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Manutencao m = montaManutencao(rs);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaManutencoes;
	}

	@Override
	public List<Manutencao> obterManutencoesPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim) {
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			qm.consultaManutencao();
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_INTERVAL_OF_DAYS"));
			stmt.setString(1, dataInicio.format(dataFormatoBD));
			stmt.setString(2, dataFim.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Manutencao m = montaManutencao(rs);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaManutencoes;
	}

	@Override
	public List<Manutencao> obterManutencoesPorData(LocalDate dataManutencao) {
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			qm.consultaManutencao();
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY"));
			stmt.setString(1, dataManutencao.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Manutencao m = montaManutencao(rs);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaManutencoes;
	}
	
	@Override
	public List<Manutencao> obterManutencoesPorDataHorario(LocalDate dataManutencao,LocalTime horarioInicioM, LocalTime horarioFimM) {
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			qm.consultaManutencao();
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY_AND_TIME"));
			stmt.setString(1, dataManutencao.format(dataFormatoBD));
			stmt.setString(2, horarioInicioM.format(horarioFormatoBD));
			stmt.setString(3, horarioFimM.format(horarioFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Manutencao m = montaManutencao(rs);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaManutencoes;
	}

	@Override
	public Manutencao obterManutencaoPeloId(String id) throws MaintenanceNotFoundException{
		
		Manutencao m = null;
		try {
			qm.consultaManutencao();
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_ID"));
			stmt.setInt(1, Integer.valueOf(id));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				m = montaManutencao(rs);
			}else {
				throw new MaintenanceNotFoundException("Não foi encontrada nenhuma manutenção cadastrada com este código!");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return m;
	}

	@Override
	public boolean cadastrarManutencao(Manutencao m) {
		try {
			qm.DMLManutencao();
			FileInputStream in = new FileInputStream("DML_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("INSERT_INTO_MANUTENCAO"));
			
			stmt.setInt(1, Integer.valueOf(m.getCodigo()));
			stmt.setString(2, m.getDescricao());
			stmt.setString(3, m.getData().format(dataFormatoBD));
			stmt.setString(4, m.getHorarioInicio().format(horarioFormatoBD));
			stmt.setString(5, m.getHorarioFim().format(horarioFormatoBD));
			stmt.setBoolean(6, m.isPreventiva());
			stmt.setInt(7, Integer.valueOf(m.getQuadra().getCodigo()));		
			stmt.executeQuery();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean alterarDataManutencao(Manutencao m, String alteracao, int escolha) {
		try {
			qm.DMLManutencao();
			FileInputStream in = new FileInputStream("DML_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt;
			
			switch(escolha) {
			
				case 1:
					stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("UPDATE_MANUTENCAO_DESC"));
					stmt.setString(1, alteracao);
					stmt.setString(2, m.getCodigo());
					stmt.executeUpdate();
					break;
					
				case 2:
					stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("UPDATE_MANUTENCAO_DATA"));
					stmt.setString(1, alteracao);
					stmt.setString(2, m.getCodigo());
					stmt.executeUpdate();
					break;
					
				case 3:
					stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("UPDATE_MANUTENCAO_HORARIO_INICIO"));
					stmt.setString(1, String.valueOf(LocalTime.parse(alteracao, dataFormatoBD)));
					stmt.setString(2, m.getCodigo());
					stmt.executeUpdate();
					break;
					
				case 4:
					stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("UPDATE_MANUTENCAO_HORARIO_FIM"));
					stmt.setString(1, String.valueOf(LocalTime.parse(alteracao, dataFormatoBD)));
					stmt.setString(2, m.getCodigo());
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
	public boolean deletarManutencao(int id) {
		try {
			qm.DMLManutencao();
			FileInputStream in = new FileInputStream("DML_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("DELETE_FROM_MANUTENCAO"));
			
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		}catch(SQLException e) {

			e.printStackTrace();
			return false;
			
		}catch(IOException e) {

			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public Manutencao montaManutencao(ResultSet rs) throws SQLException {
		
		String codigo = rs.getString("m.man_id");
		String descricao = rs.getString("m.man_desc");
		String data = rs.getString("m.mand_data");
		String horarioInicio = rs.getString("m.man_hr_inicio");
		String horarioFim = rs.getString("m.man_hr_fim");
		boolean preventiva = rs.getBoolean("m.man_prev");
		
		Quadra qua = quadraDAO.montaQuadra(rs);
		
		String dataM = LocalDate.parse(data, dataFormatoBD).format(dataFormatoPadrao);
		horarioInicio = LocalTime.parse(horarioInicio, horarioFormatoBD).format(horarioFormatoPadrao);	
		horarioFim = LocalTime.parse(horarioFim, horarioFormatoBD).format(horarioFormatoPadrao);
		return new Manutencao(codigo, qua, LocalDate.parse(dataM, dataFormatoPadrao), LocalTime.parse(horarioInicio, horarioFormatoPadrao), LocalTime.parse(horarioFim, horarioFormatoPadrao), preventiva, descricao);
	}
}
