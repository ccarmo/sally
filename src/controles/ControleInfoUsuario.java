
package controles;



import excecoes.VerificaMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import sally.*;
import telas.*;

public class ControleInfoUsuario {
 
	
	JanelaInfoUsuario gridCliente;
        
	ControleEdicaoUsuario formEdicao;
	
	public ControleInfoUsuario() {
		gridCliente = new JanelaInfoUsuario();
		initEvents();
		chargeScreen();
               
		gridCliente.grid.clearSelection(); 
	}
	
	private void initEvents(){
		gridCliente.btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridCliente.grid.getSelectedRow();
				Cliente c = ControleCadastroCliente.clienteDB.get(posicao); 
				
				formEdicao = new ControleEdicaoUsuario(c); 
				formEdicao.form.setVisible(true);
				
				 
			         ControleCadastroCliente.clienteDB.set(posicao, c);
			         refreshGrid(ControleCadastroCliente.clienteDB);
				
				
			}
		});
		
		gridCliente.btnExcluir.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int posicao = gridCliente.grid.getSelectedRow();
				ControleCadastroCliente.clienteDB.remove(posicao); 
				((DefaultTableModel) gridCliente.grid.getModel()).removeRow(posicao); 
			}
		});
		
	}
	
	public void chargeScreen(){ 
		
		
		refreshGrid(ControleCadastroCliente.clienteDB);
	}
	
	public void refreshGrid(ArrayList<Cliente> lista){ 
		
		
		int x = gridCliente.dtm.getRowCount();
		while (x > 0) {
			x--;
			gridCliente.dtm.removeRow(x);
		}

		for (Cliente c : lista) {
                    
			gridCliente.dtm.addRow(new Object[] { c.getNM(), c.getNome(), c.getEndereco(), c.getEmail(), c.getCPF(), c.getDT(), c.getTelefone(), c.getST()});
                      
		}
		if (gridCliente.dtm.getRowCount() > 0) {
			gridCliente.grid.setRowSelectionInterval(0, 0);
		}
	}
}
