package sally;
import dao.DataSource;
import telas.JanelaPrincipal;
import controles.*;

public class Principal {

   
    public static void main(String[] args) {
       
        new ControlePrincipal();
        DataSource ds = new DataSource();
        ds.closeDataSource();
    }
    
}
