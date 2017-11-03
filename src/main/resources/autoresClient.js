$(function(){
   $(".js-carregar-autor").on('click', function () {
       $.ajax({
            url: "http://localhost:8080/autores",
            type: "get",
            headers: {"Authorization": "Basic bG9wZXM6czNuaDQ="},
            success: function (response) {
                desenhaTabela(response);
            }
        });
   })
});

function desenhaTabela(dados) {
    $(".js-corpo-tabela-autor tr").remove();
    for(var i=0; i < dados.length; i++) {
        desenhaLinha(dados[i]);
    }
}

function desenhaLinha(linha) {
    var linhaTabela = $("<tr/>");
    $(".js-corpo-tabela-autor").append(linhaTabela);
    linhaTabela.append("<td>" + linha.id + "</td>");
    linhaTabela.append("<td>" + linha.nome + "</td>");
    linhaTabela.append("<td>" + linha.nacionalidade + "</td>");
}