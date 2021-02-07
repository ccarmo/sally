
package controles;

import excecoes.ValidacaoDeCadastro;
import excecoes.VerificaMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

import dao.MultaDao;
import sally.Cliente;
import sally.Devolucao;
import sally.Emprestimo;
import sally.Livro;
import sally.Multa;
import telas.*;
import dao.*;

    public class ControleMulta extends ControleCadastro {
     JanelaMulta gridMulta;
     public ControleMulta() {
		gridMulta = new JanelaMulta();
		validacaoDeDados();
		chargeScreen();   
		gridMulta.grid.clearSelection();           
	}
	
        
    @Override                  
	public void validacaoDeDados(){  
	  gridMulta.btnTirarMulta.addActionListener(new ActionListener() { 
	  @Override
	  public void actionPerformed(ActionEvent arg0) {
	   MultaDao multadao = new MultaDao();
	   ClientesDao clientedao = new ClientesDao();
	   int posicao = gridMulta.grid.getSelectedRow();
       int codigomulta = (int) gridMulta.grid.getValueAt(posicao, 0);
	   String numeromatricula = (String) gridMulta.grid.getValueAt(posicao, 1);
       multadao.excluirMulta(codigomulta);
	   clientedao.alteraStatus(Integer.valueOf(numeromatricula), "ATIVADO");
	   JOptionPane.showMessageDialog(null, "Multa excluida e status do cliente alterado");
	   chargeScreen(); 
			}
		});
    }
            
	public void chargeScreen(){
		MultaDao multadao = new MultaDao();
		ArrayList<Multa> listarmultas = new ArrayList<Multa>();
		listarmultas = multadao.exibirMulta();
		refreshGrid(listarmultas); 
	          
	}
	
	public void refreshGrid(ArrayList<Multa> lista){ 
		int x = gridMulta.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridMulta.dtm.removeRow(x);
		}

		for (Multa mul : lista) {            
			gridMulta.dtm.addRow(new Object[] { mul.getCodigoMulta(), mul.getNM(), mul.getNome(), mul.getEndereco(), mul.getTitulo(), mul.getDTEmprestimo(), mul.getDTDevolucao(), mul.getDTDevolucaoReal(),mul.getDiasMulta(), mul.getDTMulta()});
		}
		if (gridMulta.dtm.getRowCount() > 0) {
			gridMulta.grid.setRowSelectionInterval(0, 0);
		}
	}
}
