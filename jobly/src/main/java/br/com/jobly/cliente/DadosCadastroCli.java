package br.com.jobly.cliente;

import br.com.jobly.endereco.DadosEndereco;

public record DadosCadastroCli(
        String nome,
        String email,
        String cpf,
        String telefone,
        String nascimento,
        DadosEndereco endereco
) {
}
