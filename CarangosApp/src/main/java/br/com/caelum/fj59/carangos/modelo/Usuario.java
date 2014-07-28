package br.com.caelum.fj59.carangos.modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String senha;
	private String imagemAvatar;
    private Humor estadoDeHumor;


	public Usuario(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemAvatar() {
		return imagemAvatar;
	}

	public void setImagemAvatar(String imagemAvatar) {
		this.imagemAvatar = imagemAvatar;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

    public Humor getEstadoDeHumor() {
        return estadoDeHumor;
    }

    public void setEstadoDeHumor(Humor estadoDeHumor) {
        this.estadoDeHumor = estadoDeHumor;
    }
}
