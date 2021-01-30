
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

import dao.DevolucaoDao;
import dao.LivrosDao;
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
                  int numeromatricula = (int) gridDevolucao.grid.getValueAt(posicao, 0);
                  Devolucao devolucao = new Devolucao();  
                  DevolucaoDao devolucaodao = new DevolucaoDao();
                  Calendar DataDevolucaoRealCalendar =  Calendar.getInstance();
                  Calendar DataDevolucaoEmprestimoCalendar =  Calendar.getInstance();
                  Calendar DataMultaCalendar = Calendar.getInstance();
                  SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");   
                  try{
                    DataDevolucaoReal = FormatoData.parse(gridDevolucao.txtDigitaDevolucao.getText());
                    String datadevolucao = (String) gridDevolucao.grid.getValueAt(posicao, 4);
                    DataDevolucaoEmprestimo = FormatoData.parse(datadevolucao);
                    DataDevolucaoRealCalendar.setTime(DataDevolucaoReal);
                    DataDevolucaoEmprestimoCalendar.setTime(DataDevolucaoEmprestimo);
                  } catch(java.text.ParseException ex) {
                        ex.printStackTrace();
                  } 
                  if(DataDevolucaoEmprestimoCalendar.compareTo(DataDevolucaoRealCalendar) == 0 ||DataDevolucaoEmprestimoCalendar.after(DataDevolucaoRealCalendar)){ 
                        int codigolivro = (int) gridDevolucao.grid.getValueAt(posicao, 2);
                        LivrosDao livrodao = new LivrosDao();
                        Livro livro = new Livro();
                        livro = livrodao.pesquisarLivro(codigolivro);
                        int novaquantidade = Integer.parseInt(livro.getDispo()) + 1;
                        livro.setDispo(String.valueOf(novaquantidade));
                        livrodao.editarLivro(codigolivro, livro);
                        JOptionPane.showMessageDialog(null, "Devolução efetuada com sucesso!");
                        gridDevolucao.dtm.removeRow(posicao);
                        gridDevolucao.setVisible(false);   
                   } else {
                        int codigolivro = (int) gridDevolucao.grid.getValueAt(posicao, 2);
                        LivrosDao livrodao = new LivrosDao();
                        Livro livro = new Livro();
                        livro = livrodao.pesquisarLivro(codigolivro);
                        int novaquantidade = Integer.parseInt(livro.getDispo()) + 1;
                        livro.setDispo(String.valueOf(novaquantidade));
                        livrodao.editarLivro(codigolivro, livro);
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
           DevolucaoDao devolucaodao = new DevolucaoDao();    
	     ArrayList<Devolucao> listardevolucao = new ArrayList<Devolucao>();
	     listardevolucao = devolucaodao.exibirDevolucoes();
	     refreshGrid(listardevolucao);
	}
	
	public void refreshGrid(ArrayList<Devolucao> lista){ 
		
		
		int x = gridDevolucao.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridDevolucao.dtm.removeRow(x);
		}

		for (Devolucao de : lista) {
                    
			gridDevolucao.dtm.addRow(new Object[] { de.getNM(), de.getNome(), de.getCodigoLivro(), de.getTitulo(), de.getDTEmprestimo(), de.getDTDevolucao()});
		}
		if (gridDevolucao.dtm.getRowCount() > 0) {
			gridDevolucao.grid.setRowSelectionInterval(0, 0);
		}
      }
      
}
