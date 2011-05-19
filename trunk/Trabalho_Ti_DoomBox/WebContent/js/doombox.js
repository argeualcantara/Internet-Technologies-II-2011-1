function compararSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("check").value;
	var obj = document.getElementById("seq");

	if (senha1 == senha2) {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	} else {
		obj.setAttribute("style", "color: red; visibility:visible;");
	}

	if (senha2 == "") {
		obj.setAttribute("style", "color: red; visibility:hidden;");
	}

}

function checarSenha() {

	var senha1 = document.getElementById("senha").value;
	var senha2 = document.getElementById("check").value;
	var valido;

	if (senha1 == senha2) {
		valido=true;
	} else {
		valido=false;
		alert('As senhas devem ser iguais.');
	}
	return valido;

}

function excluir(id){
	var apagar=confirm('Deseja excluir o arquivo/pasta?\nSe for uma pasta, todos os seus arquivos serão apagados');
	if(apagar){
		alert('apagou');
	}else{
		alert('não apagou');
	}
}
