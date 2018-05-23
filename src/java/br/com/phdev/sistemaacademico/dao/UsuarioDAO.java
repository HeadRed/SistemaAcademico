/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.modelos.Administrador;
import br.com.phdev.sistemaacademico.modelos.Aluno;
import br.com.phdev.sistemaacademico.modelos.Professor;
import br.com.phdev.sistemaacademico.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class UsuarioDAO {
    
    private Connection conexao;

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Usuario verificarExistencia(Usuario usuario) {
        try {                                               
            String tipo = getTipoUsuario(usuario.getLoginNome());
            if (tipo == null)
                return null;
            String sql = "SELECT * FROM " + tipo + " WHERE loginUsuario=? AND loginSenha=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getLoginNome());
            stmt.setString(2, usuario.getLoginSenha());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (tipo.equals("aluno")) {
                    String loginNome = usuario.getLoginNome();
                    String nome = rs.getString("nome");
                    int turma = rs.getInt("turma_fk");
                    rs.close();
                    stmt.close();                    
                    return new Aluno(loginNome, nome, turma);
                } else if (tipo.equals("professor")) {
                    String loginNome = usuario.getLoginNome();
                    String nome = rs.getString("nome");
                    rs.close();
                    stmt.close();                    
                    return new Professor(loginNome, nome);
                } else if (tipo.equals("administrador")) {
                    String loginNome = usuario.getLoginNome();
                    String nome = rs.getString("nome");
                    rs.close();
                    stmt.close();                    
                    return new Administrador(loginNome, nome);
                }
            }
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
        return null;
    }

    private String getTipoUsuario(String loginNome) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < loginNome.length(); i++) {
            if (loginNome.charAt(i) == '@') {
                for (int j = i + 1; j < loginNome.length(); j++) {
                    buffer.append(loginNome.charAt(j));
                }
                String tipo = buffer.toString();
                if (tipo.equals("aluno")
                        || tipo.equals("professor")
                        || tipo.equals("administrador")) {
                    return tipo;
                }
                return null;
            }
        }
        return null;
    }

}
