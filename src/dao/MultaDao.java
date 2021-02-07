package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sally.Multa;

public class MultaDao {
    private Connection conexao = null;
    public MultaDao(){}

    public void add_multa(Multa addmulta){
        DataSource ds = new DataSource();
        try{
            String sql = "INSERT INTO multa (fk_empre_no, datadevo_real, datadevo_multa, dias_multa) VALUES (?,?,?,?)";
            conexao = ds.getConnection();
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, addmulta.getCodigoEmprestimo());
            stm.setString(2, addmulta.getDTDevolucaoReal());
            stm.setString(3, addmulta.getDTMulta());
            stm.setString(4, addmulta.getDiasMulta());
            stm.execute();
            JOptionPane.showMessageDialog(null, "Multa adicionada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }
    } 

    public ArrayList<Multa> exibirMulta() {
        ArrayList<Multa> listamultas = new ArrayList<Multa>();
        DataSource ds = new DataSource();
        try {
          String sqlmulta = "SELECT multa.multa_no, usuarios.user_id, usuarios.user_pnome, usuarios.user_endereco, livros.lv_titulo, emprestimo.empre_dataini, emprestimo.empre_datadevo, multa.datadevo_real, multa.dias_multa, multa.datadevo_multa FROM ((multa INNER JOIN emprestimo ON multa.fk_empre_no = emprestimo.empre_no) INNER JOIN usuarios ON emprestimo.fk_user_no = usuarios.user_no) INNER JOIN livros ON emprestimo.fk_lv_codigo = livros.lv_codigo ORDER BY multa_no"; 
          conexao = ds.getConnection();
          PreparedStatement stm = conexao.prepareStatement(sqlmulta);
          ResultSet res = stm.executeQuery();
          while(res.next()) { 
            Multa buscarmultas = new Multa();
            buscarmultas.setCodigoMulta(res.getInt("multa_no"));
            buscarmultas.setNM(res.getString("user_id"));
            buscarmultas.setNome(res.getString("user_pnome"));
            buscarmultas.setEndereco(res.getString("user_endereco"));
            buscarmultas.setTitulo(res.getString("lv_titulo"));
            buscarmultas.setDTEmprestimo(res.getString("empre_dataini"));
            buscarmultas.setDTDevolucao(res.getString("empre_datadevo"));
            buscarmultas.setDTDevolucaoReal(res.getString("datadevo_real"));
            buscarmultas.setDiasMulta(res.getString("dias_multa"));
            buscarmultas.setDTMulta(res.getString("datadevo_multa"));

            listamultas.add(buscarmultas);
          } 
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
          } finally {
            ds.closeDataSource();
          }
          return listamultas;
        }

    public void excluirMulta(int codigomulta){
        DataSource ds = new DataSource();
        try {
          conexao = ds.getConnection();
          String sqlDeleta = "DELETE FROM multa WHERE multa_no ="+codigomulta;
          PreparedStatement stm = conexao.prepareStatement(sqlDeleta);
          stm.execute();   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }

    }


}
