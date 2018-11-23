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
		
		String[] escolaridade = {"Ensino fundamental incompleto", "Ensino fundamental completo", "Ensino médio incompleto",
				"Ensino médio completo", "Ensino superior"};
		@SuppressWarnings("unchecked")
		JComboBox<?> cbEscolaridade = new JComboBox(escolaridade);
		cbEscolaridade.setFont(new Font("Arial", Font.PLAIN, 12));
		cbEscolaridade.setBounds(116, 288, 200, 20);
		contentPane.add(cbEscolaridade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(116, 339, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(229, 339, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(444, 172, 37, 14);
		contentPane.add(lblNewLabel_3);
		
		tfcpf = new JTextField();
		tfcpf.setBounds(491, 170, 161, 20);
		contentPane.add(tfcpf);
		tfcpf.setColumns(10);
	}
}
