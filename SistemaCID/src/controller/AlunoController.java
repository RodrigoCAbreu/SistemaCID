package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import dao.GenericDAOException;
import model.Aluno;

public class AlunoController implements TableModel {
	
	private List<Aluno> alunos = new ArrayList<>();
	private AlunoDAO alunoDAO;
	
	public AlunoController() {
		alunoDAO = new AlunoDAOImpl();
	}
	
	public void adicionar(Aluno a) {
		try {
			alunoDAO.adicionaAluno(a);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}
	
	public Aluno consultaListaAluno(String nome) {
		try {
			alunos = alunoDAO.consultaListaAluno(nome);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void removerAluno(Aluno a) {
		try {
			alunoDAO.removerAluno(a);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarAluno(Aluno a) {
		try {
			alunoDAO.atualizaAluno(a);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
		case 5 : return String.class;
		case 6 : return String.class;
		case 7 : return int.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0 : return "Nome:";
		case 1 : return "Nascimento:";
		case 2 : return "Nome da M�e:";
		case 3 : return "CPF:";
		case 4 : return "Telefone:";
		case 5 : return "Celular:";
		case 6 : return "Escolaridade:";
		case 7 : return "ID";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return alunos.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Aluno a = alunos.get(row);
		switch (col) {
			case 0 : return a.getNome();
			case 1 : return a.getData();
			case 2 : return a.getNomeMae();
			case 3 : return a.getCpf();
			case 4 : return a.getTelefone();
			case 5 : return a.getCelular();
			case 6 : return a.getEscolaridade();
			case 7 : return a.getId();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		
		
	}

	public Aluno getAlunoFromRow(int row) {
		
		return alunos.get(row);
	}
	
}
