package com.example.actividadescomplementarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import app.model.ActividadComp;
import app.persistense.ActividadCompDAOJDB;

public class EditActividad extends AppCompatActivity {
    Button btnAltas, btnModificar, btnEliminar,btnRegresar;
    EditText etNumeroControl, etActividad, etFecha;
    Spinner spTipos;
    ActividadCompDAOJDB manejador;
    ActividadComp actividad;
    AdminView adminView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_actividad);
        adminView = new AdminView();
        manejador = new ActividadCompDAOJDB(getApplicationContext());
        btnAltas = (Button) findViewById(R.id.btAgregar);
        btnRegresar = (Button) findViewById(R.id.btnRegresarActs);
        btnModificar = (Button) findViewById(R.id.btModificar);
        btnEliminar = (Button) findViewById(R.id.btEliminar);
        etNumeroControl= (EditText) findViewById(R.id.editNumControl);
        etActividad= (EditText) findViewById(R.id.editNombreAct);
        etFecha= (EditText) findViewById(R.id.editTextDate);
        spTipos=(Spinner)  findViewById(R.id.spinner);
        btnAltas.setOnClickListener((view)->{
            registrarActivida();
        });
        btnModificar.setOnClickListener((view)->{
            modificarActividad();
        });
        btnEliminar.setOnClickListener((view)->{
            eliminarActividad();
        });
        btnRegresar.setOnClickListener((view)->{
            Intent intent = new Intent(this, AdminView.class);
            startActivity(intent);
        });
    }

    private void eliminarActividad() {
        /*try {
            Toast.makeText(getApplicationContext(), "Se elimino al usuario ", Toast.LENGTH_SHORT);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El di no existe ", Toast.LENGTH_SHORT);
        }*/
    }

    private void modificarActividad() {

    }

    private void registrarActivida() {

        try {
            actividad =new ActividadComp();
            actividad.setNombreActividad(etActividad.getText().toString());
            actividad.setTipoActividad(spTipos.getTransitionName());
            actividad.setClaveAlumno(Integer.valueOf(etNumeroControl.getText().toString()));
            actividad.setFechaRealizacion(etFecha.getText().toString());
            actividad.setNombreDocente("Jefferson Gutierritos");
            actividad.setNombreAlumno("Alvin Yakitori");
            actividad.setCarrera("ISC");
            actividad.setSemestre(7);
            actividad.setClaveDocente(6348);
            if (manejador.InsertActividad(actividad)>0) {
                String[] item = new String[]{"" + Integer.valueOf(actividad.getClaveAlumno()),
                        String.valueOf(actividad.getNombreAlumno()),
                        String.valueOf(actividad.getCarrera()),
                        String.valueOf(actividad.getNombreActividad())};
                adminView.tableDynamic.addItems(item);
                Toast.makeText(getApplicationContext(), "Se registro la actividad", Toast.LENGTH_SHORT);
            }else
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT);
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT);
        }
    }

    private void limpiar() {
        etNumeroControl.setText("");
        etActividad.setText("");
        etFecha.setText("");
    }
}