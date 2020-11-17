
package controles;

import excecoes.ValidacaoDeCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sally.*;
import telas.*;


public class ControleEdicaoLivro extends ControleCadastro {
    
	
	JanelaEdicaoLivro form;
	Livro li;
	
	
	public ControleEdicaoLivro(Livro livro) {
	
	
		
		li = new Livro();
		li = livro;
		form = new JanelaEdicaoLivro();
		chargeScreen(); 
		validacaoDeDados();
		
	}
	
	private void chargeScreen(){ 
		form.txtCodigo.setText(li.getCodigo());
		form.txtTitulo.setText(li.getTitulo());
		form.txtAutor.setText(li.getAutor());
                form.txtEdicao.setText(li.getEdicao());
                form.txtAno.setText(li.getAno());
                form.txtDispo.setText(li.getDispo());
	}
	
        @Override
	public void validacaoDeDados(){
		form.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
                                try{
                                ValidacaoDeCadastro.validaNotNull(form.txtCodigo.getText());
                                ValidacaoDeCadastro.validaNotNull(form.txtTitulo.getText());
                                ValidacaoDeCadastro.validaNotNull(form.txtAutor.getText());
                                ValidacaoDeCadastro.validaNotNull(form.txtEdicao.getText());
                                ValidacaoDeCadastro.validaNotNull(form.txtAno.getText());
                                ValidacaoDeCadastro.validaNotNull(form.txtDispo.getText());
                                initEvents();
                                }
                                catch(IllegalArgumentException e){
                                    JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
                                    form.setVisible(false);
                                }
			}
		});
	}
	
	private void initEvents(){ 
		li.setCodigo(form.txtCodigo.getText());
                li.setTitulo(form.txtTitulo.getText());
                li.setAutor(form.txtAutor.getText());
                li.setEdicao(form.txtEdicao.getText());
                li.setAno(form.txtAno.getText());
                li.setDispo(form.txtDispo.getText());
                
		
		form.setVisible(false);
		JOptionPane.showMessageDialog(null, "Edição concluida !");
	}
}
