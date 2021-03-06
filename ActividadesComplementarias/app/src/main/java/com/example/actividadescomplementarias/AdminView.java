package com.example.actividadescomplementarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import app.model.ActividadComp;
import app.persistense.ActividadCompDAOJDB;

public class AdminView extends AppCompatActivity {
    private TableLayout tableLayout;
    //private EditText txtName, txtLastName;
    private String[] header={"Numero de Control","Nombre","Carrera","Actividad"};
    private ArrayList<String[]> rows = new ArrayList<>();
    TableDynamic tableDynamic;
    private Button btnEditar,btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        //btnGuardar=(Button)findViewById(R.id.btnGuardar);
        btnEditar=(Button)findViewById(R.id.btnEditarAct);
        /*btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });*/
        btnEditar.setOnClickListener((view)->{
            Intent intent = new Intent(this, EditActividad.class);
            startActivity(intent);
        });
        this.tableLayout = (TableLayout) findViewById(R.id.tableAdmins);
        //this.txtName = (EditText) findViewById(R.id.txtName);
        //this.txtLastName = (EditText) findViewById(R.id.txtLastName);
        tableDynamic=new TableDynamic(tableLayout,getApplicationContext());
        tableDynamic.addHeader(header);
        tableDynamic.addData(getActividades());
        tableDynamic.backgroundHeader(Color.BLUE);
        tableDynamic.backgroundData(Color.RED,Color.YELLOW);
        tableDynamic.lineColor(Color.BLACK);
        tableDynamic.textColorData(Color.WHITE);
        tableDynamic.textColorHeader(Color.MAGENTA);
    }

    /*public void save(){
        String[] item=new String[]{"5",txtName.getText().toString(),txtLastName.getText().toString()};
        tableDynamic.addItems(item);
    }

    /*private ArrayList<String[]> getClients(){
        rows.add(new String[]{"1","Pedro","Lopez"});
        rows.add(new String[]{"2","Sofia","Alfaro"});
        rows.add(new String[]{"3","Naomi","Espejel"});
        rows.add(new String[]{"4","Lorena","Gallegos"});
        return rows;
    }*/
    private ArrayList<String[]> getActividades(){
        ActividadCompDAOJDB aDAO = new ActividadCompDAOJDB(getApplicationContext());
        List<ActividadComp> acts;
        acts = aDAO.SelectAll();
        Log.d("length", ""+acts.size());
        for (ActividadComp actividadComp : acts) {
                Log.d("Clave alumno: ", String.valueOf(actividadComp.getClaveAlumno()));
                Log.d("Nombre alumno: ", String.valueOf(actividadComp.getNombreAlumno()));
                Log.d("Carrera: ", String.valueOf(actividadComp.getCarrera()));
                Log.d("Actividad: ", String.valueOf(actividadComp.getNombreActividad()));
                rows.add(new String[]{String.valueOf(actividadComp.getClaveAlumno()),
                        String.valueOf(actividadComp.getNombreAlumno()),
                        String.valueOf(actividadComp.getCarrera()),
                        String.valueOf(actividadComp.getNombreActividad())});
        }


        return rows;
    }
}