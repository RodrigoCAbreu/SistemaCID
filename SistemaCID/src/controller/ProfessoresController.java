package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import dao.GenericDAOException;
import dao.ProfessorDAO;
import dao.ProfessorDAOImpl;
import model.Professor;

public class ProfessoresController implements IProfessoresController, ActionListener {
	
	private JComboBox<Professor> comboBox;
	
	public ProfessoresController(JComboBox<Professor> comboBox) {
		this.comboBox = comboBox;
	}
	
	@Override
	public void ListaProfessores() {
		try {
			ProfessorDAO pDao = new ProfessorDAOImpl();
			List<Professor> listaProfessores = pDao.listaProfessores();
			if (comboBox.getItemCount() > 0) {
				comboBox.removeAllItems();
			}
			if (listaProfessores != null) {
				for (Professor p : listaProfessores) {
					comboBox.addItem(p);
				}
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (comboBox.getItemCount() > 0) {
			Professor p = (Professor) comboBox.getSelectedItem();	
		}
	}

}
