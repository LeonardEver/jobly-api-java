package br.com.jobly.servico;

public record DadosCadastroServ(
        String nome,
        String descricao,
        String preco,
        String duracao,
        String status,

        Categoria categoria) {

}
