/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.modelos.Disciplina;
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
public class DisciplinaDAO extends BasicDAO {

    public DisciplinaDAO(Connection conexao) {
        super(conexao);
    }

    public List<Disciplina> getLista(Turma turma) {
        try {
            List<Disciplina> disciplinas = new ArrayList<>();
            String sql = "SELECT * FROM disciplina WHERE curso_fk=? AND semestre=?";

            PreparedStatement stmt = super.conexao.prepareStatement(sql);
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
                disciplinas.add(disciplina);
            }

            rs.close();
            stmt.close();
            super.close();
            return disciplinas;
        } catch (SQLException e) {
            super.close();
            throw new RuntimeException(e);
        }        
    }

}
