package com.example.toshiba.basededatos3.modelo.clases.java;


public class Producto {

    int Id;
    String Nombre,ApellidoP,ApellidoM,Correo ;


    public Producto(int id, String nombre, String apellidop,String apellidom, String correo) {

        Id = id;
        this.Nombre = nombre;
        ApellidoP=apellidop;
        ApellidoM=apellidom;
        Correo=correo;
    }


    public Producto() {
        Id = 0;
        this.Nombre = null;
        this.ApellidoP=null;
        this.ApellidoM=null;
        this.Correo=null;
    }


    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }


    public String getApellidoP() {
        return ApellidoP;
    }


    public void setApellidoP(String apellidop) {
        ApellidoP=apellidop;
    }


    public String getApellidoM() {
        return ApellidoM;
    }


    public void setApellidoM(String apellidom) {
        ApellidoM=apellidom;
    }
    public String getCorreo() {
        return Correo;
    }


    public void setCorreo(String correo) {
        Correo=correo;
    }



}
