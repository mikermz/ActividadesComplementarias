package app.persistense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionJDB extends SQLiteOpenHelper {
    public static final String DB_NAME ="ActividadComplementaria.db";
    public static final String TABLE_ACTIVIDAD = "Actividad";
    public static final String TABLE_ALUMNO = "Alumno";
    public static final String TABLE_DOCENTE = "Docente";
    public static final String TABLE_USUARIO = "Usuario";

    public ConexionJDB(String bd_actividades_complementarias, Context context, int version) {
        super(context, DB_NAME, null, 1);
    }


    public ConexionJDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL(ActividadCompDAOJDB.CREATE_TABLA_ACTIVIDAD);
        MyDB.execSQL(AlumnoDAOJDB.CREATE_TABLA_ALUMNO);
        MyDB.execSQL(DocenteDAOJDB.CREATE_TABLA_DOCENTE);
        MyDB.execSQL(UsuarioDAOJDB.CREATE_TABLA_USUARIO);


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS ACTIVIDADES");
        MyDB.execSQL("DROP TABLE IF EXISTS ALUMNOS");
        MyDB.execSQL("DROP TABLE IF EXISTS DOCENTES");
        MyDB.execSQL("DROP TABLE IF EXISTS USUARIOS");
        onCreate(MyDB);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("n_usuario",username);
        contentValues.put("contraseña",password);
        long result = MyDB.insert("usuario",null,contentValues);
        if(result == -1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from usuario where n_usuario = ?",
                new String[]{username});
        if(cursor.getCount() > 0) return true;
        else
            return false;
    }
    public Boolean checkusernamePassword(String username,String password){
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from usuario where n_usuario = ? and contraeña = ?",
                new String[]{username,password});
        if(cursor.getCount() > 0) return true;
        else
            return false;
    }
}
