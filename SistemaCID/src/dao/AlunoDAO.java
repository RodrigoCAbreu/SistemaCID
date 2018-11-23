package dao;

import java.util.List;

import model.Aluno;

public interface AlunoDAO {
	public void adicionaAluno(Aluno a) throws GenericDAOException; 
	public void atualizaAluno(Aluno a) throws GenericDAOException;
	public void removerAluno(Aluno a) throws GenericDAOException;
	public Aluno consultaAluno(Aluno a) throws GenericDAOException;
	public List<Aluno> consultaAluno(String nome) throws GenericDAOException;
}
