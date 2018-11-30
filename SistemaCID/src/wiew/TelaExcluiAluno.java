package wiew;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.AlunoController;
import model.Aluno;


public class TelaExcluiAluno extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AlunoController control = new AlunoController();
	private JTable table = new JTable(control);
	private JTextField tfNome;
	private JTextField tfID;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluiAluno frame = new TelaExcluiAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaExcluiAluno() {
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
		
		tfID = new JTextField();
		tfID.setBounds(40, 65, 79, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(149, 67, 46, 15);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tfNome.setBounds(205, 64, 248, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setBackground(Color.CYAN);
		btnPesquisar.setBounds(474, 62, 70, 22);
		contentPane.add(btnPesquisar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setBounds(564, 63, 89, 23);
		contentPane.add(btnExcluir);
		
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
		btnExcluir.addActionListener(this);
		panPrincipal.setLayout(null);
		panTable.setViewportView(table);
		panPrincipal.add(panTable);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 68, 23, 14);
		contentPane.add(lblID);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Pesquisar".equals(cmd)) {
			Aluno a = control.consultaListaAluno(tfNome.getText());
			if ( a!= null ) {
				tfNome.setText(a.getNome());
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
		} 
			
		if ("Excluir".equals(cmd)) {
			int conf = 0;
			conf = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir esse registro");
				if( conf == JOptionPane.YES_NO_OPTION) {
					Aluno a = new Aluno();
					a.setId(Integer.parseInt(tfID.getText()));
					control.removerAluno(a);
					table.invalidate();
					table.revalidate();
					table.repaint();
					System.out.println("Aluno excluido com sucesso");
				}
		}
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Aluno a = control.getAlunoFromRow( table.getSelectedRow() );
		if (a != null) {
			tfNome.setText(String.valueOf(a.getNome()));
			tfID.setText(String.valueOf(a.getId()));
		}
	}
}
	

