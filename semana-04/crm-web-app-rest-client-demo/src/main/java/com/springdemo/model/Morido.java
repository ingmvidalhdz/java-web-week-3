package com.springdemo.model;

public class Morido {

    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String fechaMoricion;
    private String horaMoricion;
    private String lugarMoricion;
    private String causaMoricion;
    
    public Morido(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaMoricion() {
        return fechaMoricion;
    }

    public void setFechaMoricion(String fechaMoricion) {
        this.fechaMoricion = fechaMoricion;
    }

    public String getHoraMoricion() {
        return horaMoricion;
    }

    public void setHoraMoricion(String horaMoricion) {
        this.horaMoricion = horaMoricion;
    }

    public String getLugarMoricion() {
        return lugarMoricion;
    }

    public void setLugarMoricion(String lugarMoricion) {
        this.lugarMoricion = lugarMoricion;
    }

    public String getCausaMoricion() {
        return causaMoricion;
    }

    public void setCausaMoricion(String causaMoricion) {
        this.causaMoricion = causaMoricion;
    }

    @Override
    public String toString() {
        return "Morido{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", fechaMoricion=" + fechaMoricion + ", horaMoricion=" + horaMoricion + ", lugarMoricion=" + lugarMoricion + ", causaMoricion=" + causaMoricion + '}';
    }


    
}
