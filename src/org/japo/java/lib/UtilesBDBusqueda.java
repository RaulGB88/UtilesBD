/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.lib;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author (c) Raúl Granel Blasco - raul.granel@gmail.com
 */
public class UtilesBDBusqueda {

    // Comprueba existencia en la Base de Datos una PRIMARY KEY tipo INT.
    public static int buscarIDEntero(int primaryKey, ResultSet rs, String nombreCampo) throws SQLException {

        int posicion = -1;            // No encontrado.
        boolean busquedaOK = true;      // Seguir busqueda.

        while (busquedaOK) {
            if (rs.next()) {
                if (primaryKey == rs.getInt(nombreCampo)) {
                    posicion = rs.getRow();         //Sí encontrado.
                    busquedaOK = false;
                } else {
                    busquedaOK = false;             // Parar la búsqueda.
                }
            }
        }
        return posicion;
    }

    // Comprueba existencia en la Base de Datos una PRIMARY KEY tipo INT.
    public static int buscarIDString(String primaryKey, ResultSet rs, String nombreCampo) throws SQLException {

        int posicion = -1;            // No encontrado.
        boolean busquedaOK = true;      // Seguir busqueda.

        while (busquedaOK) {
            if (rs.next()) {
                if (primaryKey.equals(rs.getString(nombreCampo))) {
                    posicion = rs.getRow();         //Sí encontrado.
                    busquedaOK = false;
                } else {
                    busquedaOK = false;             // Parar la búsqueda.
                }
            }
        }
        return posicion;
    }

}
