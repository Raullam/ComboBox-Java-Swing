/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spdvi.fitnesscasesnoves.dto;

/**
 *
 * @author Rulox
 */
public class Exercicis {
    int id;
    String nomExercici;
    String descripcio;

    public Exercicis(int id, String nomExercici, String descripcio) {
        this.id = id;
        this.nomExercici = nomExercici;
        this.descripcio = descripcio;
    }

    public Exercicis() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomExercici() {
        return nomExercici;
    }

    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Exercicis{" + "id=" + id + ", nomExercici=" + nomExercici + ", descripcio=" + descripcio + '}';
    }
    
    
    
}
