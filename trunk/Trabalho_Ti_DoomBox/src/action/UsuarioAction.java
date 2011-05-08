package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dao.UsuarioBD;
import form.UsuarioForm;

public class UsuarioAction extends DispatchAction{
	public ActionForward registrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UsuarioForm uf =(UsuarioForm) form;
		Usuario user=new Usuario();
		user.setLogin_usuario(uf.getLogin_usuario());
		if(uf.getNome()=="" || uf.getNome()==null ){
			request.setAttribute("erroNome","true");
			return mapping.findForward("erro");
		}
		if(uf.getLogin_usuario()=="" || uf.getLogin_usuario()==null){
			request.setAttribute("erroLogin","true");
			return mapping.findForward("erro");
		}
		if(UsuarioBD.getInstance().validarLigin(user.getLogin_usuario())){
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
