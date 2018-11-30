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

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		
		
	}

	@Override
	public Class<?> getColumnClass(int col) {
		switch (col) {
		case 0 : return String.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0 : return "Nome do Professor";
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
		case 0 : return p.getNome();
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
