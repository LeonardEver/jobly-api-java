package br.com.jobly.services;

import br.com.jobly.cliente.Cliente;
import br.com.jobly.cliente.ClienteRepository;
import br.com.jobly.colaborador.Colaborador;
import br.com.jobly.colaborador.ColaboradorRepository;
import br.com.jobly.reserva.Reserva;
import br.com.jobly.reserva.ReservaRepository;
import br.com.jobly.servico.Servico;
import br.com.jobly.servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public void reservarServico(Long servicoId, Long clienteId, Long colaboradorId, String data) {
        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        LocalDateTime dataReserva = LocalDateTime.parse(data);
        Reserva reserva = new Reserva(servico, cliente, colaborador, dataReserva);

        reservaRepository.save(reserva);
        System.out.println("Serviço reservado com sucesso!");
    }
}
