
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
import sally.Cliente;
import sally.Devolucao;
import sally.Emprestimo;
import sally.Livro;
import sally.Multa;
import telas.*;

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
	   int posicao = gridMulta.grid.getSelectedRow();
       String NM = ControleDevolucao.multaDB.get(posicao).getNM();
       ControleDevolucao.multaDB.remove(posicao); 
       gridMulta.dtm.removeRow(posicao);
       int multaPosicoes = VerificaMulta.MultaPosicoes(NM);
       VerificaMulta.MudaStatus(multaPosicoes,NM);		
			}
		});
    }
            
	public void chargeScreen(){ 
		refreshGrid(ControleDevolucao.multaDB);          
	}
	
	public void refreshGrid(ArrayList<Multa> lista){ 
		int x = gridMulta.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridMulta.dtm.removeRow(x);
		}

		for (Multa mul : lista) {            
			gridMulta.dtm.addRow(new Object[] { mul.getNM(), mul.getNome(), mul.getEndereco(), mul.getTitulo(), mul.getDTEmprestimo(), mul.getDTDevolucao(), mul.getDTDevolucaoReal(),mul.getDiasMulta(), mul.getDTMulta()});
		}
		if (gridMulta.dtm.getRowCount() > 0) {
			gridMulta.grid.setRowSelectionInterval(0, 0);
		}
	}
}
