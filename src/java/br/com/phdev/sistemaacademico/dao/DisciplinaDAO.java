/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.exceptions.DAOException;
import br.com.phdev.sistemaacademico.jdbc.ConnectionFactory;
import br.com.phdev.sistemaacademico.modelos.Disciplina;
import br.com.phdev.sistemaacademico.modelos.Professor;
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
public class DisciplinaDAO {
    
    private Connection conexao;

    public DisciplinaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Disciplina> getLista(Turma turma) {
        try {
            List<Disciplina> disciplinas = new ArrayList<>();
            String sql = "SELECT * FROM disciplina WHERE curso_fk=? AND semestre=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, turma.getCurso());
            stmt.setInt(2, turma.getSemestre());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(rs.getInt("idDisciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCargaHoraria(rs.getInt("cargaHoraria"));
                disciplina.setCurso(rs.getString("curso_fk"));
                disciplina.setSemestre(turma.getSemestre());
                String userProfessor = rs.getString("professor_fk");
                
                Connection subCon = new ConnectionFactory().getConnection();
                Professor professor = new ProfessorDAO(subCon).getProfessor(userProfessor);
                disciplina.setProfessor(professor.getNome());
                ConnectionFactory.disconnect(subCon);
                
                disciplinas.add(disciplina);
            }

            rs.close();
            stmt.close();            
            return disciplinas;
        } catch (SQLException e) {            
            throw new DAOException(e);
        }
    }
    
    public List<Disciplina> getDisciplinas(Integer idCurso, Professor professor) {
        try {
            List<Disciplina> disciplinas = new ArrayList<>();
            String sql = "SELECT * FROM disciplina WHERE curso_fk=? and professor_fk=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCurso);            
            stmt.setString(2, professor.getLoginNome());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(rs.getInt("idDisciplina"));
                disciplina.setNome(rs.getString("nome"));                
                disciplina.setCurso(rs.getString("curso_fk"));                
                disciplinas.add(disciplina);
            }

            rs.close();
            stmt.close();            
            return disciplinas;
        } catch (SQLException e) {            
            throw new DAOException(e);
        }
    }

    public List<Integer> getIdDisciplinas(String key) {
        List<Integer> disciplinas;
        try {
            disciplinas = new ArrayList<>();

            String sql = "SELECT * FROM disciplina WHERE professor_fk=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, key);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idDisciplina = rs.getInt("idDisciplina");
                disciplinas.add(idDisciplina);
            }

            rs.close();
            stmt.close();            
        } catch (SQLException e) {            
            throw new DAOException(e);
        }
        return disciplinas;
    }
    
    public List<Integer> getIdDisciplinas(int idCurso) {
        List<Integer> disciplinas;
        try {
            disciplinas = new ArrayList<>();

            String sql = "SELECT * FROM disciplina WHERE curso_fk=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCurso);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idDisciplina = rs.getInt("disciplina_fk");
                disciplinas.add(idDisciplina);
            }

            rs.close();
            stmt.close();           
        } catch (SQLException e) {            
            throw new DAOException(e);
        }
        return disciplinas;
    }

}
