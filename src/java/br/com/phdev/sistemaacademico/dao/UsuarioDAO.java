/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class UsuarioDAO extends BasicDAO{    

    public UsuarioDAO(Connection conexao) {
        super(conexao);        
    }

    public Usuario verificarExistencia(Usuario usuario) {        
        try {
            String sql = "SELECT * FROM usuario WHERE loginUsuario=?";

            PreparedStatement stmt = super.conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getLoginNome());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String tipo = rs.getString("tipoUsuario_fk");
                System.err.println(tipo);
                sql = "SELECT * FROM " + tipo + " WHERE loginUsuario=? AND loginSenha=?";
                stmt = super.conexao.prepareStatement(sql);
                stmt.setString(1, usuario.getLoginNome());
                stmt.setString(2, usuario.getLoginSenha());
                rs = stmt.executeQuery();
                if (rs.next()) {                    
                    if (tipo.equals("aluno")) {                        
                        String loginNome = usuario.getLoginNome();
                        String nome = rs.getString("nome");
                        int turma = rs.getInt("turma_fk");
                        rs.close();
                        stmt.close();
                        super.close();
                        return new Aluno(loginNome, nome, turma);
                    } else if (tipo.equals("professor")) {
                        
                    } else if (tipo.equals("administrador")) {
                        
                    }
                }
            }            
        } catch (SQLException e) {
            super.close();                
            throw new RuntimeException(e);
        }
        return null;
    }

}
