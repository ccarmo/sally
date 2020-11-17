
package sally;


public class Livro extends DadosPrincipais {
   
    public Livro(){}
    
    public Livro(String codigo, String titulo, String autor,String edicao, String ano, String Dispo){
		this.Codigo = codigo ;
		this.titulo = titulo;
                this.autor = autor;
                this.edicao = edicao;
                this.ano = ano;
                this.Dispo = Dispo;
                
	}
	
      
        
        public String getCodigo() {
		return Codigo;
	}
        
        
	public void setCodigo(String codigo){
		this.Codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
        public String getEdicao() {
		return edicao;
	}
        
        
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
        
        
        public String getAno() {
		return ano;
	}
        public void setAno(String ano) {
		this.ano = ano;
	}
       
	public String getDispo() {
		return Dispo;
	}
        public void setDispo(String Dispo) {
		this.Dispo = Dispo;
	}
        
        
        
        @Override
	public boolean equals(Object t) {
		Livro li = new Livro();
		li = (Livro) t;
		return (this.getDispo().equals(li.getDispo()));
	}
        
        
}
