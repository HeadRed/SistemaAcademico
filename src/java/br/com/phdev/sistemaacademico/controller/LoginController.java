/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.controller;

import br.com.phdev.sistemaacademico.dao.UsuarioDAO;
import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Administrador;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Professor;
import br.com.phdev.sistemaacademico.modelos.Usuario;
import java.sql.Connection;
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
    
    @RequestMapping("entrar")
    public String entrar() {
        return "login/form-login";
    }
    
    @RequestMapping("autenticar")
    public String autenticar(Usuario usuario, HttpSession session, Model model) {   
        if (usuario.getLoginNome().equals("teste@teste"))
            return "teste/teste";
        
        Connection conexao = new ConnectionFactory().getConnection();        
        Usuario novoUsuario = new UsuarioDAO(conexao).verificarExistencia(usuario);
        ConnectionFactory.disconnect(conexao);
        
        
        if (novoUsuario != null) {                                  
            if (novoUsuario instanceof Aluno) {                
                session.setAttribute("usuario", (Aluno)novoUsuario);
                return "redirect:homeAluno";
            } else if (novoUsuario instanceof Professor) {
                session.setAttribute("usuario", (Professor)novoUsuario);
                return "redirect:homeProfessor";
            } else if (novoUsuario instanceof Administrador) {
                session.setAttribute("usuario", (Administrador)novoUsuario);
                return "redirect:homeAdministrador";
            }
        }        
        model.addAttribute("erro", true);
        return "login/form-login";       
    }
    
}
