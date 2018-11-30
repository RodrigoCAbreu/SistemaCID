package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {
	
	ConnectionSingleton conSing = ConnectionSingleton.getInstancy();
	Connection con = conSing.getcon();

	@Override
	public void adicionaAluno(Aluno a) throws GenericDAOException {
		String sql = "INSERT INTO aluno (id, nome, data, nomeMae, cpf, telefone, celular, escolaridade)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a.getId());
			pstmt.setString(2, a.getNome());
			pstmt.setString(3, a.getData());
			pstmt.setString(4, a.getNomeMae());
			pstmt.setString(5, a.getCpf());
			pstmt.setString(6, a.getTelefone());
			pstmt.setString(7, a.getCelular());
			pstmt.setString(8, a.getEscolaridade());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void atualizaAluno(Aluno a) throws GenericDAOException {
		String sql = "UPDATE aluno SET nome = ?, data = ?, nomeMae = ?, cpf = ?, telefone = ?, celular = ?,"
				+ "escolaridade = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a.getNome());
			pstmt.setString(2, a.getData());
			pstmt.setString(3, a.getNomeMae());
			pstmt.setString(4, a.getCpf());
			pstmt.setString(5, a.getTelefone());
			pstmt.setString(6, a.getCelular());
			pstmt.setString(7, a.getEscolaridade());
			pstmt.setInt(8, a.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void removerAluno(Aluno a) throws GenericDAOException {
		String sql = "DELETE FROM aluno WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Aluno consultaAluno(Aluno a) throws GenericDAOException {
		String sql = "SELECT * FROM aluno WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, a.getId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setData(rs.getString("data"));
				a.setNomeMae(rs.getString("nomeMae"));
				a.setCpf(rs.getString("cpf"));
				a.setTelefone(rs.getString("telefone"));
				a.setCelular(rs.getString("celular"));
				a.setEscolaridade(rs.getString("escolaridade"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Aluno> consultaListaAluno(String nome) throws GenericDAOException {
		List<Aluno> alunos = new ArrayList<>();
		String sql = "SELECT * FROM aluno WHERE nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + nome + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("nome"));
				a.setData(rs.getString("data"));
				a.setNomeMae(rs.getString("nomeMae"));
				a.setCpf(rs.getString("cpf"));
				a.setTelefone(rs.getString("telefone"));
				a.setCelular(rs.getString("celular"));
				a.setEscolaridade(rs.getString("escolaridade"));
				alunos.add(a);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return alunos;
	}

}
