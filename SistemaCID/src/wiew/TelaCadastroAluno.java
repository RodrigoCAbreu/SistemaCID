package wiew;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import model.Aluno;

public class TelaCadastroAluno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Inscri\u00E7\u00E3o CID");
	private JTextField tfNome;
	private JTextField tfData;
	private JTextField tfNomeMae;
	private JTextField tfTelefone;
	private JTextField tfCelular;
	private JTextField tfcpf;
	private JComboBox<String> cbEscolaridade = new JComboBox<>(Escolaridade);
	private final static String[] Escolaridade = {"Ensino fundamental incompleto", "Ensino fundamental completo", "Ensino médio incompleto",
			"Ensino médio completo", "Ensino superior"};
	private AlunoController control = new AlunoController();
	private JTable table = new JTable(control);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCadastroAluno() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(266, 43, 144, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(69, 113, 37, 14);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNome.setBounds(116, 111, 200, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data Nascimento:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(373, 113, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		tfData = new JTextField();
		tfData.setFont(new Font("Arial", Font.PLAIN, 12));
		tfData.setBounds(491, 110, 161, 20);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da m\u00E3e:");
		lblNomeDaMe.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeDaMe.setBounds(25, 172, 82, 14);
		contentPane.add(lblNomeDaMe);
		
		tfNomeMae = new JTextField();
		tfNomeMae.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNomeMae.setBounds(116, 170, 200, 20);
		contentPane.add(tfNomeMae);
		tfNomeMae.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(55, 228, 51, 14);
		contentPane.add(lblNewLabel_2);
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		tfTelefone.setBounds(116, 226, 200, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(435, 228, 46, 14);
		contentPane.add(lblCelular);
		
		tfCelular = new JTextField();
		tfCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		tfCelular.setBounds(491, 225, 161, 20);
		contentPane.add(tfCelular);
		tfCelular.setColumns(10);
		
		JLabel lblEscolaridade = new JLabel("Escolaridade:");
		lblEscolaridade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEscolaridade.setBounds(25, 290, 76, 14);
		contentPane.add(lblEscolaridade);
		
		cbEscolaridade.setFont(new Font("Arial", Font.PLAIN, 12));
		cbEscolaridade.setBounds(116, 288, 200, 20);
		contentPane.add(cbEscolaridade);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(444, 172, 37, 14);
		contentPane.add(lblNewLabel_3);
		
		tfcpf = new JTextField();
		tfcpf.setBounds(491, 170, 161, 20);
		contentPane.add(tfcpf);
		tfcpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if ("Cadastrar".equals(cmd)) {
					Aluno a = new Aluno();
					a.setNome(tfNome.getText());
					a.setData(tfData.getText());
					a.setNomeMae(tfNomeMae.getText());
					a.setCpf(tfcpf.getText());
					a.setTelefone(tfTelefone.getText());
					a.setCelular(tfCelular.getText());
					a.setEscolaridade(Escolaridade[cbEscolaridade.getSelectedIndex()]);
					control.adicionar(a);
					JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					table.invalidate();
					table.revalidate();
					table.repaint();
					System.out.println("cadastro adicionado com sucesso");
					tfNome.setText("");
					tfData.setText("");
					tfNomeMae.setText("");
					tfcpf.setText("");
					tfTelefone.setText("");
					tfCelular.setText("");
				}
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(116, 339, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(229, 339, 89, 23);
		contentPane.add(btnCancelar);
	}
}
