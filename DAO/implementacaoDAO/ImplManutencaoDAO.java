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
import conexao.ConexaoBD;
import interfaceDAO.ManutencaoDAO;
import queries.QueriesManutencao;
import implementacaoDAO.ImplQuadraDAO;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

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
	public List<Manutencao> obterManutencoesPorData(LocalDate data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Manutencao> obterManutencoesPorDataHorario(LocalDate data,LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manutencao obterManutencaoPeloId(int id) {
		// TODO Auto-generated method stub
		return null;
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
