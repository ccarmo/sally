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
    
    public Devolucao(int codigoemprestimo, String NM, String nome, String titulo, int codigolivro, String DTEmprestimo, String DTDevolucao){
        this.codigoemprestimo = codigoemprestimo;
        this.NumeroMatricula = NM;
        this.nome = nome;
        this.titulo = titulo;
        this.codigolivro = codigolivro;
        this.DataDevolucao = DTDevolucao;
        this.DataEmprestimo = DTEmprestimo;
    } 
    
    public int getCodigoEmprestimo() {
      return codigoemprestimo;
    }
          
          
    public void setCodigoEmprestimo(int codigoemprestimo){
      this.codigoemprestimo = codigoemprestimo;
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

    public void setCodigoLivro(int codigolivro) {
		this.codigolivro = codigolivro;
    }
    
    public int getCodigoLivro() {
		return codigolivro;
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
