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
public class Emprestimo extends DadosPrincipais  {
    public Emprestimo(){
            }
    
    public Emprestimo(String NM, String nome, String Codigo, String titulo, String DTEmprestimo, String DTDevolucao, String posicaolivro){
        this.NumeroMatricula = NM;
        this.nome = nome;
        this.codigo = codigo;
        this.titulo = titulo;
        this.DataEmprestimo = DTEmprestimo;
        this.DataDevolucao = DTDevolucao;
        this.PosicaoLivro = posicaolivro;
    }
    
        public String getNM() {
		return NumeroMatricula;
	}
        
        
	public void setNM(String NM){
		this.NumeroMatricula = NM;
	}
        
        public String getNome() {
		return nome;
	}
        
        
	public void setNome(String nome){
		this.nome = nome;
	}
        
        public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		this.Codigo = codigo;
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
        
        public String getPosicaoLivro() {
		return PosicaoLivro;
	}
        public void setPosicaoLivro(String posicaolivro) {
		this.PosicaoLivro = posicaolivro;
	}
        
}
