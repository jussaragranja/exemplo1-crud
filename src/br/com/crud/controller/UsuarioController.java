package br.com.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.model.Usuario;
import br.com.crud.service.UsuarioService;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService servico;
	
	public UsuarioController() {
		this.servico = new UsuarioService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "salvar":
				salvaUsuario(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateUsuario(request, response);
				break;
			default:
				listUsuario(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Usuario> usuarios = this.servico.lista();
		request.setAttribute("usuarios",usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listaUsuarios.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("addUsuario.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		
		Usuario existiUsuario = this.servico.busca(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addUsuario.jsp");
		request.setAttribute("usuario", existiUsuario);
		dispatcher.forward(request, response);

	}

	private void salvaUsuario(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
			
		String id = request.getParameter("id");
		
		if(id != null && !id.isEmpty()) {	
			Usuario usuario = this.servico.busca(Long.parseLong(id));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setId(Long.parseLong(id));
			this.servico.update(usuario);
			request.setAttribute("cadastroSucesso","Usuário cadastrador com sucesso.");
			
			listUsuario(request, response);
			
		}
		
		if(id.isEmpty()) {
			
			Usuario newUsuario = new Usuario();
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			
			newUsuario.setNome(nome);
			newUsuario.setEmail(email);
			
			this.servico.salvar(newUsuario);
			
			listUsuario(request, response);
		}
	}

	private void updateUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");

		Usuario usuarioEdit = new Usuario();
		usuarioEdit.setId(id);
		usuarioEdit.setNome(nome);
		usuarioEdit.setEmail(email);
		
		this.servico.update(usuarioEdit);
		listUsuario(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
		Long id = Long.parseLong(request.getParameter("id"));
		this.servico.delete(id);
		listUsuario(request, response);

	}

}
