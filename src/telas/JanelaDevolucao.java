
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


public class JanelaDevolucao extends JFrame {
        public JButton  btnDevolucao, btnLimpar, btnCancelar;
	JPanel pnlgrid;
        public JLabel lbldtDevolucao; 
        
	public JTable grid;
	public DefaultTableModel dtm;
	JScrollPane scr;
        public JFormattedTextField txtDigitaDevolucao;
        MaskFormatter  mskDataDevolucao;
	
	public JanelaDevolucao() {
        setTitle("Gerenciamento de Devoluções");
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
		
                
               
                
		
                
		
                
		
		
                //Adicionar data de devolução
                lbldtDevolucao = new JLabel("Data de Devolução:");
		lbldtDevolucao.setBounds(300, 320, 150, 20);
		add(lbldtDevolucao);
                 try {
			mskDataDevolucao = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
                txtDigitaDevolucao = new JFormattedTextField(mskDataDevolucao);
		txtDigitaDevolucao.setBounds(420, 320, 70, 20);
		add(txtDigitaDevolucao);
		
                //Botões de ações
                btnDevolucao = new JButton("Devolução Livro");
		btnDevolucao.setBounds(500, 400, 150, 25);
		btnDevolucao.setBackground(new Color (240,248,255)); 
		btnDevolucao.setToolTipText("Devolução livro");
                btnDevolucao.setEnabled(false);
		add(btnDevolucao);
                
                btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(660, 400, 95, 25);
		btnLimpar.setBackground(new Color (240,248,255)); 
		btnLimpar.setToolTipText("Limpar dados adicionados");
		add(btnLimpar);
                
                btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(760, 400, 95, 25);
		btnCancelar.setBackground(new Color (240,248,255)); 
		btnCancelar.setToolTipText("Cancelar devolução");
		add(btnCancelar);
                
		
		scr = new JScrollPane();
		
		pnlgrid = new JPanel(); //Painel
		pnlgrid.setBorder(new TitledBorder("Empréstimo Disponíveis"));
		pnlgrid.setBackground(new Color(192, 192, 192));
		pnlgrid.setLayout(new BorderLayout());
		
		String[] colunas ={"Número de Matrícula", "Nome", "Título", "Data de Empréstimo", "Data de Devolução"};
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
				btnDevolucao.setEnabled(!lsm.isSelectionEmpty());
                                
				
			}
		});
		
	}
}
