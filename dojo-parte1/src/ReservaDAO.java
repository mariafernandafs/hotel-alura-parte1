import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservaDAO {
	
	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarReserva(Reserva reserva) throws SQLException {
		String sql = "INSERT INTO reserva (data_entrada, data_saida, valor, forma_pagamento) VALUES(?, ?, ?, ?)";
				
		try(PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pst.setDate(1, reserva.getData_entrada());
			pst.setDate(2, reserva.getData_saida());
			pst.setInt(3, reserva.getValor());
			pst.setString(4, reserva.getForma_pagamento());
			
			pst.execute();
			
			try(ResultSet rst = pst.getGeneratedKeys()){
				while(rst.next()) {
					reserva.setId(rst.getInt(1));
					
				}
				
			}
			
		}
	}
}