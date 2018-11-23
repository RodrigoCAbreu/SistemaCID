package wiew;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaCadastroTurma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfturma;
	private JTextField tfHora;
	private JTextField tfHoras1;

	
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
		lblNewLabel.setBounds(177, 126, 46, 22);
		contentPane.add(lblNewLabel);
		
		tfturma = new JTextField();
		tfturma.setBounds(236, 128, 200, 20);
		contentPane.add(tfturma);
		tfturma.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Professor:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(160, 175, 63, 22);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<?> cbProfessor = new JComboBox<Object>();
		cbProfessor.setFont(new Font("Arial", Font.PLAIN, 12));
		cbProfessor.setBounds(236, 176, 200, 20);
		contentPane.add(cbProfessor);
		
		JLabel lblNewLabel_2 = new JLabel("Hor\u00E1rio:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(177, 279, 46, 22);
		contentPane.add(lblNewLabel_2);
		
		tfHora = new JTextField();
		tfHora.setBounds(236, 281, 40, 20);
		contentPane.add(tfHora);
		tfHora.setColumns(10);
		
		JButton btnCadastrarTurma = new JButton("Cadastrar");
		btnCadastrarTurma.setBounds(177, 345, 99, 23);
		contentPane.add(btnCadastrarTurma);
		
		JLabel lblNewLabel_3 = new JLabel("Dia:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(193, 240, 30, 14);
		contentPane.add(lblNewLabel_3);
		
		String[] diasSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};
		@SuppressWarnings("unchecked")
		JComboBox<?> comboBox = new JComboBox(diasSemana);
		comboBox.setBounds(236, 238, 200, 20);
		contentPane.add(comboBox);
		
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
		
		JButton btnCancelarTurma = new JButton("Cancelar");
		btnCancelarTurma.setBounds(302, 345, 99, 23);
		contentPane.add(btnCancelarTurma);
	}
}
