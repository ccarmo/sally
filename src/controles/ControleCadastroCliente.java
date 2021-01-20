
package controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import dao.ClientesDao;
import java.io.IOException;
import excecoes.*;
import sally.*;
import telas.*;

public class ControleCadastroCliente extends ControleCadastro{
   JanelaCadastroUsuario jcliente;
   Cliente c;
   public static ArrayList <Cliente> clienteDB = new ArrayList<>(); 
   public ControleCadastroCliente(){
      
		jcliente = new JanelaCadastroUsuario();
                validacaoDeDados();       
   }
   
 
 @Override
 public  void validacaoDeDados (){          
		jcliente.btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                        Cliente cliente = new Cliente();
                        ClientesDao clientedao = new ClientesDao();
                   try{                               
			cliente.setNome(ValidacaoDeCadastro.validaNotNull(jcliente.txtNome.getText()));
			cliente.setEndereco(ValidacaoDeCadastro.validaNotNull(jcliente.txtEnd.getText()));
                        cliente.setEmail(ValidacaoDeCadastro.validaNotNull(jcliente.txtEmail.getText()));
			cliente.setTelefone(ValidacaoDeCadastro.validaNotNull(jcliente.txtTel.getText()));
                        cliente.setCPF(ValidacaoDeCadastro.validaNotNull(jcliente.txtCPF.getText()));
                        cliente.setDT(ValidacaoDeCadastro.validaNotNull(jcliente.txtNasci.getText()));
                        cliente.setNM(ValidacaoDeCadastro.validaNotNull(jcliente.txtNumeroMatricula.getText()));
                        String AtivadoPadrao = "ATIVADO";
                        cliente.setST(AtivadoPadrao);
			clientedao.add_cliente(cliente);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");	
                   } catch(IllegalArgumentException e){
                       JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
                       jcliente.setVisible(false);
                   }  
	               jcliente.setVisible(false);

                }               
    });     
                

 
		jcliente.btnGerarNumeroMatricula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {     
			 GeradorNumeroMatricula.GeraNM();
                         jcliente.txtNumeroMatricula.setText(GeradorNumeroMatricula.NumeroMatriculaAux);
                        }               
    });    
		
             
                
                        
                                 
                                
              
}
}
   