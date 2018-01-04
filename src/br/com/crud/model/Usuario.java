/**
 * 
 */
package br.com.crud.model;

import java.io.Serializable;

/**
 * @author carlosbarbosagomesfilho
 *
 */

public class Usuario implements Serializable {

	private Long id;

	private String nome;

	private String email;

	public Usuario() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
