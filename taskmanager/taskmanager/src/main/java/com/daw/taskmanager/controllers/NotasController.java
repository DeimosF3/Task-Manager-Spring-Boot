/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.taskmanager.controllers;

import com.daw.taskmanager.models.Nota;
import com.daw.taskmanager.services.notasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Rodrigo RL
 */
@Controller
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private notasRepository repo;
    
    @GetMapping({"", "/"})
    public String showNotasList(Model model){
//        List<Nota> notas = repo.findAll(Sort.by(Sort.Direction.DESC,"id")); ------ Utilizar esta línea para ordenar la lista en orden descendente
        List<Nota> notas = repo.findAll();
        model.addAttribute("notas",notas);
        return "notas/index";
    }
}