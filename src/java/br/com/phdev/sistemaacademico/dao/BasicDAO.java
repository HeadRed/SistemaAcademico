/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class BasicDAO {
    
    protected Connection conexao;        
    
    public BasicDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void close() {
        try {
            if (!this.conexao.isClosed())
                this.conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
