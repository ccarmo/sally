/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sally;

/**
 *
 * @author Administrador
 */
public class Devolucao extends DadosPrincipais {
   public Devolucao(){
            }
    
    public Devolucao(String NM, String nome, String titulo, String DTEmprestimo, String DTDevolucao){
        this.NumeroMatricula = NM;
        this.nome = nome;
        this.titulo = titulo;
        this.DataDevolucao = DTDevolucao;
        this.DataEmprestimo = DTEmprestimo;
    } 
    
    
    
    
     public String getNM() {
		return NumeroMatricula;
     }
        
     public void setNM(String NM) {
		this.NumeroMatricula = NM;
     }
     
     public String getNome() {
		return nome;
     }
        
     public void setNome(String nome) {
		this.nome = nome;
     }
    
     public String getTitulo() {
		return titulo;
     }
        
     public void setTitulo(String titulo) {
		this.titulo = titulo;
     }
    
     public String getDTEmprestimo() {
		return DataEmprestimo;
     }
        
     public void setDTEmprestimo(String DTEmprestimo) {
		this.DataEmprestimo = DTEmprestimo;
     }
    
    
     public String getDTDevolucao() {
		return DataDevolucao;
     }
        
     public void setDTDevolucao(String DTDevolucao) {
		this.DataDevolucao = DTDevolucao;
     }
     
     @Override
	public boolean equals(Object o) {
		Devolucao dev = new Devolucao();
		dev = (Devolucao) o;
		return (this.getDTDevolucao().equals(dev.getDTDevolucao()));
	}
}
