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

import Dominio.Quadra;
import Dominio.Reserva;
import Enum.TipoPagamento;
import Dominio.Cliente;
import Utilitario.UtilidadesConversao;
import queries.QueriesReservas;
import conexao.ConexaoBD;
import interfaceDAO.ReservaDAO;
import java.time.format.DateTimeFormatter;

public class ImplReservaDAO implements ReservaDAO {

	QueriesReservas qr = new QueriesReservas();
	ImplQuadraDAO quadraDAO = new ImplQuadraDAO();
	ImpClienteDAO clienteDAO = new ImpClienteDAO();
	DateTimeFormatter dataFormatoPadrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter horarioFormatoPadrao = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dataFormatoBD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter horarioFormatoBD = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Override
	public List<Reserva> obterTodasReservas() {
		
		List<Reserva> listaReservas = new ArrayList();
		
		try {
			qr.consultaReserva();
			FileInputStream in = new FileInputStream("QUERY_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("SELECT_ALL_FROM_RESERVA"));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Reserva r = montaReserva(rs);
				listaReservas.add(r);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaReservas;
	}

	@Override
	public List<Reserva> obterReservaPorPeriodo(LocalDate data, LocalTime horarioInicio, LocalTime horarioFim) {
		List<Reserva> listaReservas = new ArrayList();
		
		try {
			qr.consultaReserva();
			FileInputStream in = new FileInputStream("QUERY_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("SELECT_ALL_FROM_RESERVA_BY_DAY_AND_TIME"));
			stmt.setString(1, data.format(dataFormatoBD));
			stmt.setString(2, horarioInicio.format(horarioFormatoBD));
			stmt.setString(3, horarioFim.format(horarioFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Reserva r = montaReserva(rs);
				listaReservas.add(r);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaReservas;
	}

	@Override
	public List<Reserva> obterReservasPeloDia(LocalDate data) {
		List<Reserva> listaReservas = new ArrayList();
		
		try {
			qr.consultaReserva();
			FileInputStream in = new FileInputStream("QUERY_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("SELECT_ALL_FROM_RESERVA_BY_DAY"));
			stmt.setString(1, data.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Reserva r = montaReserva(rs);
				listaReservas.add(r);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaReservas;
	}
	
	@Override
	public List<Reserva> obterReservasPorPeriodoDeDias(LocalDate dataInicio, LocalDate dataFim){
		List<Reserva> listaReservas = new ArrayList();
		
		try {
			qr.consultaReserva();
			FileInputStream in = new FileInputStream("QUERY_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("SELECT_ALL_FROM_RESERVA_BY_INTERVAL_OF_DAYS"));
			stmt.setString(1, dataInicio.format(dataFormatoBD));
			stmt.setString(2, dataFim.format(dataFormatoBD));
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Reserva r = montaReserva(rs);
				listaReservas.add(r);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return listaReservas;
	}

	@Override
	public Reserva obterReservaPeloId(int id) {
		
		Reserva r = null;
		
		try {
			qr.consultaReserva();
			FileInputStream in = new FileInputStream("QUERY_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("SELECT_ALL_FROM_RESERVA_BY_ID"));
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				r = montaReserva(rs);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();

		}
		
		return r;
	}

	@Override
	public boolean registrarPagamento(Reserva r) {
		
		try {
			qr.consultaReserva();
			FileInputStream in = new FileInputStream("QUERY_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			qr.DMLReserva();
			in = new FileInputStream("DML_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("SELECT_ALL_FROM_RESERVA_BY_ID"));
			stmt.setInt(1, Integer.valueOf(r.getCodigo()));
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("REGISTER_CUSTOMER_PAYMENT"));
				stmt.setBoolean(1, true);
				stmt.executeUpdate();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			return false;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;

		}
		
		return true;
	}

	@Override
	public boolean registrarEntradaCliente(Reserva r) {
		
		try {
			qr.DMLReserva();
			FileInputStream in = new FileInputStream("DML_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("REGISTER_CUSTOMER_ENTRANCE"));
			
			stmt.setInt(1, Integer.valueOf(r.getCodigo()));
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

	@Override
	public boolean registrarSaidaCliente(Reserva r) {
		try {
			qr.DMLReserva();
			FileInputStream in = new FileInputStream("DML_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("REGISTER_CUSTOMER_EXIT"));
			
			stmt.setInt(1, Integer.valueOf(r.getCodigo()));
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

	@Override
	public boolean CadastrarReserva(Reserva r) {
		try {
			qr.DMLReserva();
			FileInputStream in = new FileInputStream("DML_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("INSERT_INTO_RESERVA"));
			
			stmt.setInt(1, Integer.valueOf(r.getCodigo()));
			stmt.setString(2, r.getHorarioInicio().format(horarioFormatoBD));
			stmt.setString(3, r.getHorarioFim().format(horarioFormatoBD));
			stmt.setString(4, r.getData().format(dataFormatoBD));
			stmt.setInt(5,  Integer.valueOf(r.getQuadra().getCodigo()));
			stmt.setInt(6, UtilidadesConversao.transformaTipoPagamentoEmInteiro(r.getModoPagamento()));
			stmt.setString(7, r.getParcelas());
			stmt.setFloat(8, Float.valueOf(r.calcularParcela(r.getQuadra().isPossuiCobertura(), Integer.valueOf(r.getParcelas()))));
			stmt.setNull(9, 0);
			stmt.setNull(10, 0);
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

	@Override
	public boolean DeletarReserva(int id) {
		try {
			qr.DMLReserva();
			FileInputStream in = new FileInputStream("DML_RESERVA.properties");
			qr.queriesReserva.load(in);
			in.close();
			
			PreparedStatement stmt = ConexaoBD.conectaBD().prepareStatement(qr.queriesReserva.getProperty("DELETE_FROM_RESERVA"));
			
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
	
	public Reserva montaReserva(ResultSet rs) throws SQLException {
		
		Quadra qua = quadraDAO.montaQuadra(rs);
		Cliente cli = clienteDAO.montaCliente(rs);
		String codigo = String.valueOf(rs.getInt("res_id"));
		String data = rs.getString("res_data");
		String horarioInicio = rs.getString("res_hr_inicio");
		String horarioFim = rs.getString("res_hr_fim");
		TipoPagamento formaPagamento = UtilidadesConversao.transformaInteiroEmTipoPagamento(rs.getInt("fp_id"));
		String parcelas = rs.getString("res_parcelas");
		String horarioClienteEntrou = rs.getString("res_cli_entrou");
		String horarioClienteFim = rs.getString("res_cli_saiu");
		data = LocalDate.parse(data, dataFormatoBD).format(dataFormatoPadrao);
		horarioInicio = LocalTime.parse(horarioInicio, horarioFormatoBD).format(horarioFormatoPadrao);	
		horarioFim = LocalTime.parse(horarioFim, horarioFormatoBD).format(horarioFormatoPadrao);
		
		return new Reserva(codigo, qua, cli, LocalDate.parse(data, dataFormatoPadrao), LocalTime.parse(horarioInicio, horarioFormatoPadrao), LocalTime.parse(horarioFim, horarioFormatoPadrao), formaPagamento, parcelas);
		
	}

}
