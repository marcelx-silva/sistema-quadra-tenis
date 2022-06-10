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
import Exceptions.CourtNotFoundException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva obterReservaPeloId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registrarPagamento(Reserva r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarEntradaCliente(Reserva r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarSaidaCliente(Reserva r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CadastrarReserva(Reserva r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeletarReserva(int id) {
		// TODO Auto-generated method stub
		return false;
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
		
		return new Reserva(codigo, qua, cli, LocalDate.parse(data, dataFormatoPadrao), LocalTime.parse(horarioInicio, horarioFormatoPadrao), LocalTime.parse(horarioFim, horarioFormatoPadrao), formaPagamento, parcelas);
		
	}

}
