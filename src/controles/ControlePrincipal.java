
package controles;
import excecoes.VerificaMulta;
import telas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sally.*;


public class ControlePrincipal {
    JanelaPrincipal jprincipal;
    
    public ControlePrincipal(){
        jprincipal = new JanelaPrincipal();
        
        inicializaEventos();
    }
    private void inicializaEventos(){
		jprincipal.cdUsuarios.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleCadastroCliente();
                                
                                 
			}
		});
                
                jprincipal.psUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleInfoUsuario();
			}
		});
                
               
                jprincipal.cdLivros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleCadastroLivro();
			}
		});
                
                jprincipal.psLivros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleInfoLivro();
			}
		});
                
                jprincipal.itEmprestimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleEmprestimo();
			}
		});
                
                jprincipal.itDevolucao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleDevolucao();
			}
		});
                
                 jprincipal.itMulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ControleMulta();
			}
		});
              
                
                
                
}
}
