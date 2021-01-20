
package controles;

import static controles.ControleCadastroCliente.clienteDB;
import excecoes.ValidacaoDeCadastro;
import excecoes.VerificaMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sally.*;
import telas.*;
import dao.*;

public class ControleEdicaoUsuario extends ControleCadastro {
   
	
	JanelaEdicaoUsuario form;
	Cliente c;
	
	public ControleEdicaoUsuario(Cliente cliente) {
		
		c = new Cliente();
		c = cliente;
		form = new JanelaEdicaoUsuario();
		chargeScreen(); 
		validacaoDeDados();
                
		
	}
	
	private void chargeScreen(){ 
		form.txtNome.setText(c.getNome());
		form.txtEnd.setText(c.getEndereco());
		form.txtTel.setText(c.getTelefone());
        form.txtCPF.setText(c.getCPF());
		form.txtNasci.setText(c.getDT());
        form.txtEmail.setText(c.getEmail());             
	}

	private void initEvents(int numeromatricula){ 
		ClientesDao clientedao = new ClientesDao();
		c.setNome(form.txtNome.getText());
		c.setCPF(form.txtCPF.getText());
		c.setDT(form.txtNasci.getText());
		c.setEmail(form.txtEmail.getText());
		c.setEndereco(form.txtEnd.getText());
		c.setTelefone(form.txtTel.getText());
		clientedao.editarClientes(numeromatricula, c);
		JOptionPane.showMessageDialog(null, "Edição concluida !");
		form.setVisible(false);
	}
    @Override
	public void validacaoDeDados(){
		form.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   try{     
				  ClientesDao clientedao = new ClientesDao();                          
                  ValidacaoDeCadastro.validaNotNull(form.txtNome.getText());
                  ValidacaoDeCadastro.validaNotNull(form.txtEnd.getText());
                  ValidacaoDeCadastro.validaNotNull(form.txtEmail.getText());
                  ValidacaoDeCadastro.validaNotNull(form.txtCPF.getText());
                  ValidacaoDeCadastro.validaNotNull(form.txtNasci.getText());
				  ValidacaoDeCadastro.validaNotNull(form.txtTel.getText());
				  int numeromatricula = Integer.parseInt(c.getNM());
				  initEvents(numeromatricula);
		          form.setVisible(false);
	            }   catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
                    form.setVisible(false);
                }
	                form.setVisible(false);
                        }
		});
	}
	
	
}
