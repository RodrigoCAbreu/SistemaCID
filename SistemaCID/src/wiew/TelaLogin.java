package wiew;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLoginUsuario;
	private JPasswordField psfLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeInscrio = new JLabel("Sistema de gerenciamento CID");
		lblSistemaDeInscrio.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblSistemaDeInscrio.setBounds(204, 58, 322, 41);
		contentPane.add(lblSistemaDeInscrio);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(204, 131, 81, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsurio.setBounds(204, 197, 57, 14);
		contentPane.add(lblUsurio);
		
		tfLoginUsuario = new JTextField();
		tfLoginUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		tfLoginUsuario.setBounds(259, 195, 246, 20);
		contentPane.add(tfLoginUsuario);
		tfLoginUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenha.setBounds(204, 249, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEntrar.setBounds(204, 310, 89, 23);
		contentPane.add(btnEntrar);
		
		psfLogin = new JPasswordField();
		psfLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		psfLogin.setBounds(259, 246, 246, 20);
		contentPane.add(psfLogin);
	}
}
