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
    public String tarefas(int idTurma, int idDisciplina, Model model, HttpServletRequest request) {
        List<Tarefa> tarefas = new TarefaDAO(new ConnectionFactory().getConnection()).get(idTurma, idDisciplina);
        model.addAttribute("tarefas", tarefas);        
        return "tarefas/lista-tarefas";
    }
    
}
