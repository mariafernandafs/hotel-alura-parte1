import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HospedeDAO {
	
	private Connection connection;
	
	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarHospede(Hospede hospede) throws SQLException {
		String sql = "INSERT INTO hospede (nome, sobrenome, data_nascimento, nacionalidade, telefone) VALUES(?, ?, ?, ?, ?)";
				
		try(PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pst.setString(1, hospede.getNome());
			pst.setString(2, hospede.getSobrenome());
			pst.setDate(3, hospede.getData_nascimento());
			pst.setString(4, hospede.getNacionalidade());
			pst.setString(5, hospede.getTelefone());
			
			pst.execute();
			
			try(ResultSet rst = pst.getGeneratedKeys()){
				while(rst.next()) {
					hospede.setId(rst.getInt(1));
					
				}			
			}			
		}
	}
}

