package wiew;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.AlunoController;
import model.Aluno;


public class TelaPesquisaAluno extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AlunoController control = new AlunoController();
	private JTable table = new JTable(control);
	private JTextField tfNome;
	private JTextField tfData;
	private JTextField tfNomeMae;
	private JTextField tfTelefone;
	private JTextField tfCelular;
	private JTextField tfcpf;
	private JComboBox<String> cbEscolaridade = new JComboBox<>(Escolaridade);
	private final static String[] Escolaridade = {"Ensino fundamental incompleto", "Ensino fundamental completo", "Ensino médio incompleto",
			"Ensino médio completo", "Ensino superior"};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisaAluno frame = new TelaPesquisaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaPesquisaAluno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane panTable = new JScrollPane();
		panTable.setBounds(0, 0, 692, 432);
		
		
		JLabel lblNewLabel = new JLabel("Alunos cadastrados no sistema");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(231, 23, 248, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(70, 65, 46, 15);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNome.setBounds(138, 64, 396, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setBackground(Color.CYAN);
		btnPesquisar.setBounds(567, 65, 70, 22);
		contentPane.add(btnPesquisar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 112, 694, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 694, 290);
		panel.add(scrollPane);
		
		Panel panPrincipal = new Panel();
		scrollPane.setViewportView(panPrincipal);
		
		table.getSelectionModel().addListSelectionListener(this);
		
		btnPesquisar.addActionListener(this);
		panPrincipal.setLayout(null);
		panTable.setViewportView(table);
		panPrincipal.add(panTable);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Pesquisar".equals(cmd)) {
			Aluno a = control.consultaListaAluno(tfNome.getText());
			if ( a!= null ) {
				tfNome.setText(a.getNome());
			}
			alunoToBoundary( a );
			table.invalidate();
			table.revalidate();
			table.repaint();
		}
	}


	private void alunoToBoundary(Aluno a) {
		if (a != null) {
			tfNome.setText(String.valueOf(a.getNome()));
			tfData.setText(String.valueOf(a.getData()));
			tfNomeMae.setText(String.valueOf(a.getNomeMae()));
			tfcpf.setText(String.valueOf(a.getCpf()));
			tfTelefone.setText(String.valueOf(a.getTelefone()));
			tfCelular.setText(String.valueOf(a.getCelular()));
			cbEscolaridade.setSelectedItem(String.valueOf(a.getEscolaridade()));
		}
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Aluno a = control.getAlunoFromRow( table.getSelectedRow() );
		alunoToBoundary(a);
		
	}
}
	

