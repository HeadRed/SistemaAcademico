/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.controller;

import br.com.phdev.sistemaacademico.dao.CursoDAO;
import br.com.phdev.sistemaacademico.dao.DisciplinaDAO;
import br.com.phdev.sistemaacademico.dao.TurmaDAO;
import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Curso;
import br.com.phdev.sistemaacademico.modelos.Disciplina;
import br.com.phdev.sistemaacademico.modelos.Path;
import br.com.phdev.sistemaacademico.modelos.Professor;
import br.com.phdev.sistemaacademico.modelos.Turma;
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
public class MenuController {
    
    @RequestMapping("principalAluno")
    public String principalAluno(Model model) {
        return "redirect:principal";
    }
    
    @RequestMapping("homeAluno")
    public String homeAluno(HttpSession session, Model model) {
        Aluno aluno = (Aluno)session.getAttribute("aluno");               
        Turma turma = new TurmaDAO(new ConnectionFactory().getConnection()).get(aluno.getTurma());     
        List<Disciplina> lista = new DisciplinaDAO(new ConnectionFactory().getConnection()).getLista(turma);
        model.addAttribute("turma", turma);
        model.addAttribute("aluno", aluno);
        model.addAttribute("disciplinas", lista);
        model.addAttribute("path", new Path("principal"));
        return "principal/home-aluno";
    }
    
    @RequestMapping("homeProfessor")
    public String homeProfessor(HttpSession session, Model model) {
        Professor professor = (Professor)session.getAttribute("professor");        
        List<Integer> idDisciplinas = new DisciplinaDAO(new ConnectionFactory().getConnection()).getIdDisciplinas(professor.getLoginNome());
        List<Curso> cursos = new CursoDAO(new ConnectionFactory().getConnection()).getCursosFromDisciplinas(idDisciplinas);                
        model.addAttribute("cursos", cursos);
        model.addAttribute("nome", professor.getNome());
        return "principal/home-professor";
    }
    
    @RequestMapping("mostrarDisciplinas")
    public String mostrarDisciplinas(int curso, Model model, HttpSession session) {
        Professor professor = (Professor)session.getAttribute("professor");
        List<Disciplina> disciplinas = new DisciplinaDAO(new ConnectionFactory().getConnection()).getDisciplinas(curso, professor);                                
        model.addAttribute("disciplinas", disciplinas);
        return "principal/professor/lista-disciplinas";
    }
    
}
