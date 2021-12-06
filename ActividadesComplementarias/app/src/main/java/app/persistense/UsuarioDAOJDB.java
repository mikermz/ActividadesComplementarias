package app.persistense;

public class UsuarioDAOJDB {
    public static  final String CAMPO_NOMBRE = "nombre";
    public static  final String CAMPO_USUARIO = "usuario";
    public static  final String CAMPO_PASSWORD = "password";
    public static  final String CREATE_TABLA_DOCENTE = "CREATE TABLE USUARIOS"
            + " (" + CAMPO_NOMBRE + " TEXT, "
            + CAMPO_USUARIO + " TEXT, "
            + CAMPO_PASSWORD + " TEXT)";
}
