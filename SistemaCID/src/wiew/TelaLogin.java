package wiew;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLogin;
	private JPasswordField tfPass;

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
		
		tfLogin = new JTextField();
		tfLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		tfLogin.setBounds(259, 195, 246, 20);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenha.setBounds(204, 249, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (tfLogin.getText().equals("administrador") && tfPass.getText().equals("123456")) {
					TelaAdministracao tela = new TelaAdministracao();
					tela.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha inválido");
				}
			}
		});
		btnEntrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEntrar.setBounds(204, 310, 89, 23);
		contentPane.add(btnEntrar);
		
		tfPass = new JPasswordField();
		tfPass.setFont(new Font("Arial", Font.PLAIN, 12));
		tfPass.setBounds(259, 246, 246, 20);
		contentPane.add(tfPass);
	}
}
