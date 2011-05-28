package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import dao.ArquivoBD;

import form.UploadForm;

public class UploadAction extends DispatchAction {

	
	public ActionForward upload(ActionMapping mapping, 
								ActionForm form, 
								HttpServletRequest request, 
								HttpServletResponse response) throws Exception {


        UploadForm uploadForm = (UploadForm)form;

		try {
			if(uploadForm.getDescricao()!=null && !(uploadForm.getDescricao().equals(""))){
		        FormFile formFile = uploadForm.getArquivo();
		        String[] pais = uploadForm.getPais();
		        String descricao = uploadForm.getDescricao();
		
				String strFileName = formFile.getFileName();
				
				System.out.println(strFileName);
				int ponto = strFileName.lastIndexOf(".");
				String nome = strFileName.substring(0, ponto);
				String extensao = strFileName.substring(ponto);
				
				System.out.println("nome: "+nome);
				System.out.println("extensão: "+extensao);
				long tamanho = formFile.getFileSize();
				int id = 0;
				
				// AUMENTAR O TAMANHO DO VARCHAR DE NOME!
				for (int i = 0; i < pais.length; i++) {
					id = ArquivoBD.getInstance().inserirArquivo(nome, Integer.parseInt(pais[i]), tamanho, "MASTER", descricao);
					System.out.println(id);
				}
				
				System.out.println("Tamanho: "+tamanho);
				String nomeArq = "Arquivo_"+id+extensao;
				
				byte dataFile[] = formFile.getFileData();
		
				File file = new File("C:/Temp/" + nomeArq);
		
				OutputStream out = new FileOutputStream(file);
				out.write(dataFile);
				out.close();
			}else{
				HttpSession session=request.getSession();
				String [] pais= uploadForm.getPais();
				String nomeDiretorio = uploadForm.getNomeDiretorio();
				String login=session.getAttribute("login").toString();
				for(int i=0; i<pais.length; i++){
					ArquivoBD.getInstance().criarDiretorio(Integer.parseInt(pais[i]), nomeDiretorio, login);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("sucesso");
		return mapping.findForward("sucesso");
	}

}