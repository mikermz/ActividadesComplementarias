package app.persistense;

public class ActividadCompDAOJDB {
    public static  final String CAMPO_CLAVEACTIVIDAD = "clave_Actividad";
    public static  final String CAMPO_CLAVEALUMNO = "clave_alumno";
    public static  final String CAMPO_CLAVEDOCENTE = "clave_docente";
    public static  final String CAMPO_NOMBRE = "nombre";
    public static  final String CAMPO_TIPO = "tipo";
    public static  final String CAMPO_FECHAREALIZACION = "fecha_realizacion";
    public static  final String CAMPO_NOMBREALUMNO = "nombre_alumno";
    public static  final String CAMPO_NOMBREDOCENTE = "nombre_docente";
    public static  final String CAMPO_SEMESTRE = "semestre";
    public static  final String CAMPO_CARRERA = "carrera";
    public static  final String CREATE_TABLA_ACTIVIDAD = "CREATE TABLE ACTIVIDADES"
            + " (" + CAMPO_CLAVEACTIVIDAD + " INTEGER, "
            + CAMPO_CLAVEALUMNO + " INTEGER, "
            + CAMPO_CLAVEDOCENTE + " INTEGER, "
            + CAMPO_NOMBRE + " TEXT, "
            + CAMPO_TIPO + " TEXT, "
            + CAMPO_FECHAREALIZACION + " TEXT, "
            + CAMPO_NOMBREALUMNO + " TEXT, "
            + CAMPO_NOMBREDOCENTE + " TEXT, "
            + CAMPO_SEMESTRE + " INTEGER, "
            + CAMPO_CARRERA + " TEXT)";
}
