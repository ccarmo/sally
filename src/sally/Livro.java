
package sally;


public class Livro extends DadosPrincipais {
   
    public Livro(){}
    
    public Livro(int codigo, String titulo, String autor,String edicao, String ano, String Dispo){
		this.codigo = codigo ;
		this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.ano = ano;
        this.Dispo = Dispo;
                
	}
	
    public int getCodigo() {
		return codigo;
	}
        
        
	public void setCodigo(int codigo){
		this.codigo = codigo;
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
