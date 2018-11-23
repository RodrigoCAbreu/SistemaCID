package controller;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import dao.AlunoDAO;
import dao.AlunoDAOImpl;
import model.Aluno;

public class AlunoController {

	private JComboBox<Aluno> comboBox;
	private JTextField tfId;
	
	public AlunoController(JTextField tfId, JComboBox<Aluno> comboBox ) {
		this.tfId = tfId;
		this.comboBox = comboBox;
	}
	
	public AlunoController(JTextField tfId) {
		this.tfId = tfId;
	}
	
	public AlunoController(JComboBox<Aluno> comboBox) {
		this.comboBox = comboBox;
	}
	
	public void proximoId() {
		
		
		
		
	}

	public void listaAlunos() {
		
		
	}

}
