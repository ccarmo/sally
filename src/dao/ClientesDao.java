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
            int nm_aux = Integer.parseInt(addcliente.getNM());
            stm.setInt(7, nm_aux);
            stm.setString(8, addcliente.getST());
            stm.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
            ds.closeDataSource();
        }
    }

    public ArrayList<Cliente> exibirClientes() {
        ArrayList<Cliente> listacliente = new ArrayList<Cliente>();
        DataSource ds = new DataSource();
        try {
          String sqlCliente = "SELECT * FROM usuarios ORDER by user_no";
          conexao = ds.getConnection();
          PreparedStatement stm = conexao.prepareStatement(sqlCliente);
          ResultSet res = stm.executeQuery();
          while(res.next()) { 
            Cliente buscarcliente = new Cliente();
            buscarcliente.setCPF(res.getString("user_cpf"));
            buscarcliente.setDT(res.getString("user_datanasc"));
            buscarcliente.setEmail(res.getString("user_email"));
            buscarcliente.setEndereco(res.getString("user_endereco"));
            String nm_aux = String.valueOf(res.getInt("user_id"));
            buscarcliente.setNM(nm_aux);
            buscarcliente.setNome(res.getString("user_pnome"));
            buscarcliente.setST(res.getString("user_status"));
            buscarcliente.setTelefone(res.getString("user_telefone"));
            listacliente.add(buscarcliente);
          } 
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
          } finally {
            ds.closeDataSource();
          }
          return listacliente;
        }   
    

    public void editarClientes(int numeromatricula, Cliente cliente) {
        DataSource ds = new DataSource();
        try {
           String sqlCliente_altera = "UPDATE usuarios " +  
                                   "SET user_pnome = ?, user_endereco = ?, user_email = ?, user_telefone = ?, user_cpf = ?, user_datanasc = ?" +
                                   "WHERE user_id ="+ numeromatricula;
           conexao = ds.getConnection();
           PreparedStatement stm_altera = conexao.prepareStatement(sqlCliente_altera);
           stm_altera.setString(1, cliente.getNome());
           stm_altera.setString(2, cliente.getEndereco());
           stm_altera.setString(3, cliente.getEmail());
           stm_altera.setString(4, cliente.getTelefone());
           stm_altera.setString(5, cliente.getCPF());
           stm_altera.setString(6, cliente.getDT());
           stm_altera.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cliente atualizado");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
           ds.closeDataSource();
        } 
    }

    public Cliente pesquisarCliente(int numeromatricula){
        Cliente clienteachado = new Cliente();
        DataSource ds = new DataSource();
        try{
          String sqlCliente_pesquisa = "SELECT * FROM usuarios WHERE user_id = " + numeromatricula;
          conexao = ds.getConnection();
          PreparedStatement stm = conexao.prepareStatement(sqlCliente_pesquisa);
          ResultSet res_stm = stm.executeQuery();  
          while(res_stm.next()){
           clienteachado.setCPF(res_stm.getString("user_cpf"));  
           clienteachado.setDT(res_stm.getString("user_datanasc"));
           clienteachado.setEmail(res_stm.getString("user_email"));
           clienteachado.setEndereco(res_stm.getString("user_endereco"));
           String nm_aux = String.valueOf(res_stm.getString("user_id"));
           clienteachado.setNM(nm_aux);
           clienteachado.setNome(res_stm.getString("user_pnome"));
           clienteachado.setST(res_stm.getString("user_status"));
           clienteachado.setTelefone(res_stm.getString("user_telefone"));
          }   
        } catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Erro na conexão"+ex.getMessage());
        } finally {
          ds.closeDataSource(); 
        }
        return clienteachado;

    }

    public void excluirCliente(int codigo){}





    

}

