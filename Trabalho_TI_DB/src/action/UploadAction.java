package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import form.UploadForm;

public class UploadAction extends DispatchAction {

	
	public ActionForward upload(ActionMapping mapping, 
								ActionForm form, 
								HttpServletRequest request, 
								HttpServletResponse response) throws Exception {


        UploadForm uploadForm = (UploadForm)form;

		try {

	        FormFile formFile = uploadForm.getArquivo();
	
			String strFileName = formFile.getFileName();		
	
			byte dataFile[] = formFile.getFileData();
	
			File file = new File("C:/Temp/" + strFileName);
	
			OutputStream out = new FileOutputStream(file);
			out.write(dataFile);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("sucesso");
		return mapping.findForward("sucesso");
	}

}