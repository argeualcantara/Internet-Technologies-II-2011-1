

function excluir(id){
	var apagar=confirm('Deseja excluir o arquivo/pasta?\nSe for uma pasta, todos os seus arquivos ser�o apagados');
	if(apagar){
		alert('apagou');
	}else{
		alert('n�o apagou');
	}
}

function radioDiv(){
	var divArq=document.getElementById('arquivoDiv');
	var divDir=document.getElementById('diretorioDiv');
	var radio=document.getElementById('radio');
	if(radio.checked==true){
		divArq.setAttribute("style", 'border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #FFFFFF; position:absolute; left:100px; top:390px; visibility: visible;');
		divDir.setAttribute("style", 'position:absolute; left:100px; top:350px; visibility: hidden;');
	}else{
		divDir.setAttribute("style", 'border: ridge; border-color: #aba9a6; border-width: 5px; background-color: #FFFFFF; position:absolute; left:100px; top:390px; visibility: visible;');
		divArq.setAttribute("style", 'position:absolute; left:100px; top:350px; visibility: hidden;');
	}
}