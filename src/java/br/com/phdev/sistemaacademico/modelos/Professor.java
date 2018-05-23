/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.modelos;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class Professor extends Usuario{
    
    private String nome;
    
    public Professor() {
        
    }
    
    public Professor(String nome) {
        this.nome = nome;
    }
    
    public Professor(String loginNome, String nome) {
        super.setLoginNome(loginNome);
        this.nome = nome;        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }        
    
}
