package com.example.demo.controller;


import com.example.demo.model.Cita;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
@RestController
@RequestMapping("/api")
public class CitaController {

    private final String[] citas = {
            "Su cita quedo programada para el dia:"

    };

    @GetMapping("/cita")
    public Cita generarCita() {
        int indiceAleatorio = new Random().nextInt(citas.length);
        String citaTexto = citas[indiceAleatorio];
        String fecha = generarFechaAleatoria();

        return new Cita(citaTexto + " - Fecha: " + fecha);
    }

    public String generarFechaAleatoria() {
        Random random = new Random();

        int year = 2023 + random.nextInt(2);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);

        return formatDate(year, month, day);
    }

    public String formatDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(year - 2000, month - 1, day);
        return sdf.format(date);
    }
}
