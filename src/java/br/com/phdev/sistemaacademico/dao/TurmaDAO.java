/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Curso;
import br.com.phdev.sistemaacademico.modelos.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class TurmaDAO {
    
    private Connection conexao;

    public TurmaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Turma> getTurmas() {
        List<Turma> turmas = null;
        try {
            turmas = new ArrayList<>();
            
            String sql = "SELECT * FROM turma";

            PreparedStatement stmt = conexao.prepareStatement(sql);            

            ResultSet rs = stmt.executeQuery();
            
            List<Curso> cursos = new CursoDAO(new ConnectionFactory().getConnection()).getCursos();
            
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setIdTurma(rs.getInt("idTurma"));                
                int idCurso = rs.getInt("curso_fk");
                for (Curso curso : cursos) {
                    if (curso.getIdCurso() == idCurso)
                        turma.setCurso(curso.getNome());
                }
                turma.setSemestre(rs.getInt("semestre"));                
                turmas.add(turma);
            }
            rs.close();
            stmt.close();            
            return turmas;
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
    }

    public Turma getTurma(int idTurma) {
        Turma turma = null;
        try {
            String sql = "SELECT * FROM turma WHERE idTurma=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTurma);

            ResultSet rs = stmt.executeQuery();
            
            List<Curso> cursos = new CursoDAO(new ConnectionFactory().getConnection()).getCursos();

            turma = new Turma();
            if (rs.next()) {
                turma.setIdTurma(idTurma);
                turma.setSemestre(rs.getInt("semestre"));
                int idCurso = rs.getInt("curso_fk");                
                for (Curso curso : cursos) {
                    if (curso.getIdCurso() == idCurso)
                        turma.setCurso(curso.getNome());
                }
                rs.close();
                stmt.close();
                return turma;
            }
            return turma;
        } catch (SQLException e) {            
            throw new RuntimeException(e);
        }
    }

}
