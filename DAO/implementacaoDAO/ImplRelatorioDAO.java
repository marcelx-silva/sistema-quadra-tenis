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
		
		BigDecimal receitaDia = null;
		try {
			qr.consultaRelatorios();
			FileInputStream in = new FileInputStream(qr.queriesRelatorio.getProperty("QUERY_RELATORIOS.properties"));
			qr.queriesRelatorio.load(in);
			in.close();
			
			Connection con = ConexaoBD.conectaBD();
			PreparedStatement stmt = con.prepareStatement(qr.queriesRelatorio.getProperty("RECEIPT_BY_DAY"));
			stmt.setString(1, dataInicio.format(dataFormatoBD));
			stmt.setString(2, dataFim.format(dataFormatoBD));
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
	public BigDecimal receitaPorPeridoDeDiaEQuadra(Quadra q, LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<DiaSemana, Integer> usoDasQuadrasPorDiaDaSemana(LocalDate dataInicio, LocalDate dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

}
