package br.com.caelum.fj59.carangos.modelo;

import java.io.Serializable;

public class Publicacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String mensagem;
	private Usuario autor;
    private Humor estadoDeHumor;
    private String foto;

    @Deprecated
    public Publicacao() {}

    public Publicacao(String mensagem, Usuario autor, Humor estadoDeHumor) {
        this.mensagem = mensagem;
        this.autor = autor;
        this.estadoDeHumor = estadoDeHumor;
    }

    public Publicacao(String mensagem, Usuario usuario, Humor estadoDeHumor, String foto) {
        this.mensagem = mensagem;
        this.autor = usuario;
        this.estadoDeHumor = estadoDeHumor;
        this.foto = foto;
    }

    @Override
	public String toString() {
		return String.format("(%s) %s",this.autor, this.mensagem);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getFoto() {
		return foto;
	}

    public Humor getEstadoDeHumor() {
        return estadoDeHumor;
    }

    public void setEstadoDeHumor(Humor estadoDeHumor) {
        this.estadoDeHumor = estadoDeHumor;
    }
}
