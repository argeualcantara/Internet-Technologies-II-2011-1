package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import dao.UsuarioBD;
import form.UsuarioForm;

/**
 * Servlet implementation class Cadastro
 */
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario uf = new Usuario();
		uf.setNome(request.getParameter("nome"));
		uf.setLogin(request.getParameter("login"));
		uf.setSenha(request.getParameter("senha"));
		RequestDispatcher rd=request.getRequestDispatcher("pages/cadastro.jsp");
		
		if (uf.getNome() == "" || uf.getNome() == null) {
			request.setAttribute("nome","");
			
			if(uf.getLogin()==null || uf.getLogin().equals(""))
				request.setAttribute("login","");
			else
				request.setAttribute("login",uf.getLogin());
			
			request.setAttribute("erroNome", "true");
		}
		if (uf.getSenha() == "" || uf.getSenha() == null) {
			request.setAttribute("senha","");
			
			if(uf.getLogin()==null || uf.getLogin().equals(""))
				request.setAttribute("login","");
			else
				request.setAttribute("login",uf.getLogin());
			
			if(uf.getNome()==null || uf.getNome().equals(""))
				request.setAttribute("nome","");
			else
				request.setAttribute("nome",uf.getNome());
			
			request.setAttribute("erroSenha", "true");
		}
		if (uf.getLogin() == "" || uf.getLogin() == null) {
			
			if(uf.getSenha()==null || uf.getSenha().equals(""))
				request.setAttribute("senha","");
			else
				request.setAttribute("senha",uf.getSenha());
			
			if(uf.getNome()==null || uf.getNome().equals(""))
				request.setAttribute("nome","");
			else
				request.setAttribute("nome",uf.getNome());
			
			request.setAttribute("login","");
			request.setAttribute("erroLogin", "true");
		}
		if (UsuarioBD.getInstance().validarLigin(uf.getLogin())) {
			if(uf.getNome().length()>0 && uf.getSenha().length()>0){
				UsuarioBD.getInstance().inserir(uf);
				request.setAttribute("login","");
				request.setAttribute("nome","");
				request.setAttribute("senha","");
				rd=request.getRequestDispatcher("Login.do?method=loginPreparar");
			}
		} else {
			if(uf.getLogin().length()>0)
				request.setAttribute("erroLogin", "true");
			request.setAttribute("nome",uf.getNome());
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
