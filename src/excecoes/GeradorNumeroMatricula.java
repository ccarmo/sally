
package excecoes;
import sally.*;
import controles.*;

public class GeradorNumeroMatricula {
    public static String NumeroMatriculaAux;
    public static int EncontraIndice = 0;
    
    public static  void GeraNM(){
        EncontraIndice = ControleCadastroCliente.clienteDB.size();
          if (EncontraIndice == 0){
              NumeroMatriculaAux = String.valueOf(DadosPrincipais.geraNumeroMatricula++);
          }else{
              EncontraIndice = DadosPrincipais.geraNumeroMatricula;
              NumeroMatriculaAux = String.valueOf(DadosPrincipais.geraNumeroMatricula++);
          }
          
      
    }
}
