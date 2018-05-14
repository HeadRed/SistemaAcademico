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
public class Aluno extends Usuario {
    
    private String nome;
    private int turma;
    
    public Aluno(String loginNome, String nome, int turma) {
        super.setLoginNome(loginNome);
        this.nome = nome;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }        
    
}
