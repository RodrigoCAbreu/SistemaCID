package wiew;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.AlunoController;
import model.Aluno;
import java.awt.Panel;
import javax.swing.JScrollPane;

public class TelaAtualizaAluno extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Atualiza\u00E7\u00E3o de Cadastro");
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
	private JTextField tfID;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizaAluno frame = new TelaAtualizaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaAtualizaAluno() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(227, 11, 216, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(55, 84, 37, 14);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNome.setBounds(116, 84, 200, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data Nascimento:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(373, 87, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		tfData = new JTextField();
		tfData.setFont(new Font("Arial", Font.PLAIN, 12));
		tfData.setBounds(491, 84, 161, 20);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		JLabel lblNomeDaMe = new JLabel("Nome da m\u00E3e:");
		lblNomeDaMe.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeDaMe.setBounds(25, 138, 82, 14);
		contentPane.add(lblNomeDaMe);
		
		tfNomeMae = new JTextField();
		tfNomeMae.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNomeMae.setBounds(116, 135, 200, 20);
		contentPane.add(tfNomeMae);
		tfNomeMae.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(55, 185, 51, 14);
		contentPane.add(lblNewLabel_2);
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		tfTelefone.setBounds(116, 185, 200, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCelular.setBounds(435, 185, 46, 14);
		contentPane.add(lblCelular);
		
		tfCelular = new JTextField();
		tfCelular.setFont(new Font("Arial", Font.PLAIN, 12));
		tfCelular.setBounds(491, 185, 161, 20);
		contentPane.add(tfCelular);
		tfCelular.setColumns(10);
		
		JLabel lblEscolaridade = new JLabel("Escolaridade:");
		lblEscolaridade.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEscolaridade.setBounds(31, 235, 76, 14);
		contentPane.add(lblEscolaridade);
		
		cbEscolaridade.setFont(new Font("Arial", Font.PLAIN, 12));
		cbEscolaridade.setBounds(116, 235, 200, 20);
		contentPane.add(cbEscolaridade);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(444, 138, 37, 14);
		contentPane.add(lblNewLabel_3);
		
		tfcpf = new JTextField();
		tfcpf.setBounds(491, 136, 161, 20);
		contentPane.add(tfcpf);
		tfcpf.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPesquisar.setBounds(116, 274, 95, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtualizar.setBounds(227, 274, 95, 23);
		contentPane.add(btnAtualizar);
		
		btnPesquisar.addActionListener(this);
		btnAtualizar.addActionListener(this);
		table.getSelectionModel().addListSelectionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 714, 141);
		contentPane.add(scrollPane);
		
		Panel panel = new Panel();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(455, 235, 26, 14);
		contentPane.add(lblNewLabel_4);
		
		tfID = new JTextField();
		tfID.setBounds(491, 233, 161, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		panel.setLayout(null);
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
		
		if ("Atualizar".equals(cmd)) {
			Aluno a = new Aluno();
			a.setNome(tfNome.getText());
			a.setData(tfData.getText());
			a.setNomeMae(tfNomeMae.getText());
			a.setCpf(tfcpf.getText());
			a.setTelefone(tfTelefone.getText());
			a.setCelular(tfCelular.getText());
			a.setEscolaridade(Escolaridade[cbEscolaridade.getSelectedIndex()]);
			a.setId(Integer.parseInt(tfID.getText()));
			control.atualizarAluno(a);
			table.invalidate();
			table.revalidate();
			table.repaint();
			System.out.println("cadastro Atualizado com sucesso");
			tfNome.setText("");
			tfData.setText("");
			tfNomeMae.setText("");
			tfcpf.setText("");
			tfTelefone.setText("");
			tfCelular.setText("");
			tfID.setText("");
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
			tfID.setText(String.valueOf(a.getId()));
		}
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Aluno a = control.getAlunoFromRow( table.getSelectedRow() );
		alunoToBoundary(a);
	}
}
