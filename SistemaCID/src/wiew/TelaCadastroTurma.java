package wiew;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ProfessoresController;
import controller.TurmaController;
import model.Professor;
import model.Turma;

public class TelaCadastroTurma extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfturma;
	private JTextField tfHora;
	private JTextField tfHoras1;
	private JComboBox<String> cbDiaSemana = new JComboBox<>(DiaSemana);
	private final static String[] DiaSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};
	private TurmaController control = new TurmaController();
	private JTable table = new JTable(control);
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTurma frame = new TelaCadastroTurma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroTurma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeTurmas = new JLabel("Cadastro de turmas");
		lblCadastroDeTurmas.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeTurmas.setBounds(236, 54, 178, 31);
		contentPane.add(lblCadastroDeTurmas);
		
		JLabel lblNewLabel = new JLabel("Turma:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(160, 126, 46, 22);
		contentPane.add(lblNewLabel);
		
		tfturma = new JTextField();
		tfturma.setBounds(236, 128, 347, 20);
		contentPane.add(tfturma);
		tfturma.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Professor:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(160, 175, 63, 22);
		contentPane.add(lblNewLabel_1);
		
		
//		cbProfessor.setFont(new Font("Arial", Font.PLAIN, 12));
//		cbProfessor.setBounds(236, 176, 347, 20);
//		contentPane.add(cbProfessor);
		
		JLabel lblNewLabel_2 = new JLabel("Hor\u00E1rio:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(160, 279, 46, 22);
		contentPane.add(lblNewLabel_2);
		
		tfHora = new JTextField();
		tfHora.setBounds(236, 281, 40, 20);
		contentPane.add(tfHora);
		tfHora.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Dia:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(160, 232, 30, 14);
		contentPane.add(lblNewLabel_3);
	
		cbDiaSemana.setFont(new Font("Arial", Font.PLAIN, 12));
		cbDiaSemana.setBounds(236, 238, 347, 20);
		contentPane.add(cbDiaSemana);
		
		JLabel lbls = new JLabel("horas \u00E0s");
		lbls.setFont(new Font("Arial", Font.PLAIN, 12));
		lbls.setBounds(286, 283, 66, 14);
		contentPane.add(lbls);
		
		tfHoras1 = new JTextField();
		tfHoras1.setBounds(345, 281, 40, 20);
		contentPane.add(tfHoras1);
		tfHoras1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("horas");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(402, 284, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnCadastrarTurma = new JButton("Cadastrar");
		btnCadastrarTurma.setBounds(160, 345, 99, 23);
		contentPane.add(btnCadastrarTurma);
		btnCadastrarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if ("Cadastrar".equals(cmd)) {
					Turma t = new Turma();
					t.setTurma(tfturma.getText());
					//Falta pegar ComboBox
					t.setHora1(tfHora.getText());
					t.setHora2(tfHoras1.getText());
					control.adicionar(t);
					table.invalidate();
					table.revalidate();
					table.repaint();
					System.out.println("cadastro adicionado com sucesso");
					tfturma.setText("");
					tfHora.setText("");
					tfHoras1.setText("");
				}
			}
		});
		
		JButton btnCancelarTurma = new JButton("Cancelar");
		btnCancelarTurma.setBounds(269, 345, 99, 23);
		contentPane.add(btnCancelarTurma);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
