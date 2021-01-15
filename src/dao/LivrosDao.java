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
    public LivrosDao() {
    }     
    public void add_livro(Livro addlivro) {
      String sql = "INSERT INTO livros (lv_titulo, lv_ano, lv_qtd, lv_edicao, lv_autor) VALUES (?,?,?,?,?)";
      try {
        DataSource ds = new DataSource();
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
     } 
    }
     public ArrayList<Livro> buscarLivro() {
        String sqlLivro = "SELECT * FROM livros";
        ArrayList<Livro> listaLivro = new ArrayList<Livro>();
        
        try {
          DataSource ds = new DataSource();
          conexao = ds.getConnection();
          PreparedStatement stm = conexao.prepareStatement(sqlLivro);
          ResultSet res = stm.executeQuery();
          
        while(res.next()) { 
          Livro buscarlivro = new Livro();
          buscarlivro.setAno(res.getString("lv_ano"));
          buscarlivro.setAutor(res.getString("lv_autor"));
          buscarlivro.setCodigo(res.getString("lv_codigo"));
          buscarlivro.setDispo(res.getString("lv_qtd"));
          buscarlivro.setEdicao(res.getString("lv_edicao"));
          buscarlivro.setTitulo(res.getString("lv_titulo"));
          listaLivro.add(buscarlivro);
         } 
        
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        }
        return listaLivro;
     }
    
}
