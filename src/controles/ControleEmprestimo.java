
package controles;


import excecoes.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sally.*;
import telas.*;
import dao.*;
import java.util.*;
import java.text.*;
import java.text.ParseException;

    public class ControleEmprestimo extends ControleCadastro  {
    JanelaEmprestimo gridEmprestimo;
    public String exibeTitulo, exibeNome;
    ArrayList addemprestimo = new ArrayList(4); 
    Emprestimo emprestimo;
    String DispoAuxString;
    int DispoAuxInteiro;
    int posicao;
    
	public ControleEmprestimo() {
		gridEmprestimo = new JanelaEmprestimo();
		validacaoDeDados();
		chargeScreen();        
		gridEmprestimo.grid.clearSelection();             
    }
         
    @Override                  
	public void validacaoDeDados(){      
		gridEmprestimo.btnAdicionarLivro.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
            int posicao = gridEmprestimo.grid.getSelectedRow();
            int codigolivro = (int) gridEmprestimo.grid.getValueAt(posicao, 0);
            LivrosDao livrodao = new LivrosDao();
            Livro livro = new Livro();
            livro = livrodao.pesquisarLivro(codigolivro); 	
			String exibeTitulo= gridEmprestimo.dtm.getValueAt(posicao, 1).toString();
            gridEmprestimo.txtExibeTitulo.setText(exibeTitulo);
                          
            
            try{
                DispoAuxInteiro = Integer.parseInt(livro.getDispo());
            } catch(NumberFormatException DiferenteZero){
                JOptionPane.showMessageDialog(null, "O livro não está disponível");                    
            }	
            livrodao.atualizaQuantidade(codigolivro, livro);
            addemprestimo.add(1, codigolivro);
			}
        });
        
        gridEmprestimo.btnAdicionarCliente.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {

                EmprestimoDao emprestimodao = new EmprestimoDao();
                
                Cliente cliente = new Cliente();
                ClientesDao clientesdao = new ClientesDao();

          
                int numeromatricula = Integer.parseInt(gridEmprestimo.txtDigitaNM.getText());
                
                cliente = clientesdao.pesquisarCliente(numeromatricula);
                
                   
                if (cliente.getST().equals("DESATIVADO")){
                    JOptionPane.showMessageDialog(null, "O cliente "+cliente.getNome()+" possui pendências");
                } else {
                    gridEmprestimo.txtExibeNomeCliente.setText(cliente.getNome());
                }
                
                addemprestimo.add(0, emprestimodao.pesquisarCodigoCliente(numeromatricula));
            }
                				
			
		});
               
                
		gridEmprestimo.btnEmprestar.addActionListener(new ActionListener() { //Editar dados do Cliente
			@Override
			public void actionPerformed(ActionEvent arg0) {
                
                EmprestimoDao emprestimodao = new EmprestimoDao();

                Date Data = new Date();
                SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");
                String DataSistema = FormatoData.format(Data);   
   
                   try{ 
                    String datafin = ValidacaoDeCadastro.validaNotNull(gridEmprestimo.txtDigitaDevolucao.getText());
                    addemprestimo.add(2, DataSistema);
                    addemprestimo.add(3,datafin);
                    emprestimodao.add_emprestimo(addemprestimo);
                    JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");	
                   }
                   catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
                    gridEmprestimo.setVisible(false);
                   }
                    gridEmprestimo.setVisible(false);		
			}
		});
	}
    
	public void chargeScreen() {
        LivrosDao livrosDao = new LivrosDao();
		ArrayList<Livro> listarLivro = new ArrayList<Livro>();
		listarLivro = livrosDao.exibirLivros();
		refreshGrid(listarLivro);
	}
	
	public void refreshGrid(ArrayList<Livro> lista){ 		
		int x = gridEmprestimo.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridEmprestimo.dtm.removeRow(x);
		}
		for (Livro li : lista) {                    
			gridEmprestimo.dtm.addRow(new Object[] { li.getCodigo(), li.getTitulo(), li.getAutor(), li.getEdicao(), li.getAno(), li.getDispo() });
		}
		if (gridEmprestimo.dtm.getRowCount() > 0) {
			gridEmprestimo.grid.setRowSelectionInterval(0, 0);
		}
	}
}

