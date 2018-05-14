/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.modelos.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class TurmaDAO extends BasicDAO {

    public TurmaDAO(Connection conexao) {
        super(conexao);
    }

    public Turma get(int idTurma) {
        Turma turma = null;
        try {
            String sql = "SELECT * FROM turma WHERE idTurma=?";

            PreparedStatement stmt = super.conexao.prepareStatement(sql);
            stmt.setInt(1, idTurma);

            ResultSet rs = stmt.executeQuery();

            turma = new Turma();
            if (rs.next()) {               
                turma.setIdTurma(idTurma);
                turma.setCurso(rs.getString("curso_fk"));
                turma.setSemestre(rs.getInt("semestre"));
                rs.close();
                stmt.close();
                super.close();
                return turma;
            }
            return turma;
        } catch (SQLException e) {
            super.close();
            throw new RuntimeException(e);
        }        
    }

}
