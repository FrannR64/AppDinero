package com.AppDinero2.App.controller;

import com.AppDinero2.App.entity.Dinero;
import com.AppDinero2.App.entity.Gasto;
import com.AppDinero2.App.entity.Ingreso;
import com.AppDinero2.App.repository.DineroRepository;
import com.AppDinero2.App.repository.GastoRepository;
import com.AppDinero2.App.repository.IngresosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class GestionController {
    private static Integer cont = 0;
    @Autowired
    private DineroRepository dineroRepository;

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private IngresosRepository ingresosRepository;

    @GetMapping
    public String bienvenido(Model model) {
        Dinero dinero = dineroRepository.getReferenceById(1L);
        model.addAttribute("saldo", "$" + dinero.getSaldo());
        return "index";
    }


    @GetMapping("/verGastos")
    public String verGastos(Model model) {
        List<Gasto> gastos = gastoRepository.findAll();
        model.addAttribute("gastos", gastos);
        return "verGastos";
    }


    //----------------------------Ingresar dinero---------------------------------------------
    @GetMapping("/ingresarDinero")
    public String ingresarDinero(Model model) {
        model.addAttribute("atIngresar", new Ingreso());
        return "ingresarDinero";
    }

    @PostMapping("/ingresar")
    public String ingresarDinero(@ModelAttribute("atIngresar") Ingreso ingreso) {
        ingresosRepository.save(ingreso);
        Dinero dinero1 = dineroRepository.getReferenceById(1L);
        dinero1.setSaldo((int) (dinero1.getSaldo()+ingreso.getIngreso()));
        dineroRepository.save(dinero1);
        return "redirect:/verIngresos";
    }

    @GetMapping("/verIngresos")
    public String verIngresos(Model model) {
        List<Ingreso> ingresos = ingresosRepository.findAll();
        model.addAttribute("ingreso", ingresos);
        return "verIngresos";
    }


    //--------------------------extraerDinero--------------------------------
    @GetMapping("/agregarGastos")
    public String agregarGastos(Model model) {
        model.addAttribute("atGasto", new Gasto());
        return "agregarGastos";
    }


    @PostMapping("/extraer")
    public String extraerDinero(@ModelAttribute("atGasto") Gasto gasto) {
        Dinero dinero = dineroRepository.getReferenceById(1L);
        dinero.setSaldo(dinero.getSaldo() - gasto.getGasto());
        dineroRepository.save(dinero);
        gastoRepository.save(gasto);
        return "redirect:/verGastos";

    }


}
