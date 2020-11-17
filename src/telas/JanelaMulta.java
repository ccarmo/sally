
package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


public class JanelaMulta extends JFrame {
        public JButton  btnTirarMulta, btnCancelar;
	JPanel pnlgrid;
        public JLabel lblTirarMulta; 
        
	public JTable grid;
	public DefaultTableModel dtm;
	JScrollPane scr;
        
	
	public JanelaMulta() {
        setTitle("Multas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        initComponents();
        initEvents();
 
        setSize(900, 500);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

	private void initComponents() {
		setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		
                
               
                
		
                
		
                
		
		
                //Botão Tirar Multa
                lblTirarMulta = new JLabel("Tirar multa selecionada:");
		lblTirarMulta.setBounds(300, 320, 150, 20);
		add(lblTirarMulta);
                
               
		
                //Botão de ação
                
                btnTirarMulta = new JButton("Tirar Multa");
		btnTirarMulta.setBounds(450, 320, 95, 25);
		btnTirarMulta.setBackground(new Color (240,248,255)); 
		btnTirarMulta.setToolTipText("Tirar Multa");
                btnTirarMulta.setEnabled(false);
		add(btnTirarMulta);
                
                btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(760, 400, 95, 25);
		btnCancelar.setBackground(new Color (240,248,255)); 
		btnCancelar.setToolTipText("Cancelar");
		add(btnCancelar);
                
		//Grid
		scr = new JScrollPane();
		
		pnlgrid = new JPanel(); //Painel
		pnlgrid.setBorder(new TitledBorder("Multas"));
		pnlgrid.setBackground(new Color(192, 192, 192));
		pnlgrid.setLayout(new BorderLayout());
		
		String[] colunas ={"N° Matrícula", "Nome", "Endereço", "Telefone", "Titulo", "Data Devolução", "Data Devolução Real", "Dias Multa", "Data Multa"};
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

		pnlgrid.setBounds(20, 20, 850, 260);
		add(pnlgrid);
		repaint();
		
	}
	
	private void initEvents(){
		
		
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
				btnTirarMulta.setEnabled(!lsm.isSelectionEmpty());
                                
				
			}
		});
		
	}
}
