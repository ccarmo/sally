package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmprestimoDao {
    private Connection conexao = null;
    public EmprestimoDao(){}
    int clientecodigo;
    public void add_emprestimo (ArrayList addemprestimo){

        DataSource ds = new DataSource();
        try{
            String sqlEmprestimo = "INSERT INTO emprestimo (fk_user_no, fk_lv_codigo, empre_dataini, empre_datadevo) VALUES (?,?,?,?) ";     
            conexao = ds.getConnection();
            PreparedStatement stm = conexao.prepareStatement(sqlEmprestimo);
            stm.setInt(1, (int) addemprestimo.get(0));
            stm.setInt(2, (int) addemprestimo.get(1));
            stm.setString(3, (String) addemprestimo.get(2));
            stm.setString(4, (String) addemprestimo.get(3));
            stm.execute();
            JOptionPane.showMessageDialog(null, "Empréstimo Cadastrado");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }
    }

    public int pesquisarCodigoCliente(int numeromatricula)  {
        DataSource ds = new DataSource();
        String sqlCodigoCliente = "SELECT user_no from usuarios WHERE user_id = "+numeromatricula;
        try{
            conexao = ds.getConnection();
            PreparedStatement stm = conexao.prepareStatement(sqlCodigoCliente);
            ResultSet res_stm = stm.executeQuery();
            while(res_stm.next()){
                clientecodigo = res_stm.getInt("user_no");
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }
        return clientecodigo;
    }
}