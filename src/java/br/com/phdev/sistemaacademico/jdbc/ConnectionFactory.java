package br.com.phdev.sistemaacademico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://192.168.2.142:3306/sistema_academico";
            String usuario = "sistema_academico";
            String senha = "root";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }               
    
}
