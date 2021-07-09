package dados;
import java.sql.*;
public class ConexaoFactory {
	public Connection getConnection() {
		try {
		
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
			
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/pessoas", "root", "elymalote123");
			return conexao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
