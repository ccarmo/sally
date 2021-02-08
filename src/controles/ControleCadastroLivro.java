
package controles;
import dao.LivrosDao;
import dao.DataSource;
import excecoes.ValidacaoDeCadastro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sally.Livro;
import telas.JanelaCadastroLivro;


public class ControleCadastroLivro extends ControleCadastro{
   JanelaCadastroLivro jlivro;
   Livro livro;
   LivrosDao livroDao;
   
   
   
   public ControleCadastroLivro(){
		jlivro = new JanelaCadastroLivro();
        validacaoDeDados(); 
    }
   
 
 @Override
 public  void validacaoDeDados (){ 
		

		jlivro.btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
            Livro livro = new Livro();
            LivrosDao livroDao = new LivrosDao();

           try{                               

			 livro.setTitulo(ValidacaoDeCadastro.validaNotNull(jlivro.txtTitulo.getText()));
          livro.setAutor(ValidacaoDeCadastro.validaNotNull(jlivro.txtAutor.getText()));
			 livro.setEdicao(ValidacaoDeCadastro.validaNotNull(jlivro.txtEdicao.getText()));
          livro.setAno(ValidacaoDeCadastro.validaNotNull(jlivro.txtAno.getText()));
          livro.setDispo(ValidacaoDeCadastro.validaNotZero(jlivro.txtDispo.getText()));
          livroDao.add_livro(livro);  
           } catch(IllegalArgumentException e){
              JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
              jlivro.setVisible(false);
           } catch(Exception e){
              JOptionPane.showMessageDialog(null, "Não pode preencher como 0 a disponibilidade do livro");
              jlivro.setVisible(false);
           }
                    
            jlivro.setVisible(false);
           }               
    });     
                


			
                        
                                 
                                
              
}
}
