/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.controller;

import br.com.phdev.sistemaacademico.dao.TarefaDAO;
import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Tarefa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
@Controller
public class TarefasController {
    
    @RequestMapping("tarefas")
    public String tarefas(int idTurma, int idDisciplina, HttpSession session) {        
        session.setAttribute("idTurma", idTurma);
        session.setAttribute("idDisciplina", idDisciplina);                                   
        return "redirect:mostrarTarefas";
    }
    
    @RequestMapping("mostrarTarefas")
    public String mostrarTarefas(Model model, HttpSession session) {      
        int idTurma = (Integer)(session.getAttribute("idTurma"));
        int idDisciplina = (Integer)(session.getAttribute("idDisciplina"));
        List<Tarefa> tarefas = new TarefaDAO(new ConnectionFactory().getConnection()).get(idTurma, idDisciplina);
        model.addAttribute("tarefas", tarefas);
        return "tarefas/lista-tarefas";
    }      
    
    @RequestMapping("tarefa")
    public String mostraTarefa(int idTurma, int idDisciplina, Model model) {
        model.addAttribute("idTurma", idTurma);
        model.addAttribute("idDisciplina", idDisciplina);
        return "tarefas/tarefa";
    }
    
    
}
