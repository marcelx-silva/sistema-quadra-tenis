package implementacaoDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import Dominio.Quadra;
import Enum.DiaSemana;
import Utilitario.UtilidadesConversao;
import conexao.ConexaoBD;
import interfaceDAO.RelatorioDAO;
import queries.queriesRelatorio;

public class ImplRelatorioDAO implements RelatorioDAO {

	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	queriesRelatorio qr  = new queriesRelatorio();
	
	@Override
	public BigDecimal receitaPorDia(LocalDate data) {

		BigDecimal receitaDia = null;
		try {
			qr.consultaRelatorios();
			FileInputStream in = new FileInputStream(qr.queriesRelatorio.getProperty("QUERY_RELATORIOS.properties"));
			qr.queriesRelatorio.load(in);
			in.close();
			
			Connection con = ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(qr.queriesRelatorio.getProperty("RECEIPT_BY_DAY"));
			stmt.setString(1, data.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				receitaDia = rs.getBigDecimal("res_valor");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return receitaDia;
	}

	@Override
	public BigDecimal receitaPorPeridoDeDia(LocalDate dataInicio, LocalDate dataFim) {
		
		BigDecimal receitaDias = null;
		try {
			qr.consultaRelatorios();
			FileInputStream in = new FileInputStream(qr.queriesRelatorio.getProperty("QUERY_RELATORIOS.properties"));
			qr.queriesRelatorio.load(in);
			in.close();
			
			Connection con = ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(qr.queriesRelatorio.getProperty("RECEIPT_BY_INTERVAL_OF_DAYS"));
			stmt.setString(1, dataInicio.format(dataFormatoBD));
			stmt.setString(2, dataFim.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				receitaDias = rs.getBigDecimal("res_valor");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return receitaDias;
	}

	@Override
	public BigDecimal receitaPorPeridoDeDiaEQuadra(Quadra q, LocalDate dataInicio, LocalDate dataFim) {
		BigDecimal receitaDias = null;
		try {
			qr.consultaRelatorios();
			FileInputStream in = new FileInputStream(qr.queriesRelatorio.getProperty("QUERY_RELATORIOS.properties"));
			qr.queriesRelatorio.load(in);
			in.close();
			
			Connection con = ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(qr.queriesRelatorio.getProperty("RECEIPT_BY_QUA_ID_AND_INTERVAL_OF_DAYS"));
			stmt.setInt(1, Integer.valueOf(q.getCodigo()));
			stmt.setString(2, dataInicio.format(dataFormatoBD));
			stmt.setString(3, dataFim.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				receitaDias = rs.getBigDecimal("res_valor");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return receitaDias;
	}

	@Override
	public HashMap<DiaSemana, Integer> usoDasQuadrasPorDiaDaSemana(LocalDate dataInicio, LocalDate dataFim) {
		HashMap<DiaSemana, Integer> usoPorDia = null;
		
		try {
			qr.consultaRelatorios();
			FileInputStream in = new FileInputStream(qr.queriesRelatorio.getProperty("QUERY_RELATORIOS.properties"));
			qr.queriesRelatorio.load(in);
			in.close();
			
			Connection con = ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(qr.queriesRelatorio.getProperty("RESERVATION_BY_DAY_OF_WEEK"));
			stmt.setString(1, dataInicio.format(dataFormatoBD));
			stmt.setString(2, dataFim.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usoPorDia.put(UtilidadesConversao.transformaInteiroEmDiaSemana(rs.getInt("dia")), Integer.valueOf(rs.getInt("contagem")));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return usoPorDia;
	}

}
