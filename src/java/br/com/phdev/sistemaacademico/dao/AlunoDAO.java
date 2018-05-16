/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.exceptions.DAOException;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class AlunoDAO extends BasicDAO{        
    
    public AlunoDAO(Connection conexao) {
        super(conexao);
    }
    
    public void adiciona(Aluno aluno) {
        try {
            String sql = "insert into aluno values (?,?,?,?)";
            
            PreparedStatement stmt = super.conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getLoginNome());
            stmt.setString(2, aluno.getLoginSenha());
            stmt.setString(3, aluno.getNome());
            stmt.setInt(4, aluno.getTurma());
            
            stmt.execute();
            
            stmt.close();
            super.close();            
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
}
