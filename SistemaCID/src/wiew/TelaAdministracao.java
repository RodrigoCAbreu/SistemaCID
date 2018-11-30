package wiew;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministracao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministracao frame = new TelaAdministracao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaAdministracao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSistemaDeGerenciamento = new JLabel("Sistema de gerenciamento CID");
		lblSistemaDeGerenciamento.setBounds(220, 56, 283, 28);
		lblSistemaDeGerenciamento.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblSistemaDeGerenciamento);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 713, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadastro = new JMenu("Alunos");
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
		mntmPesquisarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPesquisaAluno tpAluno = new TelaPesquisaAluno();
				tpAluno.setVisible(true);
			}
		});
		mnCadastro.add(mntmPesquisarAluno);
		
		JMenuItem mntmAtualizarCadastro = new JMenuItem("Atualizar Cadastro");
		mntmAtualizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizaAluno taAluno = new TelaAtualizaAluno();
				taAluno.setVisible(true);
			}
		});
		mnCadastro.add(mntmAtualizarCadastro);
		
		JMenuItem mntmExclurCadastro = new JMenuItem("Exclu\u00EDr Cadastro");
		mntmExclurCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluiAluno teAluno = new TelaExcluiAluno();
				teAluno.setVisible(true);
			}
		});
		mnCadastro.add(mntmExclurCadastro);
		
		JMenu mnTurmas = new JMenu("Turmas");
		menuBar.add(mnTurmas);
		
		JMenuItem mntmCadastrarTurmas = new JMenuItem("Cadastro de Turmas");
		mntmCadastrarTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroTurma tcturma = new TelaCadastroTurma();
				tcturma.setVisible(true);
			}
		});
		mnTurmas.add(mntmCadastrarTurmas);
		
		JMenuItem mntmPesquisarTurmas = new JMenuItem("Pesquisar Turmas");
		mntmPesquisarTurmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPesquisaTurma tpTurma = new TelaPesquisaTurma();
				tpTurma.setVisible(true);
			}
		});
		mnTurmas.add(mntmPesquisarTurmas);
		
		JMenuItem mntmExcluirTurma = new JMenuItem("Excluir");
		mnTurmas.add(mntmExcluirTurma);
		
		JMenu mnProfessor = new JMenu("Professor");
		menuBar.add(mnProfessor);
		
		JMenuItem mntmCadastrarProfessor = new JMenuItem("Controle de Professores");
		mntmCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProfessor tProfessor = new TelaProfessor();
				tProfessor.setVisible(true);
			}
		});
		mnProfessor.add(mntmCadastrarProfessor);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnProfessor.add(mntmExcluir);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSair.add(mntmSair);
		
			
	}
}
