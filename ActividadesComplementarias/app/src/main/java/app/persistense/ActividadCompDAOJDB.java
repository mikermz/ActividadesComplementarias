package app.persistense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.model.ActividadComp;

public class ActividadCompDAOJDB {
    Context context;
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


    public ActividadCompDAOJDB(Context context){
        this.context = context;
    }

    public Long InsertActividad(ActividadComp actividadComp){
        ConexionJDB conn = new ConexionJDB("ActividadComplementaria.db", context, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        Long idResultante;

        values.put(CAMPO_CLAVEACTIVIDAD, actividadComp.getClaveActividad());
        values.put(CAMPO_CLAVEALUMNO, actividadComp.getClaveAlumno());
        values.put(CAMPO_CLAVEDOCENTE, actividadComp.getClaveDocente());
        values.put(CAMPO_NOMBRE, actividadComp.getNombreActividad());
        values.put(CAMPO_TIPO,actividadComp.getTipoActividad());
        values.put(CAMPO_FECHAREALIZACION, actividadComp.getFechaRealizacion());
        values.put(CAMPO_NOMBREALUMNO, actividadComp.getNombreAlumno());
        values.put(CAMPO_NOMBREDOCENTE, actividadComp.getNombreDocente());
        values.put(CAMPO_SEMESTRE, actividadComp.getNombreDocente());
        values.put(CAMPO_CARRERA, actividadComp.getCarrera());
        idResultante = db.insert("ACTIVIDADES", CAMPO_CLAVEACTIVIDAD, values);
        return idResultante;
    }

    public int UpdateActividad(ActividadComp actividadComp){
        ConexionJDB conn = new ConexionJDB("ActividadComplementaria.db", context, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {String.valueOf( actividadComp.getClaveActividad())};
        ContentValues values = new ContentValues();
        int idResultante;

        values.put(CAMPO_CLAVEACTIVIDAD, actividadComp.getClaveActividad());
        values.put(CAMPO_CLAVEALUMNO, actividadComp.getClaveAlumno());
        values.put(CAMPO_CLAVEDOCENTE, actividadComp.getClaveDocente());
        values.put(CAMPO_NOMBRE, actividadComp.getNombreActividad());
        values.put(CAMPO_TIPO,actividadComp.getTipoActividad());
        values.put(CAMPO_FECHAREALIZACION, actividadComp.getFechaRealizacion());
        values.put(CAMPO_NOMBREALUMNO, actividadComp.getNombreAlumno());
        values.put(CAMPO_NOMBREDOCENTE, actividadComp.getNombreDocente());
        values.put(CAMPO_SEMESTRE, actividadComp.getNombreDocente());
        values.put(CAMPO_CARRERA, actividadComp.getCarrera());
        idResultante = db.update("ACTIVIDADES", values, CAMPO_CLAVEACTIVIDAD + "=?", parametros);
        db.close();
        return idResultante;
    }

    public List<ActividadComp> SelectAll(){
        ConexionJDB conn = new ConexionJDB(this, "ActividadComplementaria.db", context, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        ArrayList<ActividadComp> actividadesComp = new ArrayList();
        String[] campos = {CAMPO_CLAVEACTIVIDAD,
                CAMPO_CLAVEALUMNO,
                CAMPO_CLAVEDOCENTE,
                CAMPO_NOMBRE,
                CAMPO_TIPO,
                CAMPO_FECHAREALIZACION,
                CAMPO_NOMBREALUMNO,
                CAMPO_NOMBREDOCENTE,
                CAMPO_SEMESTRE,
                CAMPO_CARRERA};

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM " + "ACTIVIDADES", null);
            if (cursor.moveToFirst()){
                do {
                    ActividadComp actividadComp = new ActividadComp();

                    actividadComp.setClaveActividad(Integer.valueOf(cursor.getString(0)));
                    actividadComp.setClaveAlumno(Integer.valueOf(cursor.getString(1)));
                    actividadComp.setClaveDocente(Integer.valueOf(cursor.getString(2)));
                    actividadComp.setNombreActividad(cursor.getString(3));
                    actividadComp.setTipoActividad(cursor.getString(4));
                    actividadComp.setFechaRealizacion(cursor.getString(5));
                    actividadComp.setNombreAlumno(cursor.getString(6));
                    actividadComp.setNombreDocente(cursor.getString(7));
                    actividadComp.setCarrera(cursor.getString(8));
                    actividadesComp.add(actividadComp);
                }while (cursor.moveToNext());
            }

            cursor.close();
            return actividadesComp;

        }catch (Exception ex){

            return null;
        }
    }

    /*private void eliminarUsuarios(String claveAct) {
        ConexionJDB conn = new ConexionJDB(this,
                "ActividadComplementaria.db", context, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {claveAct};

        try {
            db.delete("ACTIVIDADES", CAMPO_CLAVEACTIVIDAD+ "=?", parametros);
            db.close();
        }catch (Exception e)
            return null;
        }
    }*/

}
