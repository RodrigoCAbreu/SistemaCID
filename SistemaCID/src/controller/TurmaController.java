package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.GenericDAOException;
import dao.TurmaDAO;
import dao.TurmaDAOImpl;
import model.Turma;

public class TurmaController implements TableModel {
	
	private List<Turma> turma = new ArrayList<>();
	private TurmaDAO turmaDAO;
	
	public TurmaController() {
		turmaDAO = new TurmaDAOImpl();
	}
	
	public void adicionar(Turma t) {
		try {
			turmaDAO.adicionaTurma(t);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
	}
	
	public Turma consultaTurma(String nome) {
		try {
			turma = turmaDAO.consultaTurma();
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void removerTurma(Turma t) {
		try {
			turmaDAO.removerTurma(t);
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		
	}

	
	public Turma getTurmaFromRow(int row) {
		return turma.get(row);
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
		case 3 : return int.class;
		}
		return String.class;
	}

	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0 : return "Turma";
		case 1 : return "Hora de inicio";
		case 2 : return "Hora de Termino";
		case 3 : return "ID";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return turma.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Turma t = turma.get(row);
		switch (col) {
		case 0 : return t.getTurma();
		case 1 : return t.getHora1();
		case 2 : return t.getHora2();
		case 3 : return t.getId();
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

}
