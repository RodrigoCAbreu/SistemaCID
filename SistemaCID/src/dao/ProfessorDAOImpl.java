package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAOImpl implements ProfessorDAO {

	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionaProfessor(Professor p) throws GenericDAOException {
		String sql = "INSERT INTO professor (id, nome) VALUES (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.setString(2, p.getNome());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizaProfessor(Professor p) throws GenericDAOException {
		String sql = "UPDATE professor SET nome = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getNome());
			pstmt.setInt(2, p.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void removerProfessor(Professor p) throws GenericDAOException {
		String sql = "DELETE FROM professor WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Professor consultaProfessor(Professor p) throws GenericDAOException {
		String sql = "SELECT * FROM professor WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Professor> consultaProfessor(String nome) throws GenericDAOException {
		List<Professor> lista = new ArrayList<>();
		String sql = "SELECT * FROM professor WHERE nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				lista.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<Professor> listaProfessores() throws GenericDAOException {
		List<Professor> listaProfessores = new ArrayList<Professor>();
		String sql = "SELECT id, nome FROM professor";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				listaProfessores.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
