package wiew;

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

import controller.ProfessorController;
import model.Professor;

public class TelaProfessor extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private ProfessorController control = new ProfessorController();
	private JTable table = new JTable(control);
	private JTextField tfID;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfessor frame = new TelaProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProfessor = new JLabel("Cadastro de Professor");
		lblCadastroDeProfessor.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeProfessor.setBounds(237, 21, 203, 22);
		contentPane.add(lblCadastroDeProfessor);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(190, 76, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(258, 74, 371, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(65, 77, 46, 14);
		contentPane.add(lblId);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBounds(87, 74, 86, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(73, 131, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnPesquisar.setBounds(222, 130, 100, 24);
		contentPane.add(btnPesquisar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAtualizar.setBounds(375, 130, 100, 24);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExcluir.setBounds(540, 132, 89, 23);
		contentPane.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 175, 556, 227);
		contentPane.add(scrollPane);
		
		Panel panel = new Panel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		table.getSelectionModel().addListSelectionListener(this);
		
		btnCadastrar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnAtualizar.addActionListener(this);
		btnExcluir.addActionListener(this);
		
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Cadastrar".equals(cmd)) {
			Professor p = new Professor();
			p.setNome(tfNome.getText());
			control.adicionar(p);
			JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			table.invalidate();
			table.revalidate();
			table.repaint();
			tfNome.setText("");
		} else if ("Pesquisar".equals(cmd)) {
			Professor p = control.consultaProfessor(tfNome.getText());
			if ( p != null) {
				tfNome.setText(p.getNome());
			}
			table.invalidate();
			table.revalidate();
			table.repaint();
			tfNome.setText("");
		} else if ("Atualizar".equals(cmd)) {
			Professor p = new Professor();
			p.setId(Integer.parseInt(tfID.getText()));
			p.setNome(tfNome.getText());
			control.atualizarProfessor(p);
			JOptionPane.showMessageDialog(null, "Cadastro Atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			table.invalidate();
			table.revalidate();
			table.repaint();
			tfNome.setText("");
			tfID.setText("");
		} else {
			int conf = 0;
			conf = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir esse registro");
				if( conf == JOptionPane.YES_NO_OPTION) {
					Professor p = new Professor();
					p.setId(Integer.parseInt(tfID.getText()));
					control.removerProfessor(p);
					JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					table.invalidate();
					table.revalidate();
					table.repaint();
					tfID.setText("");
					tfNome.setText("");
				}
		}

		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Professor p = control.getProfessorFromRow( table.getSelectedRow());
		tfNome.setText(p.getNome());
		tfID.setText(String.valueOf(p.getId()));
	}
}
