/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.controller;

import br.com.phdev.sistemaacademico.dao.UsuarioDAO;
import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
@Controller
public class LoginController {
    
    @RequestMapping("menuEntrar")
    public String login() {
        return "redirect:entrar";
    }
    
    @RequestMapping
    public String entrar() {
        return "login/form";
    }
    
    @RequestMapping("autenticar")
    public String autenticar(Usuario usuario, HttpSession session) {   
        UsuarioDAO dao = new UsuarioDAO(new ConnectionFactory().getConnection());
        Usuario novoUsuario = dao.verificarExistencia(usuario);
        if (novoUsuario != null) {                        
            if (novoUsuario instanceof Aluno) {                      
                //request.setAttribute("aluno", (Aluno)novoUsuario);
                //model.addAttribute("aluno", (Aluno)novoUsuario);
                session.setAttribute("aluno", (Aluno)novoUsuario);
                return "redirect:principal";
            }
        }
        return "redirect:entrar";
    }
    
}
