/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.exceptions.DAOException;
import br.com.phdev.sistemaacademico.modelos.Curso;
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
public class CursoDAO {
    
    private Connection conexao;

    public CursoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Curso getCurso(int idCurso) {
        Curso curso = null;
        try {
            String sql = "SELECT nome FROM curso WHERE idCurso=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCurso);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                curso = new Curso();
                curso.setIdCurso(idCurso);
                curso.setNome(rs.getString("nome"));
            }
            rs.close();
            stmt.close();            
        } catch (SQLException e) {            
            throw new DAOException(e);
        }
        return curso;
    }

    public List<Curso> getCursos() {
        List<Curso> cursos = null;
        try {
            cursos = new ArrayList<>();

            String sql = "select * from curso";

            PreparedStatement stmt = conexao.prepareStatement(sql);            

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
            }

            rs.close();
            stmt.close();           

        } catch (SQLException e) {           
            throw new DAOException(e);
        }
        return cursos;
    }

    public List<Curso> getCursos(List<Integer> idCursos) {
        List<Curso> cursos = null;
        try {
            cursos = new ArrayList<>();

            String sql = "select * from curso where " + formatSQL("idCurso=?", idCursos);

            PreparedStatement stmt = conexao.prepareStatement(sql);
            for (int i = 0; i < idCursos.size(); i++) {
                stmt.setInt(i + 1, idCursos.get(i));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
            }

            rs.close();
            stmt.close();            

        } catch (SQLException e) {            
            throw new DAOException(e);
        }
        return cursos;
    }

    public List<Curso> getCursosFromDisciplinas(List<Integer> idDisciplinas) {
        List<Integer> idCursos;
        try {
            idCursos = new ArrayList<>();
            String sql = "SELECT curso_fk from disciplina WHERE " + formatSQL("idDisciplina=?", idDisciplinas);

            PreparedStatement stmt = conexao.prepareStatement(sql);
            for (int i = 0; i < idDisciplinas.size(); i++) {
                stmt.setInt(i + 1, idDisciplinas.get(i));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                idCursos.add(rs.getInt("curso_fk"));
            }

            rs.close();
            stmt.close();

            return getCursos(idCursos);

        } catch (SQLException e) {            
            throw new DAOException(e);
        }
    }

    private String formatSQL(String key, List<Integer> idCursos) {
        String objeto = key;
        String SQL = key;

        for (int i = 0; i < idCursos.size() - 1; i++) {
            SQL += " or " + objeto;
        }
        return SQL;
    }

}
