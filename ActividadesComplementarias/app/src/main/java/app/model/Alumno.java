package app.model;

public class Alumno {

    private int claveAlumno;
    private String nombre;
    private String claveUsuario;
    private int semestre;
    private String carrera;

    public Alumno() {
    }

    public Alumno(int claveAlumno, String nombre, String claveUsuario, int semestre, String carrera) {
        this.claveAlumno = claveAlumno;
        this.nombre = nombre;
        this.claveUsuario = claveUsuario;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    public Alumno(int claveAlumno, String nombre, int semestre, String carrera) {
        this.claveAlumno = claveAlumno;
        this.nombre = nombre;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" + "claveAlumno=" + claveAlumno + ", nombre=" + nombre + ", claveUsuario=" + claveUsuario + ", semestre=" + semestre + ", carrera=" + carrera + '}';
    }


    public int getClaveAlumno() {
        return claveAlumno;
    }

    public void setClaveAlumno(int claveAlumno) {
        this.claveAlumno = claveAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}
