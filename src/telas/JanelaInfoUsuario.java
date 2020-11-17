
package telas;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controles.*;

public class JanelaInfoUsuario extends JFrame{
   
	
	public JButton btnSair, btnEditar, btnExcluir;
	JPanel pnlgrid;
	public JTable grid;
	public DefaultTableModel dtm;
	JScrollPane scr;
	
	public JanelaInfoUsuario() {
        setTitle("Pesquisa de Usuários");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        initComponents();
        initEvents();
 
        setSize(800, 500);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

	private void initComponents() {
		setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(20, 20, 100, 30);
		btnEditar.setBackground(new Color (240,248,255)); 
		btnEditar.setToolTipText("Editar dados do cliente selecionado");
		btnEditar.setEnabled(false);
		add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(123, 20, 100, 30);
		btnExcluir.setBackground(new Color (240,248,255));
		btnExcluir.setToolTipText("Excluir cliente selecionado");
		btnExcluir.setEnabled(false);
		add(btnExcluir);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(226, 20, 100, 30);
		btnSair.setBackground(new Color (240,248,255));
		add(btnSair);
		
		
		scr = new JScrollPane();
		
		pnlgrid = new JPanel(); 
		pnlgrid.setBorder(new TitledBorder("Clientes"));
		pnlgrid.setBackground(new Color(192,192,192));
		pnlgrid.setLayout(new BorderLayout());
		
		String[] colunas ={"Nº de Matrícula","Nome", "Endereço", "Email", "CPF","Data de Nascimento","Telefone","Status" };
		dtm = new DefaultTableModel(colunas, 0){ 
			
			@Override
			public boolean isCellEditable(int row, int col) {
					return false;
			}
		};
		
		grid = new JTable(dtm);
		grid.setBackground(new Color(240,248,255));
		
		for (int i = 0; i < colunas.length; i++) {
			grid.getColumnModel().getColumn(i).setPreferredWidth(200); 
			grid.getColumnModel().getColumn(i).setResizable(false);
		}
		grid.getTableHeader().setReorderingAllowed(false);
		
		DefaultTableCellRenderer alinCentro = new DefaultTableCellRenderer();
		alinCentro.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i = 0; i < colunas.length; i++) {
			grid.getColumnModel().getColumn(i).setCellRenderer(alinCentro);
		}
		
		grid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		grid.setCellSelectionEnabled(false);
		grid.setRowSelectionAllowed(true);
		
		pnlgrid.add(grid);
		pnlgrid.add(scr);
		scr.setViewportView(grid);

		pnlgrid.setBounds(20, 80, 750, 360);
		add(pnlgrid);
		repaint();
		
	}
	
	private void initEvents(){
		btnSair.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		grid.getSelectionModel().addListSelectionListener(
				
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							return;
						}
					}
		});
		
		grid.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				btnEditar.setEnabled(!lsm.isSelectionEmpty());
				btnExcluir.setEnabled(!lsm.isSelectionEmpty());
			}
		});
		
	}
}
