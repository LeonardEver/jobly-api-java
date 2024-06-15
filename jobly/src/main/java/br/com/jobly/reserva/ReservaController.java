package br.com.jobly.reserva;

import br.com.jobly.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public void reservarServico(@RequestParam Long servicoId,
                                @RequestParam Long clienteId,
                                @RequestParam Long colaboradorId,
                                @RequestParam String data) {
        servicoService.reservarServico(servicoId, clienteId, colaboradorId, data);
    }
}
