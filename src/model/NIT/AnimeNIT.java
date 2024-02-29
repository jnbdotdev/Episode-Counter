package model.NIT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Anime;

public class AnimeNIT {

	public void create(Anime a){
		
		Connection con = ConnectionFactory.receberConexao();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO anime (nome,temporada,episodio,dtproxep,dtultep,dtlancamento,status_anime,status_pessoal,tipo)VALUES(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, a.getNome());
			stmt.setInt(2, a.getTemporada());
			stmt.setInt(3, a.getEpisodio());
			stmt.setString(4, a.getDtProxEp());
			stmt.setString(5, a.getDtUltEp());
			stmt.setString(6, a.getDtLanc());
			stmt.setString(7, a.getStatusAnime());
			stmt.setString(8, a.getStatusPessoal());
			stmt.setString(9, a.getTipo());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			Logger.getLogger(AnimeNIT.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	public void alterar(Anime a) {
		
		Connection con = ConnectionFactory.receberConexao();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE anime SET nome=?, temporada=?,episodio=?,dtproxep=?,dtultep=?,dtlancamento=?,status_anime=?,status_pessoal=?,tipo=? WHERE codigo=?");
			stmt.setString(1, a.getNome());
			stmt.setInt(2, a.getTemporada());
			stmt.setInt(3, a.getEpisodio());
			stmt.setString(4, a.getDtProxEp());
			stmt.setString(5, a.getDtUltEp());
			stmt.setString(6, a.getDtLanc());
			stmt.setString(7, a.getStatusAnime());
			stmt.setString(8, a.getStatusPessoal());
			stmt.setString(9, a.getTipo());
			stmt.setInt(10, a.getCodigo());
			stmt.execute();
			
			
		} catch (SQLException e) {
			Logger.getLogger(AnimeNIT.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar");
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Anime> read(){
		
		Connection con = ConnectionFactory.receberConexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Anime> animes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM anime");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Anime anime = new Anime();
				anime.setCodigo(rs.getInt("codigo"));
				anime.setNome(rs.getString("nome"));
				anime.setTemporada(rs.getInt("temporada"));
				anime.setEpisodio(rs.getInt("episodio"));
				anime.setDtProxEp(rs.getString("dtproxep"));
				anime.setDtUltEp(rs.getString("dtultep"));
				anime.setDtLanc(rs.getString("dtlancamento"));
				anime.setStatusAnime(rs.getString("status_anime"));
				anime.setStatusPessoal(rs.getString("status_pessoal"));
				anime.setTipo(rs.getString("tipo"));
				animes.add(anime);
			}
		} catch (SQLException e) {
			Logger.getLogger(AnimeNIT.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro no carregamento");
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return animes;
		
	}
	
	public void excluirPorCodigo(int codigo) {
		
		Connection con = ConnectionFactory.receberConexao();
		
		String sql = "DELETE FROM anime WHERE codigo=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);

			preparador.execute();
			preparador.close();
			
			System.out.println("Anime excluído com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Anime> mostrarTodos(){
		ArrayList<Anime> animes = new ArrayList<>();
		
		Connection con = ConnectionFactory.receberConexao();
		String sql = "SELECT * FROM anime";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				
				Anime anime = new Anime();
				anime.setCodigo(resultado.getInt("codigo"));
				anime.setNome(resultado.getString("nome"));
				anime.setTemporada(resultado.getInt("temporada"));
				anime.setEpisodio(resultado.getInt("episodio"));
				anime.setDtProxEp(resultado.getString("dtproxep"));
				anime.setDtUltEp(resultado.getString("dtultep"));
				anime.setDtLanc(resultado.getString("dtlancamento"));
				anime.setStatusAnime(resultado.getString("status_anime"));
				anime.setStatusPessoal(resultado.getString("status_pessoal"));
				anime.setTipo(resultado.getString("tipo"));
				
				animes.add(anime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animes;
	}


}
