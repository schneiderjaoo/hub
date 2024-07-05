package com.room.hub.controller;

import com.room.hub.bean.ReservaDeSala;
import com.room.hub.bean.Salas;
import com.room.hub.bean.Clientes;
import com.room.hub.service.ReservaDeSalaService;
import com.room.hub.service.SalasService;
import com.room.hub.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaDeSalaController {

    @Autowired
    private ReservaDeSalaService reservaService;

    @Autowired
    private SalasService salasService;

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/criar")
    public String criarReservaForm(Model model) {
        model.addAttribute("salas", salasService.listarSalas());
        model.addAttribute("clientes", clientesService.listarClientes());
        model.addAttribute("reserva", new ReservaDeSala());
        return "criar_reserva";
    }

    @PostMapping("/criar")
    public String criarReservaSubmit(@RequestParam Long salaId,
                                     @RequestParam Long clienteId,
                                     @RequestParam String dataInicio,
                                     @RequestParam String dataFim,
                                     Model model) {
        Salas sala = salasService.encontrarPorId(salaId);
        Clientes cliente = clientesService.encontrarPorId(clienteId);

        if (sala == null || cliente == null) {
            model.addAttribute("error", "Sala ou cliente inválido.");
            return "criar_reserva";
        }

        LocalDate dataInicioLocalDate = LocalDate.parse(dataInicio);
        LocalDate dataFimLocalDate = LocalDate.parse(dataFim);

        ReservaDeSala reserva = new ReservaDeSala();
        reserva.criarReserva(cliente, sala, dataInicioLocalDate, dataFimLocalDate);
        reservaService.save(reserva);

        return "redirect:/reservas/listar";
    }

    @GetMapping("/listar")
    public String listarReservas(Model model) {
        List<ReservaDeSala> reservas = reservaService.findAll();
        model.addAttribute("reservas", reservas);
        return "listar_reservas";
    }
}
