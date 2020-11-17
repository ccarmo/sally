
package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import sally.*;
import telas.*;


public class ControleInfoLivro {
    JanelaInfoLivro gridLivro;
        
	ControleEdicaoLivro formEdicao;
	
	public ControleInfoLivro() {
		gridLivro = new JanelaInfoLivro();
		initEvents();
		chargeScreen();
		gridLivro.grid.clearSelection(); 
	}
	
	private void initEvents(){
		gridLivro.btnEditar.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridLivro.grid.getSelectedRow();
				Livro li = ControleCadastroLivro.livroDB.get(posicao); 
				
				
				formEdicao = new ControleEdicaoLivro(li); 
				formEdicao.form.setVisible(true);
				
					ControleCadastroLivro.livroDB.set(posicao, li);
					refreshGrid(ControleCadastroLivro.livroDB);
				
				
			}
		});
		
		gridLivro.btnExcluir.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridLivro.grid.getSelectedRow();
				ControleCadastroLivro.livroDB.remove(posicao);
				((DefaultTableModel) gridLivro.grid.getModel()).removeRow(posicao); 
			}
		});
		
	}
	
	public void chargeScreen(){ 
		
		refreshGrid(ControleCadastroLivro.livroDB);
	}
	
	public void refreshGrid(ArrayList<Livro> lista){ 
		
		
		int x = gridLivro.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridLivro.dtm.removeRow(x);
		}

		for (Livro li : lista) {
                   
			gridLivro.dtm.addRow(new Object[] { li.getCodigo(), li.getTitulo(), li.getAutor(), li.getEdicao(), li.getAno(), li.getDispo() });
                        
                    
		}
		if (gridLivro.dtm.getRowCount() > 0) {
			gridLivro.grid.setRowSelectionInterval(0, 0);
		}
	}
}
