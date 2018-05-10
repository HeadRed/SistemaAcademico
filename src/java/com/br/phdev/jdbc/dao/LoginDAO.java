/*
 * Copyright (C) 2018 Paulo Henrique Gonçalves Bacelar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.br.phdev.jdbc.dao;

import br.com.phdev.exceptions.DAOException;
import com.br.phdev.jdbc.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paulo Henrique Gonçalves Bacelar
 */
public class LoginDAO {

    private Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    public void autentica(Usuario usuario) {
        try {
            String sql = "SELECT FROM login WHERE loginUsuario=?";
            PreparedStatement stmt = this.connection.prepareCall(sql);
            stmt.setString(1, usuario.getLoginUsuario());
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs != null) {
                System.out.println("EXISTE");
            }
            
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

}
