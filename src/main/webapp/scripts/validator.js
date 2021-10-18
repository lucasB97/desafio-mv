function validator() {
	let name = frmCollaborator.contributorName.value
	let cpf = frmCollaborator.cpf.value
	let food = frmCollaborator.breakfastFood.value
	if (name === "") {
		alert('Preencha o campo Nome')
		frmContato.name.focus()
		return false
	} else if (cpf === "") {
		alert('Preencha o campo CPF')
		frmContato.cpf.focus()
		return false
	} else if (food === "") {
		alert('Preencha o campo Comida')
		frmContato.food.focus()
		return false
	} 
	 else {
		document.forms["frmCollaborator"].submit()
	}
}