package dao;

import java.util.List;
import model.Professor;

public interface ProfessorDAO {
	public void adicionaProfessor(Professor p) throws GenericDAOException; 
	public void atualizaProfessor(Professor p) throws GenericDAOException;
	public void removerProfessor(Professor p) throws GenericDAOException;
	public Professor consultaProfessor(Professor p) throws GenericDAOException;
	public List<Professor> consultaProfessor(String nome) throws GenericDAOException;
}
