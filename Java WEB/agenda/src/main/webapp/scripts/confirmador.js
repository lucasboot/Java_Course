/**
 * Confirmador de exclusão de um contato
 */

function confirmar(idcon){
    let resposta = confirm("Confirma a exclusão deste contato ?")
    if (resposta){
        //alert(idcon)
        window.location.href = "delete?idcon="+idcon
    }
}