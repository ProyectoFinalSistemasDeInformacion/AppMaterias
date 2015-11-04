package com.example.toshiba.basededatos3.modelo.clases.java;

/**
 * Created by Toshiba on 24/10/2015.
 */
public class Productos {
    int Id;
    String Nombre, Descripcion;
    int Costo, Tarea, Proyecto, Asistencia, Examen;


    public Productos(int id,String Nombre,int Costo, String Descripcion, int Tarea, int Proyecto, int Examen, int Asistencia){

        Id=id;
        this.Nombre=Nombre;
        this.Costo=Costo;
        this.Descripcion=Descripcion;
        this.Tarea=Tarea;
        this.Proyecto=Proyecto;
        this.Examen=Examen;
        this.Asistencia=Asistencia;
    }


    public Productos(){

        Id=0;
        this.Nombre="";
        this.Costo=0;
        this.Descripcion="";
        this.Tarea=0;
        this.Proyecto=0;
        this.Examen=0;
        this.Asistencia=0;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        Id=id;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre){
        this.Nombre=nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion){
       this.Descripcion=descripcion;
    }

    public int getCosto(){
        return Costo;
    }

    public void setCosto(int costo){
        this.Costo=costo;
    }

    public int getTarea(){
        return Tarea;
    }

    public void setTarea(int tarea){
        Tarea=tarea;
    }

    public int getProyecto(){
        return Proyecto;
    }

    public void setProyecto(int proyecto){
        Proyecto=proyecto;
    }

    public int getExamen(){
        return Examen;
    }

    public void setExamen(int examen){
        Examen=examen;
    }

    public int getAsistencia(){
        return Asistencia;
    }

    public void setAsistencia(int asistencia){
        Asistencia=asistencia;
    }

}
