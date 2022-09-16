import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection estabeleConexao() throws SQLException{
		Connection connection = DriverManager.
				getConnection
				("jdbc:mysql://168.138.232.255:3306/hotel_db?useTimezone=true&serverTimezone=UTC", "alquimista", "latam@");
		
		//System.out.println("Fechando conexão!");

		//conncetion.close();
		
		return connection;
	}

}
