/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.lib;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 *
 * @author - Raúl Granel Blasco - raul.granel@gmail.com
 */
public class UtilesBD {

    private static final String PROTOCOL = "jdbc:mysql";    // MySQL.
    private static final String HOST = "localhost";         // IP.
    private static final String PORT = "3306";              // MySQL.

    private static Properties cargarPropiedades(String fichero) {
        Properties p;
        try (FileReader fr = new FileReader(fichero)) {
            p = new Properties();
            p.load(fr);
        } catch (Exception e) {
            p = null;
        }
        return p;
    }

    public static Connection obtenerConexion() throws SQLException {

        final String FICHERO = "db.properties";

        Properties p = cargarPropiedades(FICHERO);

        String cadenaConexion = String.format("%s://%s:%s/%s?user=%s&password=%s",
                p.getProperty("protocol", PROTOCOL),
                p.getProperty("host", HOST),
                p.getProperty("port", PORT),
                p.getProperty("db"),
                p.getProperty("user"),
                p.getProperty("password")
        );
        return DriverManager.getConnection(cadenaConexion);
    }

    // Obtenemos una fecha SQL de la base de datos.
    public static String convertirSQLDate2String(java.sql.Date sqlDate) {

        // Obtenemos el tiempo en milisegundos Unix y lo almacenamos en una variable.
        long ms = sqlDate.getTime();

        // Instanciamos una fecha de java con los milisegundos de Unix.
        java.util.Date utilDate = new java.util.Date(ms);

        // Le damos el formato deseado a la variable.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Devolvemos la fecha java (utilDate) utilizando el formato establecido en (sdf).
        return sdf.format(utilDate);
    }

}
