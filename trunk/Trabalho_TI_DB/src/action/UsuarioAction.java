package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Arquivo;
import model.Usuario;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.ArquivoBD;
import dao.UsuarioBD;
import form.ArquivoForm;
import form.UsuarioForm;

public class UsuarioAction extends DispatchAction {

	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UsuarioForm uf = (UsuarioForm) form;
		Usuario user = new Usuario();

		if (request.getRemoteUser().toString().trim().length() > 0
				&& request.getRemoteUser() != null) {
			user.setLogin(request.getRemoteUser().toString());
			user.setSenha(uf.getSenha());
			
				HttpSession session = request.getSession();
				session.setAttribute("hora", request.getAttribute("hora"));
				session.setAttribute("login", request.getAttribute("login"));
				return mapping.findForward("login");
			
		}
		return mapping.findForward("erro");

	}
	
	public ActionForward loginPreparar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Usuario user = new Usuario();

		if (request.getRemoteUser() != null && request.getRemoteUser().toString().trim().length() > 0) {
			user.setLogin(request.getRemoteUser().toString());
			
				Date data = new Date();
				SimpleDateFormat f = new SimpleDateFormat("HH:mm");
				String hora = f.format(data);
				request.setAttribute("hora", hora);
				request.setAttribute("login", user.getLogin());
				return login(mapping, form, request, response);
		}
		return mapping.findForward("erro");

	}

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		request.getRemoteUser();
		session.removeAttribute("hora");
		session.removeAttribute("login");
		session.invalidate();
		return mapping.findForward("logout");
	}
	
	public ActionForward trazer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String mostrar=request.getParameter("mostrar").toString();
		if(mostrar.equals("busca")){
			request.setAttribute("busca", true);
		}else{
			request.setAttribute("exibir", true);
			exibirArquivos(mapping, form, request, response);
		}
		return mapping.findForward("exibirDiv");
	}

	public ActionForward registrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UsuarioForm uf = (UsuarioForm) form;
		Usuario user = new Usuario();
		user.setLogin(uf.getLogin());
		if (uf.getNome() == "" || uf.getNome() == null) {
			request.setAttribute("erroNome", "true");
			return mapping.findForward("erro");
		}
		if (uf.getLogin() == "" || uf.getLogin() == null) {
			request.setAttribute("erroLogin", "true");
			return mapping.findForward("erro");
		}
		if (UsuarioBD.getInstance().validarLigin(user.getLogin())) {
			user.setNome(uf.getNome());
			user.setSenha(uf.getSenha());
			UsuarioBD.getInstance().inserir(user);
		} else {
			request.setAttribute("erroLogin", "true");
			return mapping.findForward("erro");
		}

		return mapping.findForward("login");
	}
	
	public ActionForward buscarArquivos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				HttpSession session=request.getSession();
				String login=request.getRemoteUser().toString();
				session.setAttribute("login", login);
				Date data=new Date();
				SimpleDateFormat f = new SimpleDateFormat("HH:mm");
				String hora = f.format(data);
				session.setAttribute("hora", hora);
				String nome = ((ArquivoForm)form).getNome();
				List<Arquivo> arquivos = ArquivoBD.getInstance().buscarArquivos(login, nome);
				request.setAttribute("arquivos", arquivos);
				request.setAttribute("lista", true);
				request.setAttribute("busca", true);
				return mapping.findForward("exibirDiv");
	}
	
	public ActionForward exibirArquivos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				HttpSession session=request.getSession();
				
				String login=request.getRemoteUser().toString();
				session.setAttribute("login", login);
				Date data=new Date();
				SimpleDateFormat f = new SimpleDateFormat("HH:mm");
				String hora = f.format(data);
				session.setAttribute("hora", hora);
				List<Arquivo> tudo = ArquivoBD.getInstance().listarArquivos(login,"");
				
				request.setAttribute("arquivos", tudo);
				request.setAttribute("exibir", true);
				return mapping.findForward("exibirDiv");
				
				
	}
}
