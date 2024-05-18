package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.NIT.AnimeNIT;

public class ConexaoBD {

	public Statement stm;
	public ResultSet rs;
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://127.0.0.1:3306/sanimesii?useSSL=false";
	private String usuario = "root";
	private String senha = "root";
	public Connection con;

	public void conexao() {
		System.setProperty("jdbc.Drivers", driver);
		try {
			con = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Success");
		} catch (SQLException ex) {
			Logger.getLogger(AnimeNIT.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao se Conectar com o Banco de Dados:\n"+ex.getMessage());
		}
	}
	public void desconecta() {
		try {
			con.close();
			JOptionPane.showMessageDialog(null, "Desconectado com Sucesso");
		} catch (SQLException ex) {
			Logger.getLogger(AnimeNIT.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao se Desconectar com o Banco de Dados:\n"+ex.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	public void executaSQL(String sql) {
		try {
			stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			stm.execute(sql);
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			//JOptionPane.showMessageDialog(null, "Erro ao Executar SQL:\n"+ex.getMessage());
		}
	}
}
