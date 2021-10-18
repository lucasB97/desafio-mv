function confirmDeletion(id) {
	let response = confirm("Confirma a exclusão deste colaborador?")
	if (response === true) {
		window.location.href = "delete?id=" + id
	}
}