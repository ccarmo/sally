
package excecoes;

import javax.swing.JOptionPane;


public class ValidacaoDeCadastro {
    
    
       public static final String validaNotNull(String value)throws IllegalArgumentException{        
       if(value == null || value.isEmpty()) throw new IllegalArgumentException("O valor não deve ser nulo ou vazio");
       return value;
       
        }  
         
       public static final String validaNotZero(String value)throws Exception{        
       if(Integer.parseInt(value) == 0 || Integer.parseInt(value)< 0) throw new Exception("O valor não deve ser maior ou igual a zero");
       return value;
       
        }
       
  
        
    
}
