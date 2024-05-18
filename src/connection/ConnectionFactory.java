package connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

	public class ConnectionFactory {

		public static Connection receberConexao() {
			Connection con = null;
	
			try {
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sanimesii?useSSL=false","root","root");
				System.out.println("Banco de Dados conectado com sucesso");
			} catch (SQLException e) {
				System.err.println("Nao foi possivel conectar ao banco de dados");
				e.printStackTrace();	
			}
			return con;
}
		public static void closeConnection(Connection con) {
			
				try {
					if (con != null) {
					con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				
			}
		}
		public static void closeConnection(Connection con, PreparedStatement stmt) {
			closeConnection(con);
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
				closeConnection(con, stmt);
				try {
					if(rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				
			}
		}
	
}