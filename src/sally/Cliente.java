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
public class Cliente extends DadosPrincipais  {
        
	
        public Cliente(){}
        
	public Cliente(String nome, String endereco,  String email,String telefone, String CPF, String DTNasci, String NM, String ST)   {
		this.nome = nome ;
		this.endereco = endereco;
                this.email = email;
                this.telefone = telefone;
                this.CPF = CPF;
                this.DataNascimento = DTNasci;
                this.NumeroMatricula = NM;
                this.StatusUsuario = ST;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        public String getTelefone() {
		return telefone;
	}
        
        
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
        
        
        public String getCPF() {
		return CPF;
	}
        public void setCPF(String CPF) {
		this.CPF = CPF;
	}
       
	public String getDT() {
		return DataNascimento;
	}
        
        public void setDT(String DTNasci) {
		this.DataNascimento = DTNasci;
	}
        
        public String getNM() {
		return NumeroMatricula;
	}
        
        public void setNM(String NM) {
		this.NumeroMatricula = NM;
	}
        
        public String getST() {
		return StatusUsuario;
	}
        
        public void setST(String ST) {
		this.StatusUsuario = ST;
	}

        @Override
	public boolean equals(Object o) {
		Cliente c = new Cliente();
		c = (Cliente) o;
		return (this.getNM().equals(c.getNM()));
	}
        
}


