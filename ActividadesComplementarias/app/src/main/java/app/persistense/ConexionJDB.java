package app.persistense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionJDB extends SQLiteOpenHelper {

    public static final String DB_NAME ="ActividadComplementaria.db";

    public ConexionJDB(Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

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
