
package excecoes;
import controles.ControleCadastroCliente;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import sally.*;
import controles.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class VerificaMulta {
    static SimpleDateFormat FormatoData= new SimpleDateFormat("dd/MM/yyyy");
    public static int aux;
    public static final int GeraDiasInteiros(Date DataEmprestimo, Date DataDevolucaoReal){ 
      Calendar DataEmprestimoCalendar = Calendar.getInstance();
      DataEmprestimoCalendar.setTime(DataEmprestimo);
      Calendar DataDevolucaoRealCalendar = Calendar.getInstance();
      DataDevolucaoRealCalendar.setTime(DataDevolucaoReal);
      long diferenca = DataDevolucaoRealCalendar.getTime().getTime() - DataEmprestimoCalendar.getTime().getTime();
      long ConverteMiliDias = TimeUnit.MILLISECONDS.toDays(diferenca);
      Integer dias = (int) (long) ConverteMiliDias;
      return dias;
    }
    
    public static final Calendar GeraDataMultaCalendar(int diasInteiros, Calendar DataDevolucaoRealCalendar){
        Calendar DataMultaCalendar = Calendar.getInstance();
        DataMultaCalendar.set(Calendar.DAY_OF_MONTH, DataDevolucaoRealCalendar.get(Calendar.DAY_OF_MONTH)+ diasInteiros);
        return DataMultaCalendar;
    }
    
    public static final String GeraDataMulta(Calendar DataMultaCalendar){
        String DataMulta = FormatoData.format(DataMultaCalendar.getTime());
        return DataMulta;
    }
    

    
   

    
    public static  int MultaPosicoes(String NM){
         int posicao;
         ArrayList<Integer> multaPosicoes = new ArrayList<Integer>();
      
         
         Multa multa = new Multa();
         for(int i = 0; i < ControleDevolucao.multaDB.size();i++){
               multa =  ControleDevolucao.multaDB.get(i);
               if(multa.getNM().equals(NM)){
                  posicao = i; 
                  multaPosicoes.add(posicao);
                  
               }
          
    }
          return multaPosicoes.size();
    }
    
    public static void MudaStatus(int multaPosicoes, String NM){
      
        Cliente cliente = new Cliente();
        cliente.setNM(NM);
        if(multaPosicoes == 0){
            for(Cliente c : ControleCadastroCliente.clienteDB){
               if(c.equals(cliente)){
                   c.setST("ATIVADO");
               }
            }
        }
    }
}
