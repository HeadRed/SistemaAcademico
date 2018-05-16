/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.controller;

import br.com.phdev.sistemaacademico.dao.AlunoDAO;
import br.com.phdev.sistemaacademico.dao.CursoDAO;
import br.com.phdev.sistemaacademico.dao.TurmaDAO;
import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Curso;
import br.com.phdev.sistemaacademico.modelos.Turma;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
@Controller
public class AdminController {
    
    @RequestMapping("AdicionarAluno")
    public String formAluno(Model model) {        
        List<Curso> cursos = new CursoDAO(new ConnectionFactory().getConnection()).getCursos();
        List<Turma> turmas = new TurmaDAO(new ConnectionFactory().getConnection()).getTurmas();
        model.addAttribute("turmas", turmas);
        model.addAttribute("cursos", cursos);
        return "principal/admin/form-adicionar-aluno";
    }        
    
    @RequestMapping("cadastrarAluno")
    public String cadastrarAluno(Aluno aluno) {
        System.out.println(aluno.getLoginNome());
        new AlunoDAO(new ConnectionFactory().getConnection()).adiciona(aluno);
        return "redirect:homeAdministrador";
    }
    
}
