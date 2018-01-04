package br.com.crud.service;

import java.sql.SQLException;
import java.util.List;

import br.com.crud.model.Usuario;
import br.com.crud.repository.UsuarioRepository;

public class UsuarioService {

	public UsuarioRepository repositorio;
	
	
	public UsuarioService() {
		this.repositorio = new UsuarioRepository();
	}
	
	public void salvar(Usuario usuario) throws SQLException {
		this.repositorio.salvar(usuario);
	}
	
	public List<Usuario> lista() throws SQLException{
		return this.repositorio.lista();
	}
	
	public Usuario busca(Long id) throws SQLException {
		return this.repositorio.recuperaUsuario(id);
	}
	
	public void update(Usuario usuario) throws SQLException{
		 this.repositorio.update(usuario);
	}
	
	public void delete(Long idUsuario) throws SQLException{
		this.repositorio.delete(idUsuario);
	}
}
