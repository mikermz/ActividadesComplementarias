package app.persistense;

import app.model.Alumno;

public class AlumnoDAOJDB {
    public static  final String CAMPO_CLAVEALUMNO = "clave";
    public static  final String CAMPO_NOMBRE = "nonbre";
    public static  final String CAMPO_CLAVEUSUARIO = "clave_usuario";
    public static  final String CAMPO_SEMESTRE = "semestre";
    public static  final String CAMPO_CARRERA = "carrera";
    public static  final String CREATE_TABLA_ALUMNO = "CREATE TABLE ALUMNOS"
            + " (" + CAMPO_CLAVEALUMNO + " INTEGER, "
            + CAMPO_NOMBRE + " TEXT, "
            + CAMPO_CLAVEUSUARIO + " TEXT, "
            + CAMPO_SEMESTRE + " INTEGER, "
            + CAMPO_CARRERA + " TEXT)";

    public Alumno getOne(){

        return null;
    }
}
