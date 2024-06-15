package br.com.jobly.reserva;

import br.com.jobly.cliente.Cliente;
import br.com.jobly.colaborador.Colaborador;
import br.com.jobly.servico.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "reservas")
@Entity(name = "reservas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Servico servico;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Colaborador colaborador;

    private LocalDateTime data;

    public Reserva(Servico servico, Cliente cliente, Colaborador colaborador, LocalDateTime data) {
        this.servico = servico;
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.data = data;
    }
}
