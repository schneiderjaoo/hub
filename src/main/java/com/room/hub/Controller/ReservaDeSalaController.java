package com.room.hub.controller;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.ReservaDeSala;
import com.room.hub.bean.Salas;
import com.room.hub.service.ClientesService;
import com.room.hub.service.ReservaDeSalaService;
import com.room.hub.service.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservas")
public class ReservaDeSalaController {

    @Autowired
    private ReservaDeSalaService reservaService;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private SalasService salasService;

    @GetMapping("/listar")
    public String listarReservas(Model model) {
        List<ReservaDeSala> reservas = reservaService.findAll();
        model.addAttribute("reservas", reservas);
        return "listarReservas";
    }

    @GetMapping("/criar")
    public String mostrarFormularioCriarReserva(Model model) {
        List<Clientes> clientes = clientesService.findAll();
        List<Salas> salas = salasService.listarSalas(); // Use listarSalas() em vez de findAll()
        model.addAttribute("clientes", clientes);
        model.addAttribute("salas", salas);
        model.addAttribute("reserva", new ReservaDeSala());
        return "formReserva";
    }

    @PostMapping("/criar")
    public String criarReserva(@ModelAttribute ReservaDeSala reserva) {
        reserva.criarReserva(reserva.getCliente(), reserva.getSala(), reserva.getDataInicio(), reserva.getDataFim());
        reservaService.save(reserva);
        return "redirect:/reservas/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarReserva(@PathVariable Long id, Model model) {
        Optional<ReservaDeSala> optionalReserva = reservaService.findById(id);
        if (optionalReserva.isPresent()) {
            ReservaDeSala reserva = optionalReserva.get();
            List<Clientes> clientes = clientesService.findAll();
            List<Salas> salas = salasService.listarSalas(); // Use listarSalas() em vez de findAll()
            model.addAttribute("clientes", clientes);
            model.addAttribute("salas", salas);
            model.addAttribute("reserva", reserva);
            model.addAttribute("editando", true);
            return "formReserva";
        } else {
            return "redirect:/reservas/listar";
        }
    }

    @PostMapping("/editar/{id}")
    public String editarReserva(@ModelAttribute ReservaDeSala reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas/listar";
    }

    @GetMapping("/cancelar/{id}")
    public String cancelarReserva(@PathVariable Long id) {
        Optional<ReservaDeSala> optionalReserva = reservaService.findById(id);
        if (optionalReserva.isPresent()) {
            ReservaDeSala reserva = optionalReserva.get();
            reserva.cancelarReserva("Cancelada pelo usuário", LocalDate.now());
            reservaService.save(reserva);
        }
        return "redirect:/reservas/listar";
    }
}
