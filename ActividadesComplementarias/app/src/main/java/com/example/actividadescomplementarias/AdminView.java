package com.example.actividadescomplementarias;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import java.util.ArrayList;

public class AdminView extends AppCompatActivity {
    private TableLayout tableLayout;
    private EditText txtName, txtLastName;
    private String[] header={"Id","Nombre","Apellido"};
    private ArrayList<String[]> rows = new ArrayList<>();
    TableDynamic tableDynamic;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        btnEditar=(Button)findViewById(R.id.btnEditarAct);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        this.tableLayout = (TableLayout) findViewById(R.id.tableAdmins);
        this.txtName = (EditText) findViewById(R.id.txtName);
        this.txtLastName = (EditText) findViewById(R.id.txtLastName);
        tableDynamic=new TableDynamic(tableLayout,getApplicationContext());
        tableDynamic.addHeader(header);
        tableDynamic.addData(getClients());
        tableDynamic.backgroundHeader(Color.BLUE);
        tableDynamic.backgroundData(Color.RED,Color.YELLOW);
        tableDynamic.lineColor(Color.BLACK);
        tableDynamic.textColorData(Color.WHITE);
        tableDynamic.textColorHeader(Color.MAGENTA);
    }

    public void save(){
        String[] item=new String[]{"5",txtName.getText().toString(),txtLastName.getText().toString()};
        tableDynamic.addItems(item);
    }

    private ArrayList<String[]> getClients(){
        rows.add(new String[]{"1","Pedro","Lopez"});
        rows.add(new String[]{"2","Sofia","Alfaro"});
        rows.add(new String[]{"3","Naomi","Espejel"});
        rows.add(new String[]{"4","Lorena","Gallegos"});
        return rows;
    }
}