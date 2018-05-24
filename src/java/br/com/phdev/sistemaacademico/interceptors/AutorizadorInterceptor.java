/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.endsWith("entrar") || uri.contains("resources") || uri.endsWith("autenticar")
                || uri.endsWith("principal") || uri.endsWith("index")) {                       
            return true;            
        }
        if (request.getSession().getAttribute("usuario") != null) {
            return true;
        }
        response.sendRedirect("menuEntrar");
        return false;
    }
    
}
