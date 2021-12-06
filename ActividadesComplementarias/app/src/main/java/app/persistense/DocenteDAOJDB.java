package app.persistense;

public class DocenteDAOJDB {
    public static  final String CAMPO_CLAVEDOCENTE = "clave_docente";
    public static  final String CAMPO_NOMBRE = "nombre";
    public static  final String CAMPO_CLAVEUSUARIO = "clave_usuario";
    public static  final String CREATE_TABLA_DOCENTE = "CREATE TABLE DOCENTES"
            + " (" + CAMPO_CLAVEDOCENTE + " INTEGER, "
            + CAMPO_NOMBRE + " TEXT, "
            + CAMPO_CLAVEUSUARIO + " TEXT)";
}
