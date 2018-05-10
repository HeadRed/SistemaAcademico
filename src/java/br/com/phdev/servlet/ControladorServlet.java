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
package br.com.phdev.servlet;

import br.com.phdev.mvc.logica.Logica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
@WebServlet("/sa")
public class ControladorServlet extends HttpServlet{
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String parametro = request.getParameter("l");
        String nomeClasse = "br.com.phdev.mvc.logica." + parametro;
        
        System.out.println("Nome da Classe: " + nomeClasse);
        
        try {
            Class classe = Class.forName(nomeClasse);
            
            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(request, response);
            
            System.out.println("Pagina: " + pagina);
            
            request.getRequestDispatcher(pagina).forward(request, response);
        } catch (Exception e) {
            System.out.println("A logica de negocios falhou");
            System.out.println(e.getMessage());
        }
        
    }
    
}
