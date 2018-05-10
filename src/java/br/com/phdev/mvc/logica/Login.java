/*
 * Copyright (C) 2018 Paulo Henrique Gonçalves Bacelar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.phdev.mvc.logica;

import com.br.phdev.jdbc.dao.LoginDAO;
import com.br.phdev.jdbc.modelo.Usuario;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class Login implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        /*
        String loginUsuario = request.getParameter("usuario");
        String loginSenha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setLoginUsuario(loginUsuario);
        usuario.setLoginSenha(loginSenha);
        
        Connection conexao = (Connection)request.getAttribute("conexao");
                
        new LoginDAO(conexao).autentica(usuario);
        */
        return "/WEB-INF/adiciona-aluno.jsp";
    }
    
}
