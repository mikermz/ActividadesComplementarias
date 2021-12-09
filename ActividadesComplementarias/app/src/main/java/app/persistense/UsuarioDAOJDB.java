package app.persistense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.model.ActividadComp;
import app.model.Usuario;

public class UsuarioDAOJDB {
    Context context;
    public static  final String CAMPO_CLAVE  = "clave";
    public static  final String CAMPO_USUARIO = "usuario";
    public static  final String CAMPO_PASSWORD = "password";
    public static  final String CREATE_TABLA_USUARIO = "CREATE TABLE USUARIOS"
            + " (" + CAMPO_CLAVE + " INTEGER, "
            + CAMPO_CLAVE + " INTEGER, "
            + CAMPO_USUARIO + " TEXT, "
            + CAMPO_PASSWORD + " TEXT)";

    public UsuarioDAOJDB(Context context){
        this.context = context;
    }

    public Usuario login (String sNumeroConrtol, String sPassword){
        ConexionJDB conn = new ConexionJDB( "ActividadComplementaria.db", context, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        Usuario oUsuario = new Usuario();
        String[] parametros = {sNumeroConrtol, sPassword};
        String[] campos = {CAMPO_CLAVE
        ,CAMPO_USUARIO
         ,CAMPO_PASSWORD};

        try {
            Cursor cursor = db.query("USUARIOS", campos, CAMPO_USUARIO + " =? AND " + CAMPO_PASSWORD + " =?",parametros, null,null,null);
            for (int i = 0; i<cursor.getCount(); i++){
                ActividadComp actividadComp = new ActividadComp();

                cursor.move(i);
                actividadComp.setClaveActividad(Integer.valueOf(cursor.getString(0)));
                actividadComp.setClaveAlumno(Integer.valueOf(cursor.getString(1)));
                actividadComp.setClaveDocente(Integer.valueOf(cursor.getString(3)));
            }
            cursor.close();
            return oUsuario;
        }catch (Exception ex){
            return null;
        }
    }


    public Long InsertActividad(Usuario oUsuario){
        ConexionJDB conn = new ConexionJDB( "ActividadComplementaria.db", context, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        Long idResultante;

        values.put(CAMPO_CLAVE, oUsuario.getTipoUsuario());
        values.put(CAMPO_USUARIO, oUsuario.getTipoUsuario());
        values.put(CAMPO_PASSWORD, oUsuario.getContra());
        idResultante = db.insert("ACTIVIDADES", CAMPO_CLAVE, values);
        return idResultante;
    }
}
