
package controles;

import static controles.ControleCadastroCliente.clienteDB;
import excecoes.ValidacaoDeCadastro;
import excecoes.VerificaMulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import sally.*;
import telas.*;

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
	
        @Override
	public void validacaoDeDados(){
		form.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
                        
                        
                   try{                               
		
                        c.setNome(ValidacaoDeCadastro.validaNotNull(form.txtNome.getText()));
                        c.setEndereco(ValidacaoDeCadastro.validaNotNull(form.txtEnd.getText()));
                        c.setEmail(ValidacaoDeCadastro.validaNotNull(form.txtEmail.getText()));
                        c.setCPF(ValidacaoDeCadastro.validaNotNull(form.txtCPF.getText()));
                        c.setDT(ValidacaoDeCadastro.validaNotNull(form.txtNasci.getText()));
                        c.setTelefone(ValidacaoDeCadastro.validaNotNull(form.txtTel.getText()));
                        
		        JOptionPane.showMessageDialog(null, "Edição concluida !");
		        form.setVisible(false);
		
                        
                   }
                   catch(IllegalArgumentException e){
                       JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
                       form.setVisible(false);
                   }
                   
                   
                        
		     
	            form.setVisible(false);
                        }
		});
	}
	
	
}
