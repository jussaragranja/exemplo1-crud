/**
 * 
 */
package br.com.crud.main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import br.com.crud.model.Usuario;
import br.com.crud.service.UsuarioService;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
		
		UsuarioService service = new UsuarioService();
		service = new UsuarioService();
		
//		Usuario usuario = new Usuario();
//		
//		usuario.setEmail("cbgomes@gmail.com");
//		usuario.setNome("Carlos Barbosa G. Filho");
//		
//		service.salvar(usuario);
//		System.out.println("Salvou o usuário com suscesso");
		
//		List<Usuario> usuarios = service.lista();
//		for(Usuario usuario : usuarios) {
//			System.out.println(">>>>>>>>>>>>>>>>>> Lista de Usuários <<<<<<<<<<<<<<<<<<<<<" );
//			System.out.println("Nome  : " + usuario.getNome());
//			System.out.println("Email : " + usuario.getEmail());
//		}
		
		Usuario usuario = service.busca(1L);
		System.out.println(usuario.getNome());
				
	}

}
