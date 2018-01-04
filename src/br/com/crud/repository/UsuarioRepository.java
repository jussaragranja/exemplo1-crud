/**
 * 
 */
package br.com.crud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.conection.Conection;
import br.com.crud.model.Usuario;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class UsuarioRepository {
	
	Connection con ;
	
	public UsuarioRepository() {
		
		this.con = Conection.getConnection();
	}
	
	public boolean salvar(Usuario usuario) throws SQLException {
		this.con = Conection.getConnection();
		String sql = "INSERT INTO usuario (nome,email) VALUES (?,?)";
		
		PreparedStatement stmt = this.con.prepareStatement(sql);
		
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getEmail());
		
		boolean salvou = stmt.executeUpdate() > 0;
		stmt.close();
		
		return salvou;
	}
	
	public List<Usuario> lista() throws SQLException{
		List<Usuario> usuarios = new ArrayList<>();
		this.con = Conection.getConnection();
		
		String sql = "SELECT * FROM usuario";
		
		Statement stmt = this.con.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		
		while (res.next()) {
			Usuario usuario = new Usuario();
			
			usuario.setId(res.getLong("id"));
			usuario.setEmail(res.getString("email"));
			usuario.setNome(res.getString("nome"));
			
			usuarios.add(usuario);
			
		}
		
		res.close();
		stmt.close();
		this.con.close();
		
		return usuarios;
	}
	
	public boolean delete(Long idUsuario) throws SQLException{
		this.con = Conection.getConnection();
		String sql = "DELETE FROM usuario WHERE id = ? ";		
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1, idUsuario);
		
		Boolean deletou = stmt.executeUpdate() > 0;
		stmt.close();
		this.con.close();
		
		return deletou;
	}
	
	public boolean update(Usuario usuario) throws SQLException {
		this.con = Conection.getConnection();
	
		String sql = "UPDATE usuario SET nome = ?, email = ?";
        sql += " WHERE id = ?";
	    PreparedStatement stmt = this.con.prepareStatement(sql);
	  
	    stmt.setString(1, usuario.getNome());
	    stmt.setString(2, usuario.getEmail());
	    stmt.setLong(3, usuario.getId());
	    
	    
	    boolean atualizou = stmt.executeUpdate() > 0;
	    this.con.close();
	    stmt.close();
	    
	    return atualizou;
		
	}
	
	public Usuario recuperaUsuario(Long id) throws SQLException{
		this.con = Conection.getConnection();
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id = ? ";
		
		PreparedStatement stmt = this.con.prepareStatement(sql);
		stmt.setLong(1, id);
		
		ResultSet resultSet = stmt.executeQuery();
		while(resultSet.next()) {

			usuario.setId(resultSet.getLong("id"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			
		}
		
		stmt.close();
		resultSet.close();
		this.con.close();
		
		return usuario;
	}
}
