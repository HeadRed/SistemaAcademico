/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.exceptions.DAOException;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class ProfessorDAO {
    
    private Connection conexao;
    
    public ProfessorDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public Professor getProfessor(String loginProfessor) {
        Professor professor = null;
        try {
            String sql = "select nome from professor where loginUsuario=?";
            
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, loginProfessor);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                professor = new Professor();
                professor.setNome(rs.getString("nome"));
            }
            rs.close();
            stmt.close();            
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return professor;
    }
    
}
