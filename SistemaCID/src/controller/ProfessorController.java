package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.GenericDAOException;
import dao.ProfessorDAO;
import dao.ProfessorDAOImpl;
import model.Professor;

public class ProfessorController implements TableModel {
	
	private List<Professor> professor = new ArrayList<>();
	private ProfessorDAO professorDAO;
	
	public ProfessorController() {
		professorDAO = new ProfessorDAOImpl();
	}
	
	public void adicionar(Professor p) {
		try {
			professorDAO.adicionaProfessor(p);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}
	
	public Professor consultaProfessor(String nome) {
		try {
			professor = professorDAO.consultaProfessor(nome);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void atualizarProfessor(Professor p) {
		try {
			professorDAO.atualizaProfessor(p);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		
	}

	public void removerProfessor(Professor p) {
		try {
			professorDAO.removerProfessor(p);
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
		case 0 : return int.class;
		case 1 : return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0 : return "ID";
		case 1 : return "Nome do professor";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return professor.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Professor p = professor.get(row);
		switch (col) {
		case 0 : return p.getId();
		case 1 : return p.getNome();
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

	public Professor getProfessorFromRow(int row) {
		
		return professor.get(row);
	}
	
}
