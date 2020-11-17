
package controles;

import static controles.ControleCadastroCliente.clienteDB;
import excecoes.*;
import static excecoes.VerificaMulta.aux;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sally.*;
import telas.*;
import java.util.*;
import java.text.*;
import java.text.ParseException;



    public class ControleEmprestimo extends ControleCadastro  {
    JanelaEmprestimo gridEmprestimo;
    
    
    public String exibeTitulo, exibeNome;
    public static ArrayList <Emprestimo> emprestimoDB = new ArrayList<>(); 
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
				Livro li = ControleCadastroLivro.livroDB.get(posicao); 
				
                               
				String exibeTitulo= gridEmprestimo.dtm.getValueAt(posicao, 1).toString();
                                gridEmprestimo.txtExibeTitulo.setText(exibeTitulo);
                                
                             
                                
                                String DispoAuxString = gridEmprestimo.dtm.getValueAt(posicao, 5).toString();
                                try{
                                DispoAuxInteiro = Integer.parseInt(DispoAuxString);
                                }
                                catch(NumberFormatException DiferenteZero){
                                    JOptionPane.showMessageDialog(null, "O livro não está disponível");
                                    
                                }
                       
                       
                                
				
					ControleCadastroLivro.livroDB.set(posicao, li);
					refreshGrid(ControleCadastroLivro.livroDB);
				
				
			}
		});
                gridEmprestimo.btnAdicionarCliente.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
                             
                                Cliente cliente = new Cliente();
                                Cliente clienteAuxiliar = new Cliente();
                                cliente.setNM(gridEmprestimo.txtDigitaNM.getText());
                                for(int i = 0; i < ControleCadastroCliente.clienteDB.size(); i++){
                                   
                                    if(cliente.equals(ControleCadastroCliente.clienteDB.get(i))){
                                        clienteAuxiliar = ControleCadastroCliente.clienteDB.get(i);
                                        if(clienteAuxiliar.getST().equals("DESATIVADO")){
                                            JOptionPane.showMessageDialog(null, "O cliente "+clienteAuxiliar.getNome()+" possui pendências");
                                    } else {
                                        gridEmprestimo.txtExibeNomeCliente.setText(clienteAuxiliar.getNome());
                                    }
                                }
                                }
                                
                                
                               
                                
                                
                                
                               
				
			}
		});
               
                
		gridEmprestimo.btnEmprestar.addActionListener(new ActionListener() { //Editar dados do Cliente
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
                   Emprestimo emprestimo  = new Emprestimo();
                   Date Data = new Date();
                   SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");
                   String DataSistema = FormatoData.format(Data);
                     
                      
                   try{ 
                        Livro livro = ControleCadastroLivro.livroDB.get(posicao); 
                        DispoAuxInteiro--;
                        DispoAuxString = String.valueOf(DispoAuxInteiro);
                        livro.setDispo(DispoAuxString);
                        emprestimo.setNM(ValidacaoDeCadastro.validaNotNull(gridEmprestimo.txtDigitaNM.getText()));
                        emprestimo.setNome(ValidacaoDeCadastro.validaNotNull(gridEmprestimo.txtExibeNomeCliente.getText()));
                        emprestimo.setTitulo(ValidacaoDeCadastro.validaNotNull(gridEmprestimo.txtExibeTitulo.getText()));
                              
			emprestimo.setDTEmprestimo(DataSistema);
                                                                                    
			emprestimo.setDTDevolucao(ValidacaoDeCadastro.validaNotNull(gridEmprestimo.txtDigitaDevolucao.getText()));





                        emprestimo.setPosicaoLivro(String.valueOf(posicao));
                       
                        
			emprestimoDB.add(emprestimo);
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
    
	public void chargeScreen(){ 
		
                
        
                
                
		refreshGrid(ControleCadastroLivro.livroDB);
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

