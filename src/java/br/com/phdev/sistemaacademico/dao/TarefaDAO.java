/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.phdev.sistemaacademico.dao;

import br.com.phdev.sistemaacademico.modelos.Tarefa;
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
public class TarefaDAO extends BasicDAO{        

    public TarefaDAO(Connection conexao) {
        super(conexao);
    }
    
    public List<Tarefa> get(int idTurma, int idDisciplina) {
        List<Tarefa> tarefas = new ArrayList<>();
        try {            
            
            String sql = "SELECT nome, concluida FROM tarefa WHERE turma_fk=? AND disciplina_fk=?";
            
            PreparedStatement stmt = super.conexao.prepareStatement(sql);
            stmt.setInt(1, idTurma);
            stmt.setInt(2, idDisciplina);
            
            ResultSet rs = stmt.executeQuery();
                        
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setNome(rs.getString("nome"));
                tarefa.setConcluida(rs.getBoolean("concluida"));
                tarefas.add(tarefa);
            }
            
            rs.close();
            stmt.close();
            super.close();
            return tarefas;            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        
    }
    
}
