
package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import sally.*;
import telas.*;
import dao.DataSource;
import dao.LivrosDao;


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
			  int codigo = (int) gridLivro.grid.getValueAt(posicao, 0);
			  LivrosDao livroDao = new LivrosDao();
			  Livro li = livroDao.pesquisarLivro(codigo); 
			  formEdicao = new ControleEdicaoLivro(li);
        	  formEdicao.form.setVisible(true);
			  ArrayList<Livro> listaAtualizada = new ArrayList<Livro>();
			  listaAtualizada = livroDao.exibirLivros();
			  refreshGrid(listaAtualizada);
            }
	});
		
		gridLivro.btnExcluir.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridLivro.grid.getSelectedRow();
				int codigo = (int) gridLivro.grid.getValueAt(posicao, 0);
				LivrosDao livroDao = new LivrosDao();
				livroDao.excluirLivro(codigo);
				((DefaultTableModel) gridLivro.grid.getModel()).removeRow(posicao); 
			}
		});
		
	}
	
	public void chargeScreen(){ 
		LivrosDao livrosDao = new LivrosDao();
		ArrayList<Livro> listarLivro = new ArrayList<Livro>();
		listarLivro = livrosDao.exibirLivros();
		refreshGrid(listarLivro);
	}
	
	public void refreshGrid(ArrayList<Livro> lista){ 
		int x = gridLivro.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridLivro.dtm.removeRow(x);
		}
        for (Livro li : lista) {
            gridLivro.dtm.addRow(new Object[] { li.getCodigo(), li.getTitulo(), li.getAutor(), li.getAno(), li.getEdicao(), li.getDispo() });
        }
		if (gridLivro.dtm.getRowCount() > 0) {
			gridLivro.grid.setRowSelectionInterval(0, 0);
		}
	}
}
