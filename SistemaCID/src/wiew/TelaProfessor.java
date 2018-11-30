package wiew;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ProfessorController;
import model.Professor;

public class TelaProfessor extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ProfessorController control = new ProfessorController();
	private JTable table = new JTable(control);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfessor frame = new TelaProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProfessor = new JLabel("Cadastro de Professor");
		lblCadastroDeProfessor.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeProfessor.setBounds(237, 21, 203, 22);
		contentPane.add(lblCadastroDeProfessor);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(73, 76, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 74, 500, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(73, 131, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPesquisar.setBounds(172, 130, 100, 24);
		contentPane.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 175, 556, 227);
		contentPane.add(scrollPane);
		
		Panel panel = new Panel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table.getSelectionModel().addListSelectionListener(this);
		
		btnCadastrar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		scrollPane.setViewportView(table);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Cadastrar".equals(cmd)) {
			Professor p = new Professor();
			p.setNome(textField.getText());
			control.adicionar(p);
			table.invalidate();
			table.revalidate();
			table.repaint();
			textField.setText("");
		} else {
			Professor p = control.consultaProfessor(textField.getText());
			if ( p != null) {
				textField.setText(p.getNome());
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
			textField.setText("");
		}

		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Professor p = control.getProfessorFromRow( table.getSelectedRow());
		textField.setText(p.getNome());
	}
}
