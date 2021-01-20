
package controles;

import excecoes.VerificaMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import sally.*;
import telas.*;
import dao.ClientesDao;
import dao.DataSource;

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
				String numeromatricula = (String) gridCliente.grid.getValueAt(posicao, 0);
				ClientesDao clientedao = new ClientesDao();
				Cliente cli = clientedao.pesquisarCliente(Integer.parseInt(numeromatricula));
				formEdicao = new ControleEdicaoUsuario(cli);
				formEdicao.form.setVisible(true);
				ArrayList<Cliente> listaAtualizada = new ArrayList<Cliente>();
				listaAtualizada = clientedao.exibirClientes();
				refreshGrid(listaAtualizada);		
			}
	    });
		
		gridCliente.btnExcluir.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
                int posicao = gridCliente.grid.getSelectedRow();
				String numeromatricula = (String) gridCliente.grid.getValueAt(posicao, 0);
				ClientesDao clientedao = new ClientesDao();
				clientedao.excluirCliente(Integer.parseInt(numeromatricula));
				((DefaultTableModel) gridCliente.grid.getModel()).removeRow(posicao); 
			}
		});
		
	}
	
	public void chargeScreen(){ 
		ClientesDao clientedao = new ClientesDao();
		ArrayList<Cliente> listarcliente = new ArrayList<Cliente>();
		listarcliente = clientedao.exibirClientes();
		refreshGrid(listarcliente);
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
