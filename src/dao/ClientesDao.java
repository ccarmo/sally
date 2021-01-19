package dao;

import sally.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientesDao {
    private Connection conexao = null;
    public ClientesDao() {}

    public void add_cliente(Cliente addcliente){
        DataSource ds = new DataSource();
        try{
            String sql = "INSERT INTO usuarios (user_pnome, user_endereco, user_cpf, user_telefone, user_email, user_datanasc, user_id, user_status) VALUES (?,?,?,?,?,?,?,?)";
            conexao = ds.getConnection();
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, addcliente.getNome());
            stm.setString(2, addcliente.getEndereco());
            stm.setString(3, addcliente.getCPF());
            stm.setString(4, addcliente.getTelefone());
            stm.setString(5, addcliente.getEmail());
            stm.setString(6, addcliente.getDT());
            stm.setString(7, addcliente.getNM());
            stm.setString(8, addcliente.getST());
            stm.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }
    }

    public ArrayList<Cliente> exibirClientes(){
        
    }

    public void editarClientes(int codigo, Cliente cliente) {}

    public Cliente pesquisarCliente(int codigo){}

    public void excluirCliente(int codigo){}





    

}

