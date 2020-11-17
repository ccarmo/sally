
package controles;

import static controles.ControleEmprestimo.emprestimoDB;
import excecoes.ValidacaoDeCadastro;
import excecoes.VerificaMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import sally.*;
import telas.*;

public class ControleDevolucao extends ControleCadastro {
     JanelaDevolucao gridDevolucao;
     public static ArrayList <Devolucao> devolucaoDB = new ArrayList<>();
     public static ArrayList <Multa> multaDB = new ArrayList<>();
     public static ArrayList<Integer>  multastatusDB = new ArrayList<Integer>();
     int PosicaoLivroAuxiliar,DispoAuxInteiro;
     String DispoAuxString;
     Date Data,DataDevolucaoReal,DataDevolucaoEmprestimo   = new Date();
     
     
     public ControleDevolucao() {
		gridDevolucao = new JanelaDevolucao();
		validacaoDeDados();
		chargeScreen();
                gridDevolucao.grid.clearSelection();
                
	}
	
        
        @Override                  
	public void validacaoDeDados(){
           
		gridDevolucao.btnDevolucao.addActionListener(new ActionListener() { //Editar dados do Cliente
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridDevolucao.grid.getSelectedRow();
				Emprestimo em = ControleEmprestimo.emprestimoDB.get(posicao); 
				Devolucao devolucao = new Devolucao();  
                                Calendar DataDevolucaoRealCalendar =  Calendar.getInstance();
                                Calendar DataDevolucaoEmprestimoCalendar =  Calendar.getInstance();
                                Calendar DataMultaCalendar = Calendar.getInstance();
                                SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");
                                
                                
                                
                                try{
                                
                                DataDevolucaoReal = FormatoData.parse(gridDevolucao.txtDigitaDevolucao.getText());
                                DataDevolucaoEmprestimo = FormatoData.parse(em.getDTDevolucao());
                                DataDevolucaoRealCalendar.setTime(DataDevolucaoReal);
                                DataDevolucaoEmprestimoCalendar.setTime(DataDevolucaoEmprestimo);
    
                                }
                                catch(java.text.ParseException ex) {
                                     ex.printStackTrace();
                                } 
                                    
                               
                                 
                                 if(DataDevolucaoEmprestimoCalendar.compareTo(DataDevolucaoRealCalendar) == 0 ||DataDevolucaoEmprestimoCalendar.after(DataDevolucaoRealCalendar)){
                                     
                                     
                                     PosicaoLivroAuxiliar = Integer.valueOf(em.getPosicaoLivro());
                                     Livro livro = ControleCadastroLivro.livroDB.get(PosicaoLivroAuxiliar);
                                     DispoAuxInteiro = Integer.valueOf(livro.getDispo());
                                     DispoAuxInteiro++;
                                     DispoAuxString = String.valueOf(DispoAuxInteiro);
                                     livro.setDispo(DispoAuxString);
                                     devolucao.setTitulo(em.getTitulo());
                                     devolucao.setNM(em.getNM());
                                     devolucao.setNome(em.getNome());
                                     devolucao.setDTEmprestimo(em.getDTDevolucao());
                                     devolucao.setDTDevolucao(em.getDTDevolucao());
                                     devolucaoDB.add(devolucao);
                                     JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso!");
                                     gridDevolucao.dtm.removeRow(posicao);
                                    
                                     gridDevolucao.setVisible(false);
                                     
                                 } else {
                                     
                                     PosicaoLivroAuxiliar = Integer.valueOf(em.getPosicaoLivro());
                                     Livro livro = ControleCadastroLivro.livroDB.get(PosicaoLivroAuxiliar);
                                     DispoAuxInteiro = Integer.valueOf(livro.getDispo());
                                     DispoAuxInteiro++;
                                     DispoAuxString = String.valueOf(DispoAuxInteiro);
                                     livro.setDispo(DispoAuxString);
                                     
                                      
                                     
                                      
                                      
                                      
                                      
                                      int diasInteiros = VerificaMulta.GeraDiasInteiros(em.getNM(),DataDevolucaoEmprestimo, DataDevolucaoReal);
                                      DataMultaCalendar = VerificaMulta.GeraDataMultaCalendar(diasInteiros, DataDevolucaoRealCalendar);
                                      String DataMultaString = VerificaMulta.GeraDataMulta(DataMultaCalendar);
                                      
                                      
                                      
                                      Multa multa = new Multa();
                                      Cliente cliente = new Cliente();
                                      Cliente clienteAuxiliar = new Cliente();
                                      cliente.setNM(em.getNM());
                                      
                                      
                                      for (int i = 0; i < ControleCadastroCliente.clienteDB.size(); i++){
                                                if (cliente.equals(ControleCadastroCliente.clienteDB.get(i))){
                                                      clienteAuxiliar = ControleCadastroCliente.clienteDB.get(i);
                                                      clienteAuxiliar.setST("DESATIVADO");
                                                      multa.setNM(clienteAuxiliar.getNM());
                                                      multa.setNome(clienteAuxiliar.getNome());
                                                      multa.setEndereco(clienteAuxiliar.getEndereco());
                                                      multa.setTitulo(em.getTitulo());
                                                      multa.setDTEmprestimo(em.getDTEmprestimo());
                                                      multa.setDTDevolucao(em.getDTDevolucao());
                                                      multa.setDTDevolucaoReal(gridDevolucao.txtDigitaDevolucao.getText());
                                                      multa.setDiasMulta(String.valueOf(diasInteiros));
                                                      multa.setDTMulta(DataMultaString);
                                                      multaDB.add(multa);
                                                }
                                                      
                                      }
                                      
                                      
                                     
                                      
                                      
                                      JOptionPane.showMessageDialog(null, "Devolução efetuada após data prevista");
                                     

                                                                        
                                      
                                      ControleEmprestimo.emprestimoDB.remove(posicao);
                                      gridDevolucao.setVisible(false);
                                      
                                 }
                                          
                                      
                                      
                                      
                                      
                                   
                               
                                  
                                
				
			}
		});
        }
	public void chargeScreen(){ 
		
		refreshGrid(ControleEmprestimo.emprestimoDB);
	}
	
	public void refreshGrid(ArrayList<Emprestimo> lista){ 
		
		
		int x = gridDevolucao.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridDevolucao.dtm.removeRow(x);
		}

		for (Emprestimo em : lista) {
                    
			gridDevolucao.dtm.addRow(new Object[] { em.getNM(),em.getNome(), em.getTitulo(), em.getDTEmprestimo(), em.getDTDevolucao()});
		}
		if (gridDevolucao.dtm.getRowCount() > 0) {
			gridDevolucao.grid.setRowSelectionInterval(0, 0);
		}
	}
}
