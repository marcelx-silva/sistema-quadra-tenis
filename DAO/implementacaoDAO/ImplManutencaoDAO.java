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
import Exceptions.CourtNotFoundException;
import Exceptions.MaintenanceNotFoundException;
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
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String codigo = rs.getString("m.man_id");
				String descricao = rs.getString("m.man_desc");
				String data = rs.getString("m.mand_data");
				String horarioInicio = rs.getString("m.man_hr_inicio");
				String horarioFim = rs.getString("m.man_hr_fim");
				boolean preventiva = rs.getBoolean("m.man_prev");
				String codigoQuadra = String.valueOf(rs.getInt("m.man_cod_quadra"));
				
				Quadra q = quadraDAO.obterQuadraPeloID(codigoQuadra);
				
				LocalTime horarioI = LocalTime.parse(horarioInicio, horarioFormatoPadrao);
				LocalTime horarioF = LocalTime.parse(horarioFim, horarioFormatoPadrao);
				LocalDate dataM = LocalDate.parse(data, dataFormatoPadrao);
				Manutencao m = new Manutencao(codigo, q, dataM, horarioI, horarioF, preventiva, descricao);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(CourtNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaManutencoes;
	}

	@Override
	public List<Manutencao> obterManutencoesPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim) {
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_INTERVAL_OF_DAYS"));
			stmt.setString(1, dataInicio.format(dataFormatoBD));
			stmt.setString(2, dataFim.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String codigo = rs.getString("m.man_id");
				String descricao = rs.getString("m.man_desc");
				String data = rs.getString("m.mand_data");
				String horarioInicio = rs.getString("m.man_hr_inicio");
				String horarioFim = rs.getString("m.man_hr_fim");
				boolean preventiva = rs.getBoolean("m.man_prev");
				String codigoQuadra = String.valueOf(rs.getInt("m.man_cod_quadra"));
				
				Quadra q = quadraDAO.obterQuadraPeloID(codigoQuadra);
				
				LocalTime horarioI = LocalTime.parse(horarioInicio, horarioFormatoPadrao);
				LocalTime horarioF = LocalTime.parse(horarioFim, horarioFormatoPadrao);
				LocalDate dataM = LocalDate.parse(data, dataFormatoPadrao);
				Manutencao m = new Manutencao(codigo, q, dataM, horarioI, horarioF, preventiva, descricao);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(CourtNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaManutencoes;
	}

	@Override
	public List<Manutencao> obterManutencoesPorData(LocalDate dataManutencao) {
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY"));
			stmt.setString(1, dataManutencao.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String codigo = rs.getString("m.man_id");
				String descricao = rs.getString("m.man_desc");
				String data = rs.getString("m.mand_data");
				String horarioInicio = rs.getString("m.man_hr_inicio");
				String horarioFim = rs.getString("m.man_hr_fim");
				boolean preventiva = rs.getBoolean("m.man_prev");
				String codigoQuadra = String.valueOf(rs.getInt("m.man_cod_quadra"));
				
				Quadra q = quadraDAO.obterQuadraPeloID(codigoQuadra);
				
				LocalTime horarioI = LocalTime.parse(horarioInicio, horarioFormatoPadrao);
				LocalTime horarioF = LocalTime.parse(horarioFim, horarioFormatoPadrao);
				LocalDate dataM = LocalDate.parse(data, dataFormatoPadrao);
				Manutencao m = new Manutencao(codigo, q, dataM, horarioI, horarioF, preventiva, descricao);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(CourtNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaManutencoes;
	}
	
	@Override
	public List<Manutencao> obterManutencoesPorDataHorario(LocalDate dataManutencao,LocalTime horarioInicioM, LocalTime horarioFimM) {
		List<Manutencao> listaManutencoes = new ArrayList();
		
		try {
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_DAY_AND_TIME"));
			stmt.setString(1, dataManutencao.format(dataFormatoBD));
			stmt.setString(2, horarioInicioM.format(horarioFormatoBD));
			stmt.setString(3, horarioFimM.format(horarioFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String codigo = rs.getString("m.man_id");
				String descricao = rs.getString("m.man_desc");
				String data = rs.getString("m.mand_data");
				String horarioInicio = rs.getString("m.man_hr_inicio");
				String horarioFim = rs.getString("m.man_hr_fim");
				boolean preventiva = rs.getBoolean("m.man_prev");
				String codigoQuadra = String.valueOf(rs.getInt("m.man_cod_quadra"));
				
				Quadra q = quadraDAO.obterQuadraPeloID(codigoQuadra);
				
				LocalTime horarioI = LocalTime.parse(horarioInicio, horarioFormatoPadrao);
				LocalTime horarioF = LocalTime.parse(horarioFim, horarioFormatoPadrao);
				LocalDate dataM = LocalDate.parse(data, dataFormatoPadrao);
				Manutencao m = new Manutencao(codigo, q, dataM, horarioI, horarioF, preventiva, descricao);
				listaManutencoes.add(m);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(CourtNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaManutencoes;
	}

	@Override
	public Manutencao obterManutencaoPeloId(String id) throws MaintenanceNotFoundException{
		
		Manutencao m = null;
		try {
			FileInputStream in = new FileInputStream("QUERY_CONSULTA_MANUTENCAO.properties");
			qm.queriesManutencao.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qm.queriesManutencao.getProperty("SELECT_ALL_FROM_MANUTENCAO_BY_ID"));
			stmt.setInt(1, Integer.valueOf(id));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String codigo = rs.getString("m.man_id");
				String descricao = rs.getString("m.man_desc");
				String data = rs.getString("m.mand_data");
				String horarioInicio = rs.getString("m.man_hr_inicio");
				String horarioFim = rs.getString("m.man_hr_fim");
				boolean preventiva = rs.getBoolean("m.man_prev");
				String codigoQuadra = String.valueOf(rs.getInt("m.man_cod_quadra"));
				
				Quadra q = quadraDAO.obterQuadraPeloID(codigoQuadra);
				
				LocalTime horarioI = LocalTime.parse(horarioInicio, horarioFormatoPadrao);
				LocalTime horarioF = LocalTime.parse(horarioFim, horarioFormatoPadrao);
				LocalDate dataM = LocalDate.parse(data, dataFormatoPadrao);
				m = new Manutencao(codigo, q, dataM, horarioI, horarioF, preventiva, descricao);
			}else {
				throw new MaintenanceNotFoundException("Não foi encontrada nenhuma manutenção cadastrada com este código!");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}catch(CourtNotFoundException e) {
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public boolean cadastrarManutencao(Manutencao m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarDataManutencao(Manutencao m, LocalDate data, LocalTime horarioInicio, LocalTime horarioFIm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarManutencao(Manutencao m) {
		// TODO Auto-generated method stub
		return false;
	}

}
