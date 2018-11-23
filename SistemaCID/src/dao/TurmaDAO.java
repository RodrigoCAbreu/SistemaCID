package dao;

import java.util.List;
import model.Turma;

public interface TurmaDAO {
	public void adicionaTurma(Turma t) throws GenericDAOException; 
	public void atualizaTurma(Turma t) throws GenericDAOException;
	public void removerTurma(Turma t) throws GenericDAOException;
	public Turma consultaTurma(Turma t) throws GenericDAOException;
	public List<Turma> consultaTurma() throws GenericDAOException;
}
