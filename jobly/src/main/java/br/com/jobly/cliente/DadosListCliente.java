package br.com.jobly.cliente;

import br.com.jobly.endereco.Endereco;

public record DadosListCliente(Long id, String nome, String telefone, String nascimento, String email, Endereco endereco, String cpf) {

    public DadosListCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getNascimento(), cliente.getEndereco(), cliente.getCpf());
    }
}
