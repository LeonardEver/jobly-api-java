package br.com.jobly.servico;

public record DadosAttServ(
        Long id,
        String nome,
        String descricao,
        String preco,
        String duracao,

        String status
) {
}
