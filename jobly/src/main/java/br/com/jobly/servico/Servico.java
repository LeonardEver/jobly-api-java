package br.com.jobly.servico;

import br.com.jobly.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "servico")
@Entity(name = "servico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String preco;
    private String duracao;
    private String status;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Servico(DadosCadastroServ dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.duracao = dados.duracao();
        this.categoria = dados.categoria();
        this.status = dados.status();
    }

    public void attDadosServ(DadosAttServ dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if(dados.duracao() != null) {
            this.duracao = dados.duracao();
        }
        if(dados.preco() != null) {
            this.preco = dados.preco();
        }
    }
}
