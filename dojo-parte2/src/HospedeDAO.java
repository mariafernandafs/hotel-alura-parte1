import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Hospede> listarHospedes() throws SQLException {
		String sql = "SELECT * FROM hospede";
		List<Hospede> listaHospedes = new ArrayList<Hospede>();
		
		try(PreparedStatement pst = connection.prepareStatement(sql)){
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				Hospede hospede = new Hospede(rst.getInt("id"), rst.getString("nome"), rst.getString("sobrenome"),
						rst.getDate("data_nascimento"), rst.getString("nacionalidade"), rst.getString("telefone"));
				listaHospedes.add(hospede);
			}
			
		}
		return listaHospedes;
	}
	
	public List<Hospede> listarHospedePorNome(String nome) throws SQLException {
		String sql = "SELECT * FROM hospede where nome=?";
		List<Hospede> listaHospedes = new ArrayList<Hospede>(); 

		try(PreparedStatement pst = connection.prepareStatement(sql)){
			pst.setString(1, nome);
			
				ResultSet rst = pst.executeQuery();
				
				while(rst.next()) {
					Hospede hospede = new Hospede(rst.getInt("id"), rst.getString("nome"), rst.getString("sobrenome"),
							rst.getDate("data_nascimento"), rst.getString("nacionalidade"), rst.getString("telefone"));
					listaHospedes.add(hospede);
				}
		
		}
		return listaHospedes;
	}
}

