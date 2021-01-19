package dao;

import sally.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LivrosDao {
    private Connection conexao = null;
    
    public LivrosDao() {}     
    public void add_livro(Livro addlivro) {
      DataSource ds = new DataSource();    
      try {
        String sql = "INSERT INTO livros (lv_titulo, lv_ano, lv_qtd, lv_edicao, lv_autor) VALUES (?,?,?,?,?)";
        conexao = ds.getConnection();
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, addlivro.getTitulo());
        stm.setString(2, addlivro.getAno());
        stm.setString(3, addlivro.getDispo());
        stm.setString(4, addlivro.getEdicao());
        stm.setString(5, addlivro.getAutor());
        stm.execute();
        JOptionPane.showMessageDialog(null, "Livro cadastrado");
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
      } finally {
        ds.closeDataSource();
      }
    
    }

    public ArrayList<Livro> exibirLivros() {
      ArrayList<Livro> listaLivro = new ArrayList<Livro>();
      DataSource ds = new DataSource();
      try {
        String sqlLivro = "SELECT * FROM livros ORDER by lv_codigo";
        conexao = ds.getConnection();
        PreparedStatement stm = conexao.prepareStatement(sqlLivro);
        ResultSet res = stm.executeQuery();
        while(res.next()) { 
          Livro buscarlivro = new Livro();
          buscarlivro.setCodigo(res.getInt(1));
          buscarlivro.setAno(res.getString("lv_ano"));
          buscarlivro.setAutor(res.getString("lv_autor"));
          buscarlivro.setDispo(res.getString("lv_qtd"));
          buscarlivro.setEdicao(res.getString("lv_edicao"));
          buscarlivro.setTitulo(res.getString("lv_titulo"));
          listaLivro.add(buscarlivro);
        } 
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
          ds.closeDataSource();
        }
        return listaLivro;
      }

      public void editarLivro(int codigo, Livro livro){
         DataSource ds = new DataSource();
         try {
            String sqlLivro_altera = "UPDATE livros " +  
                                    "SET lv_ano = ?, lv_autor = ?, lv_qtd = ?, lv_edicao = ?, lv_titulo = ?" +
                                    "WHERE lv_codigo ="+codigo;
            conexao = ds.getConnection();
            PreparedStatement stm_altera = conexao.prepareStatement(sqlLivro_altera);
            stm_altera.setString(1, livro.getAno());
            stm_altera.setString(2, livro.getAutor());
            stm_altera.setString(3, livro.getDispo());
            stm_altera.setString(4, livro.getEdicao());
            stm_altera.setString(5, livro.getTitulo());
            stm_altera.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro atualizado");
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
         } finally {
            ds.closeDataSource();
         }
            
     }

     public Livro pesquisarLivro(int codigo){ 
        Livro livroAchado = new Livro();
        DataSource ds = new DataSource();
        try{
          
          String sqlLivro_pesquisa = "SELECT * FROM livros WHERE lv_codigo = " + codigo;
          conexao = ds.getConnection();
          PreparedStatement stm = conexao.prepareStatement(sqlLivro_pesquisa);
          ResultSet res_stm = stm.executeQuery();  
          while(res_stm.next()){
           livroAchado.setCodigo(res_stm.getInt("lv_codigo"));
           livroAchado.setAno(res_stm.getString("lv_ano"));
           livroAchado.setAutor(res_stm.getString("lv_autor"));
           livroAchado.setDispo(res_stm.getString("lv_qtd"));
           livroAchado.setEdicao(res_stm.getString("lv_edicao"));
           livroAchado.setTitulo(res_stm.getString("lv_titulo"));
          }   
        } catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
          ds.closeDataSource(); 
        }
        return livroAchado;
    }
       
    public void excluirLivro(int codigo){
        String sqlLivro_excluir = "DELETE FROM livros WHERE lv_codigo="+codigo;
        Livro livro_excluido = new Livro();
        DataSource ds = new DataSource();
        try{
            conexao = ds.getConnection();
            PreparedStatement stm = conexao.prepareStatement(sqlLivro_excluir);
            stm.execute();
            JOptionPane.showMessageDialog(null, "Livro excluido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
          ds.closeDataSource();
        }

    }      
}
      
