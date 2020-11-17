
package telas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;




public class JanelaEmprestimo extends JFrame {
        public JButton btnAdicionarLivro, btnAdicionarCliente, btnEmprestar, btnLimpar, btnCancelar;
	JPanel pnlgrid;
        public JLabel lblExibeNomeCliente, lblDigitaNM, lbldtEmprestimo, lbldtDevolucao, lblExibeTitulo, lblExibeISBN; 
        public JTextField txtExibeTitulo, txtExibeNomeCliente, txtDigitaNM, txtExibeISBN,  txtDigitaEmprestimo;
        public JFormattedTextField txtDigitaDevolucao;
	public JTable grid;
	public DefaultTableModel dtm;
	JScrollPane scr;
        MaskFormatter  mskDataDevolucao, mskDataEmprestimo;
        Date Data = new Date();
        SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");
        public String DataSistema = FormatoData.format(Data);
    
	
	public JanelaEmprestimo() {
        setTitle("Gerenciamento de Empréstimos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        initComponents();
        initEvents();
 
        setSize(900, 600);
        this.setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

	private void initComponents() {
		setLayout(null);
		getContentPane().setBackground(new Color(192,192,192));
		
                
                //Adicionar cliente disponível
                lblDigitaNM = new JLabel("Digite o número de matrícula do Cliente:");
		lblDigitaNM.setBounds(23, 50, 250, 20);
		add(lblDigitaNM);
                
                txtDigitaNM = new JTextField();
		txtDigitaNM.setBounds(260, 50, 100, 20);
                add(txtDigitaNM);
                
                btnAdicionarCliente = new JButton("Adicionar número de matrícula");
		btnAdicionarCliente.setBounds(370, 50, 250, 20);
		btnAdicionarCliente.setBackground(new Color (240,248,255)); 
		btnAdicionarCliente.setToolTipText("Adicionar matrícula");
		add(btnAdicionarCliente);
                
                lblExibeNomeCliente = new JLabel("Nome do cliente adicionado:");
		lblExibeNomeCliente.setBounds(23, 80, 250, 20);
		add(lblExibeNomeCliente);
                
                txtExibeNomeCliente = new JTextField();
		txtExibeNomeCliente.setBounds(190, 80, 300, 20);
                txtExibeNomeCliente.setEditable(false);
		add(txtExibeNomeCliente);
                
		//Adicionar Livro disponível
		btnAdicionarLivro = new JButton("Adicionar Livro");
		btnAdicionarLivro.setBounds(380, 390, 200, 20);
		btnAdicionarLivro.setBackground(new Color (240,248,255)); 
		btnAdicionarLivro.setToolTipText("Adicionar livro selecionado");
		btnAdicionarLivro.setEnabled(false);
		add(btnAdicionarLivro);
		
                
                lblExibeTitulo= new JLabel("Título:");
		lblExibeTitulo.setBounds(23, 390, 90, 20);
		add(lblExibeTitulo);
                
                txtExibeTitulo = new JTextField();
		txtExibeTitulo.setBounds(70, 390, 300, 20);
		add(txtExibeTitulo);
                txtExibeTitulo.setEditable(false);
                
		
                
		//Adicionar data de empréstimo
                lbldtEmprestimo = new JLabel("Data de Empréstimo:");
		lbldtEmprestimo.setBounds(23, 450, 100, 20);
		add(lbldtEmprestimo);
                
               
                
                txtDigitaEmprestimo = new JTextField(DataSistema);
		txtDigitaEmprestimo.setBounds(150,450, 70, 20);
                txtDigitaEmprestimo.setEditable(false);
		add(txtDigitaEmprestimo);
		
                //Adicionar data de devolução
                lbldtDevolucao = new JLabel("Data de Devolução:");
		lbldtDevolucao.setBounds(300, 450, 150, 20);
		add(lbldtDevolucao);
                
                 try {
			mskDataDevolucao = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
                txtDigitaDevolucao = new JFormattedTextField(mskDataDevolucao);
		txtDigitaDevolucao.setBounds(420, 450, 70, 20);
		add(txtDigitaDevolucao);
		
                //Botões de ações
                btnEmprestar = new JButton("Emprestar Livro");
		btnEmprestar.setBounds(530, 530, 150, 25);
		btnEmprestar.setBackground(new Color (240,248,255)); 
		btnEmprestar.setToolTipText("Emprestar livro");
		add(btnEmprestar);
                
                btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(690, 530, 95, 25);
		btnLimpar.setBackground(new Color (240,248,255)); 
		btnLimpar.setToolTipText("Limpar dados adicionados");
		add(btnLimpar);
                
                btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(790, 530, 95, 25);
		btnCancelar.setBackground(new Color (240,248,255)); 
		btnCancelar.setToolTipText("Cancelar empréstimo");
		add(btnCancelar);
                
		//Grid
		scr = new JScrollPane();
		
		pnlgrid = new JPanel(); //Painel
		pnlgrid.setBorder(new TitledBorder("Livros Disponíveis"));
		pnlgrid.setBackground(new Color(192, 192, 192));
		pnlgrid.setLayout(new BorderLayout());
		
		String[] colunas ={"Código", "Título", "Autor", "Edição", "Ano", "Dispo"};
		dtm = new DefaultTableModel(colunas, 0){ 
			/**
			
			 * @param colunas 
			 * 
			 * Esse método tem a função de mpossibilitar a seleção de múltiplas linhas*/
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

		pnlgrid.setBounds(20, 120, 850, 260);
		add(pnlgrid);
		repaint();
		
	}
	
	private void initEvents(){
		
		
		grid.getSelectionModel().addListSelectionListener(
				/*Pegar linha selecionada*/
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							return;
						}
					}
		});
		
		grid.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
			/*Habilitar botões só se tiver uma linha selecionada*/
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				btnAdicionarLivro.setEnabled(!lsm.isSelectionEmpty());
                                
				
			}
		});
		
	}
}
