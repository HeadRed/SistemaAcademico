/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
@Controller
public class IndexController {
    
    @RequestMapping(value = {"", "index"})
    public String indexG() {
        return "redirect:principal";
    }
    
    @RequestMapping("principal")
    public String principal() {
        return "index";
    }
    
}
