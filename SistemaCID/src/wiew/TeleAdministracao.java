package wiew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeleAdministracao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeleAdministracao frame = new TeleAdministracao();
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
	public TeleAdministracao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeGerenciamento = new JLabel("Sistema de gerenciamento CID");
		lblSistemaDeGerenciamento.setFont(new Font("Arial", Font.BOLD, 18));
		lblSistemaDeGerenciamento.setBounds(220, 56, 283, 28);
		contentPane.add(lblSistemaDeGerenciamento);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 713, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastrarAluno = new JMenuItem("Cadastrar Aluno");
		mntmCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroAluno tcaluno = new TelaCadastroAluno();
				tcaluno.setVisible(true);
			}
		});
		mnCadastro.add(mntmCadastrarAluno);
		
		JMenuItem mntmPesquisarAluno = new JMenuItem("Pesquisar Aluno");
		mnCadastro.add(mntmPesquisarAluno);
		
		JMenuItem mntmAtualizarCadastro = new JMenuItem("Atualizar Cadastro");
		mnCadastro.add(mntmAtualizarCadastro);
		
		JMenuItem mntmExclurCadastro = new JMenuItem("Exclu\u00EDr Cadastro");
		mnCadastro.add(mntmExclurCadastro);
		
		JMenu mnTurmas = new JMenu("Turmas");
		menuBar.add(mnTurmas);
		
		JMenuItem mntmCadastrarTurmas = new JMenuItem("Cadastrar turma");
		mnTurmas.add(mntmCadastrarTurmas);
		
		JMenuItem mntmPesquisarTurmas = new JMenuItem("Pesquisar turma");
		mnTurmas.add(mntmPesquisarTurmas);
		
		JMenuItem mntmAtualizarTurmar = new JMenuItem("Atualizar turma");
		mnTurmas.add(mntmAtualizarTurmar);
		
		JMenuItem mntmExcluirTurma = new JMenuItem("Excluir turma");
		mnTurmas.add(mntmExcluirTurma);
		
		JMenu mnProfessor = new JMenu("Professor");
		menuBar.add(mnProfessor);
		
		JMenuItem mntmCadastrarProfessor = new JMenuItem("Cadastro de professores");
		mnProfessor.add(mntmCadastrarProfessor);
		
			
	}
}
