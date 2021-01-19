
package controles;

import excecoes.ValidacaoDeCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import dao.LivrosDao;
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
		form.txtCodigo.setText(String.valueOf(li.getCodigo()));
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
                 ValidacaoDeCadastro.validaNotNull(form.txtTitulo.getText());
                 ValidacaoDeCadastro.validaNotNull(form.txtAutor.getText());
                 ValidacaoDeCadastro.validaNotNull(form.txtEdicao.getText());
                 ValidacaoDeCadastro.validaNotNull(form.txtAno.getText());
				 ValidacaoDeCadastro.validaNotNull(form.txtDispo.getText());
				 int codigo = (li.getCodigo());
                 initEvents(codigo);
                } catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
                    form.setVisible(false);
                }
			}
		});
	   }
	
	private void initEvents(int codigo){ 
		LivrosDao livrosDao = new LivrosDao();
		li.setTitulo(form.txtTitulo.getText());
        li.setAutor(form.txtAutor.getText());
        li.setEdicao(form.txtEdicao.getText());
        li.setAno(form.txtAno.getText());
		li.setDispo(form.txtDispo.getText());
		livrosDao.editarLivro(codigo, li);
		JOptionPane.showMessageDialog(null, "Edição concluida !");
		form.setVisible(false);
	}
}
