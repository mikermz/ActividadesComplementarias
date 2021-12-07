package com.example.actividadescomplementarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import app.model.ActividadComp;
import app.persistense.ActividadCompDAOJDB;

public class EditActividad extends AppCompatActivity {
    Button btnAltas, btnModificar, btnEliminar;
    EditText etNumeroControl, etActividad, etFecha;
    Spinner spTipos;
    ActividadCompDAOJDB manejador = new ActividadCompDAOJDB();
    ActividadComp actividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_actividad);
        btnAltas = (Button) findViewById(R.id.btAgregar);
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
    }

    private void eliminarActividad() {

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
            if (manejador.InsertActividad(actividad)>0)
                Toast.makeText(getApplicationContext(), "Se registro la actividad", Toast.LENGTH_SHORT);
            else
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