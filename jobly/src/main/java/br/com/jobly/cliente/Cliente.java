package br.com.jobly.cliente;

import br.com.jobly.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;

    private String nascimento;

    private String telefone;
    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCli dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.nascimento = dados.nascimento();
    }

    public void attDadosCli(DadosAttCliente dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.endereco() != null) {
            this.endereco.attDados(dados.endereco());
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.nascimento() != null) {
            this.nascimento = dados.nascimento();
        }
    }
}
