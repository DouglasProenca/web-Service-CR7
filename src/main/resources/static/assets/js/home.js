let dataAtual = new Date();

let dia = String(dataAtual.getDate()).padStart(2, '0');
let mes = String(dataAtual.getMonth() + 1).padStart(2, '0'); // Janeiro é 0
let ano = dataAtual.getFullYear();

document.getElementById("sintetico-data-final").value = `${ano}-${mes}-${dia}`;
document.getElementById("analitico-data-final").value = `${ano}-${mes}-${dia}`;