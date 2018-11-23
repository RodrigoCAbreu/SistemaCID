package wiew;

import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Professor;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class TelaCadastroProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField ftID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfessor frame = new TelaCadastroProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroProfessor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnCadastro = new JRadioButton("Cadastro");
		rdbtnCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnCadastro.setBounds(53, 39, 109, 23);
		contentPane.add(rdbtnCadastro);
		rdbtnCadastro.setSelected(true);
		
		JRadioButton rdbtnAtualizar = new JRadioButton("Atualizar");
		rdbtnAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnAtualizar.setBounds(300, 39, 109, 23);
		contentPane.add(rdbtnAtualizar);
		
		JRadioButton rdbtnExcluir = new JRadioButton("Excluir");
		rdbtnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnExcluir.setBounds(542, 39, 109, 23);
		contentPane.add(rdbtnExcluir);
		
		ButtonGroup btg = new ButtonGroup();
		btg.add(rdbtnExcluir);
		btg.add(rdbtnAtualizar);
		btg.add(rdbtnCadastro);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(69, 211, 53, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(125, 209, 269, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(87, 162, 46, 14);
		contentPane.add(lblId);
		
		ftID = new JTextField();
		ftID.setEditable(false);
		ftID.setBounds(125, 159, 269, 20);
		contentPane.add(ftID);
		ftID.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(132, 287, 109, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Lista:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(69, 112, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JComboBox<Professor> comboBox = new JComboBox<Professor>();
		comboBox.setBounds(125, 110, 269, 20);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
	}
}
