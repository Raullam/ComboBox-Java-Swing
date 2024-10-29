package spdvi.fitnesscasesnoves.dto;

import java.sql.Timestamp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rulox
 */
public class Intents {
    int id;
    int idUsuari;
    int idExercici;
    String Timestamp_Inici;
    String Timestamp_Fi;
    String videofile;
    

    public Intents(int id, int idUsuari, int idExercici, String Timestamp_Inici, String Timestamp_Fi, String videofile) {
        this.id = id;
        this.idUsuari = idUsuari;
        this.idExercici = idExercici;
        this.Timestamp_Inici = Timestamp_Inici;
        this.Timestamp_Fi = Timestamp_Fi;
        this.videofile = videofile;
    }

    public Intents(int id, int idUsuari, int idExercici, Timestamp timestamp_Inici, Timestamp timestamp_Fi, String videofile) {
        this.id = id;
        this.idUsuari = idUsuari;
        this.idExercici = idExercici;
        this.Timestamp_Inici = timestamp_Inici.toString();
        this.Timestamp_Fi = (timestamp_Fi!= null) ? timestamp_Fi.toString() : "No disponible";
        this.videofile = videofile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdExercici() {
        return idExercici;
    }

    public void setIdExercici(int idExercici) {
        this.idExercici = idExercici;
    }

    public String getTimestamp_Inici() {
        return Timestamp_Inici;
    }

    public void setTimestamp_Inici(String Timestamp_Inici) {
        this.Timestamp_Inici = Timestamp_Inici;
    }

    public String getTimestamp_Fi() {
        return Timestamp_Fi;
    }

    public void setTimestamp_Fi(String Timestamp_Fi) {
        this.Timestamp_Fi = Timestamp_Fi;
    }

    public String getVideofile() {
        return videofile;
    }

    public void setVideofile(String videofile) {
        this.videofile = videofile;
    }

    @Override
    public String toString() {
        return "Intents{" + "id=" + id + ", idUsuari=" + idUsuari + ", idExercici=" + idExercici + ", Timestamp_Inici=" + Timestamp_Inici + ", Timestamp_Fi=" + Timestamp_Fi + ", videofile=" + videofile + '}';
    }
    
    
}