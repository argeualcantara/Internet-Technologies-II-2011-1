package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.UsuarioBD;
import form.UsuarioForm;

public class UsuarioAction extends DispatchAction{
	
	public ActionForward login(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
		UsuarioForm uf =(UsuarioForm) form;
		Usuario user=new Usuario();
		
		if(uf.getLogin().trim().length()>0 && uf.getSenha().trim().length()>0
				&& uf.getLogin()!=null && uf.getLogin()!=null){
			user.setLogin(uf.getLogin());
			user.setSenha(uf.getSenha());
			if(UsuarioBD.getInstance().login(user)){
				HttpSession session=request.getSession();
				Date data = new Date();
				SimpleDateFormat f= new SimpleDateFormat("hh:mm");
				String hora=f.format(data);
				session.setAttribute("hora",hora);
				session.setAttribute("login",user.getLogin());
				return mapping.findForward("login");
			}
		}
		if(!UsuarioBD.getInstance().validarLigin(user.getLogin())){
			request.setAttribute("senhaI",'g');
			return mapping.findForward("logout");
		}
		((UsuarioForm) form).setSenha("");
		return mapping.findForward("erro");
		
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {
				HttpSession session=request.getSession();
				session.removeAttribute("hora");
				session.removeAttribute("login");
				return mapping.findForward("logout");
	}
	
	public ActionForward registrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UsuarioForm uf =(UsuarioForm) form;
		Usuario user=new Usuario();
		user.setLogin(uf.getLogin());
		if(uf.getNome()=="" || uf.getNome()==null ){
			request.setAttribute("erroNome","true");
			return mapping.findForward("erro");
		}
		if(uf.getLogin()=="" || uf.getLogin()==null){
			request.setAttribute("erroLogin","true");
			return mapping.findForward("erro");
		}
		if(UsuarioBD.getInstance().validarLigin(user.getLogin())){
			user.setNome(uf.getNome());
			user.setSenha(uf.getSenha());
			UsuarioBD.getInstance().inserir(user);
		}else{
			request.setAttribute("erroLogin","true");
			return mapping.findForward("erro");
		}
		
		return mapping.findForward("inicio"); 
	}
}
