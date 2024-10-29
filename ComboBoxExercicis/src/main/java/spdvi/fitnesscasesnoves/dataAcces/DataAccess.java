/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.fitnesscasesnoves.dataAcces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spdvi.fitnesscasesnoves.dto.Exercicis;
import spdvi.fitnesscasesnoves.dto.Intents;
import spdvi.fitnesscasesnoves.dto.Usuari;

/**
 *
 * @author Raül Lama
 */
// DAO Data access object
public class DataAccess {
    private Connection getConnection() {
        Connection connection = null;
        String connectionString = "jdbc:sqlserver://localhost;database=simulapdb;trustServerCertificate=true;user=sa;password=1234;";
        
        //despues de hacer focus que se haga el update
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public ArrayList<Exercicis> getEjercicios() {
    ArrayList<Exercicis> nombresEjercicios = new ArrayList<>(); // Lista para almacenar los nombres de los ejercicios
    String sql = "SELECT * FROM Exercicis";
    Connection connection = getConnection(); // Obtener la conexión a la base de datos
    try {
        PreparedStatement selectStatement = connection.prepareStatement(sql); // Preparar la consulta
        ResultSet resultSet = selectStatement.executeQuery(); // Ejecutar la consulta

        // Iterar sobre los resultados y agregar los nombres de los ejercicios a la lista
        while (resultSet.next()) {
            Exercicis e = new Exercicis();
            e.setId(resultSet.getInt("Id")); // Suposant que l'Id és un enter
            e.setNomExercici(resultSet.getString("NomExercici")); // Obtenir el nom de l'exercici
            e.setDescripcio(resultSet.getString("Descripcio")); // Obtenir la descripció de l'exercici
         
            
            nombresEjercicios.add(e); 
        }
    } catch (SQLException ex) {
        Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (connection != null) connection.close(); // Cerrar la conexión después de usarla
        } catch (SQLException e) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return nombresEjercicios;
}

    
    public ArrayList<Intents> getIntentsByExerciciId(int exerciciId) {
    ArrayList<Intents> intents = new ArrayList<>();
    String sql = "SELECT [Id], [IdUsuari], [IdExercici], [Timestamp_Inici], [Timestamp_Fi], [Videofile] FROM [simulapdb].[dbo].[Intents] WHERE [IdExercici] = ?"; // Consulta SQL

    Connection connection = null; // Inicialitzar la connexió
    try {
        connection = getConnection(); // Obtenir la connexió a la base de dades
        PreparedStatement preparedStatement = connection.prepareStatement(sql); // Preparar la consulta
        preparedStatement.setInt(1, exerciciId); // Establir el valor de l'ID de l'exercici

        ResultSet resultSet = preparedStatement.executeQuery(); // Executar la consulta

        // Iterar sobre els resultats i afegir els intents a la llista
        while (resultSet.next()) {
            int id = resultSet.getInt("Id"); // Obtenir ID de l'intent
            int idUsuari = resultSet.getInt("IdUsuari"); // Obtenir ID de l'usuari
            int idExercici = resultSet.getInt("IdExercici"); // Obtenir ID de l'exercici
            Timestamp timestampInici = resultSet.getTimestamp("Timestamp_Inici"); // Obtenir timestamp d'inici
            Timestamp timestampFi = resultSet.getTimestamp("Timestamp_Fi"); // Obtenir timestamp de fi
            String videofile = resultSet.getString("Videofile"); // Obtenir el nom del fitxer de vídeo
            
            // Afegir l'intent a la llista
            intents.add(new Intents(id, idUsuari, idExercici, timestampInici, timestampFi, videofile));
        }
    } catch (SQLException ex) {
        Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Tancar la connexió si no és null
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    return intents; // Retornar la llista d'intents
}
   
}

