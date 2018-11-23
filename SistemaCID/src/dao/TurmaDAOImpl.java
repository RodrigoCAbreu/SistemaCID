package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Turma;

public class TurmaDAOImpl implements TurmaDAO {
	
	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();
	
	@Override
	public void adicionaTurma(Turma t) throws GenericDAOException {
		String sql = "INSERT INTO turmas (id, turma, hora1, hora2) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getId());
			pstmt.setString(2, t.getTurma());
			pstmt.setString(3, t.getHora1());
			pstmt.setString(4, t.getHora2());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizaTurma(Turma t) throws GenericDAOException {
		String sql = "UPDATE turmas SET turma = ?, hora1 = ?, hora2 = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTurma());
			pstmt.setString(2, t.getHora1());
			pstmt.setString(3, t.getHora2());
			pstmt.setInt(4, t.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void removerTurma(Turma t) throws GenericDAOException {
		String sql = "DELETE FROM turmas WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Turma consultaTurma(Turma t) throws GenericDAOException {
		String sql = "SELECT * FROM turmas WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				t.setId(rs.getInt("id"));
				t.setTurma(rs.getString("turma"));
				t.setHora1(rs.getString("hora1"));
				t.setHora2(rs.getString("hora2"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public List<Turma> consultaTurma() throws GenericDAOException {
		List<Turma> lista = new ArrayList<>();
		String sql = "SELECT id, turma, hora1, hora2 FROM turmas";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Turma t = new Turma();
				t.setId(rs.getInt("id"));
				t.setTurma(rs.getString("turma"));
				t.setHora1(rs.getString("hora1"));
				t.setHora2(rs.getString("hora2"));
				lista.add(t);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}

}
