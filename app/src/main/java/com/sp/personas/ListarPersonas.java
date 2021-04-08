package com.sp.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Clases.Persona;

public class ListarPersonas extends AppCompatActivity implements View.OnClickListener{

    public static ArrayList<Persona> listado = new ArrayList();

    private ListView txtLista;
    private Button btnVolver;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_personas);
        AgregarPersona agregar = new AgregarPersona();
        listado = agregar.personas;
        txtLista = findViewById(R.id.txtLista);
        btnVolver = findViewById(R.id.btnVolver);
        btnInicio = findViewById(R.id.btnInicio);
        btnVolver.setOnClickListener(this);
        btnInicio.setOnClickListener(this);
        ArrayAdapter<Persona> adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,recorreLista(listado));
        txtLista.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnVolver) {
            Intent intent= new Intent(this,AgregarPersona.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.btnInicio) {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    public List<String> recorreLista(List<Persona> list){
        ArrayList<String> listadoPersonas = new ArrayList();
        for (int i=0;i<list.size();i++){
            listadoPersonas.add(list.get(i).getNombre()+" "+list.get(i).getApellido()+" "+list.get(i).getEdad()
                    +" Años  "+list.get(i).getEmail()+" "+list.get(i).getCargo()+" $ "+list.get(i).getSalario());
        }
        return listadoPersonas;
    }
}
