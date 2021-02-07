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
public class Multa extends DadosPrincipais {
   
    
    public Multa(){
            }
    
    public Multa(int codigomulta, int codigoemprestimo, String NM, String nome, String endereco, String telefone, String titulo, String DTEmprestimo, String DTDevolucao, String DTDevolucaoReal, String DiasMulta,String DTMulta){
        this codigomulta = codigomulta;
		this.codigoemprestimo = codigoemprestimo;
		this.NumeroMatricula = NM;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.titulo = titulo;
        this.DataEmprestimo = DTEmprestimo;
        this.DataDevolucao = DTDevolucao;
        this.DataDevolucaoReal = DTDevolucaoReal;
        this.DataMulta = DTMulta;
        this.DiasMulta = DiasMulta;
    }

	public int getCodigoMulta() {
		return codigomulta;
	}
        
        
	public void setCodigoMulta(int codigomulta){
		this.codigomulta = codigomulta;
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
        
        
	public void setNM(String NM){
		this.NumeroMatricula = NM;
	}
        
        public String getNome() {
		return nome;
	}
        
        
	public void setNome(String nome){
		this.nome = nome;
	}
        
        public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
        
         public String getDTDevolucaoReal() {
		return DataDevolucaoReal;
	}
        
        public void setDTDevolucaoReal(String DTDevolucaoReal) {
		this.DataDevolucaoReal = DTDevolucaoReal;
	}
        
        public String getDiasMulta() {
		return DiasMulta;
	}
        public void setDiasMulta(String DiasMulta) {
		this.DiasMulta = DiasMulta;
	}
        
        public String getDTMulta() {
		return DataMulta;
	}
	public void setDTMulta(String DataMulta) {
		this.DataMulta = DataMulta;
	}
        @Override
	public boolean equals(Object o) {
		Multa mul = new Multa();
		mul = (Multa) o;
		return (this.getNM().equals(mul.getNM()));
	}
}
