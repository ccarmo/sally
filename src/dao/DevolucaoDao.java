package dao;

import java.util.ArrayList;
import sally.Devolucao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DevolucaoDao {
    private Connection conexao = null;
    public DevolucaoDao(){}
    
    public ArrayList<Devolucao> exibirDevolucoes(){
        ArrayList<Devolucao> listadevolucao = new ArrayList<Devolucao>();
        DataSource ds = new DataSource();
        
        try {
           conexao = ds.getConnection();
           String sqlDevolucao = "SELECT usuarios.user_id, usuarios.user_pnome, emprestimo.fk_lv_codigo, livros.lv_titulo, emprestimo.empre_dataini, emprestimo.empre_datadevo FROM ((emprestimo INNER JOIN usuarios ON emprestimo.fk_user_no = usuarios.user_no) INNER JOIN livros ON emprestimo.fk_lv_codigo = livros.lv_codigo) ORDER BY empre_no";  
                                  
           PreparedStatement stm = conexao.prepareStatement(sqlDevolucao); 
           ResultSet res_stm = stm.executeQuery();
            while (res_stm.next()){
                Devolucao devolucao = new Devolucao();
                String numeromatricula = String.valueOf(res_stm.getInt("user_id"));
                devolucao.setNM(numeromatricula);
                devolucao.setNome(res_stm.getString("user_pnome"));
                devolucao.setTitulo(res_stm.getString("lv_titulo"));
                devolucao.setCodigoLivro(res_stm.getInt("fk_lv_codigo"));
                devolucao.setDTEmprestimo(res_stm.getString("empre_dataini"));
                devolucao.setDTDevolucao(res_stm.getString("empre_datadevo"));
                listadevolucao.add(devolucao);
            }    
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }
        
        return listadevolucao;
       }

       public void aumentarQuantidade(int lv_codigo, int novaquantidade){
           DataSource ds = new DataSource();
           try{
           conexao = ds.getConnection();
           String sqlAumenta = "UPDATE livros SET lv_qtd = ? WHERE lv_codigo = "+lv_codigo;
           PreparedStatement stm = conexao.prepareStatement(sqlAumenta);
           stm.setInt(1, novaquantidade);
           stm.executeUpdate();
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
           } finally {
            ds.closeDataSource();
           }
       }

    }
