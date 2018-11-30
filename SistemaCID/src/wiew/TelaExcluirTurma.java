package wiew;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controller.TurmaController;
import model.Turma;
import javax.swing.JButton;


public class TelaExcluirTurma extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TurmaController control = new TurmaController();
	private JTable table = new JTable(control);
	private JTextField tfTurma;
	private JTextField tfID;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirTurma frame = new TelaExcluirTurma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaExcluirTurma() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane panTable = new JScrollPane();
		panTable.setBounds(0, 0, 692, 432);
		
		
		JLabel lblNewLabel = new JLabel("Turmas cadastradas no sistema");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(231, 23, 248, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Turma:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(124, 67, 46, 15);
		contentPane.add(lblNome);
		
		tfTurma = new JTextField();
		tfTurma.setFont(new Font("Arial", Font.PLAIN, 12));
		tfTurma.setBounds(180, 64, 324, 20);
		contentPane.add(tfTurma);
		tfTurma.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(24, 62, 24, 14);
		contentPane.add(lblId);
		
		tfID = new JTextField();
		tfID.setBounds(55, 65, 46, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setBackground(Color.CYAN);
		btnPesquisar.setBounds(520, 62, 70, 22);
		contentPane.add(btnPesquisar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setBounds(601, 62, 89, 23);
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
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Pesquisar".equals(cmd)) {
			Turma t = control.consultaTurma(tfTurma.getText());
			if ( t!= null ) {
				tfTurma.setText(t.getTurma());
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
		}
		
		if ("Excluir".equals(cmd)) {
			int conf = 0;
			conf = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir esse registro");
			if( conf == JOptionPane.YES_NO_OPTION) {
				Turma t = new Turma();
				t.setId(Integer.parseInt(tfID.getText()));
				control.removerTurma(t);
				tfID.setText("");
				tfTurma.setText("");
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Turma t = control.getTurmaFromRow( table.getSelectedRow() );
		if (t != null) {
			tfTurma.setText(String.valueOf(t.getTurma()));
			tfID.setText(String.valueOf(t.getId()));
		}
	}
}
	

