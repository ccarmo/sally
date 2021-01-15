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

public void add_livro(Livro livro) {
    String sql = "INSERT INTO livros (lv_titulo, lv_ano, lv_qtd, lv_edicao, lv_autor) VALUES (?,?,?,?,?)";

    try {
        DataSource ds = new DataSource();
        conexao = ds.getConnection();
        PreparedStatement stm = conexao.prepareStatement(sql);
        
        stm.setString(1, livro.getTitulo());
        stm.setString(2, livro.getAno());
        stm.setString(3, livro.getDispo());
        stm.setString(4, livro.getEdicao());
        stm.setString(5, livro.getAutor());
        stm.execute();
        JOptionPane.showMessageDialog(null, "Livro cadastrado");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
    } 
    

 }
}