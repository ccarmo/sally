package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private String hostname;
    private int    port;
    private String database;
    private String username;
    private String password;

    private Connection connection;

    public DataSource(){
      try {
         hostname = "localhost";
         port     =  5432;
         database = "sally";
         username = "postgres";
         password = "123456";
         
         String url = "jdbc:postgresql://"+hostname+":"+port+"/"+database;
         
         DriverManager.registerDriver(new org.postgresql.Driver());
         connection = DriverManager.getConnection(url, username, password);

        System.out.println("Conexão efetuada");
        
        
        
        }

      catch(SQLException ex) {
          System.err.println("ERRO na conexão"+ex.getMessage());
      }

      catch(Exception ex){
          System.err.println("Erro global"+ex.getMessage());
      }
    }

    public Connection getConnection(){
          return this.connection;
    }

    public void closeDataSource(){
       try{
           connection.close();
       }
       catch(Exception ex) {
           System.err.println("Erro ao desconectar"+ex.getMessage());
       }
}

}