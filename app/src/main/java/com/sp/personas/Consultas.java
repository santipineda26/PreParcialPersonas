package com.sp.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Clases.Persona;

public class Consultas extends AppCompatActivity implements View .OnClickListener{

    public static ArrayList<Persona> listadoConsultas = new ArrayList();

    private Button btnPersonas;
    private Button btnCargos;
    private Button btnSalarios;
    private Button btnInicio;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        AgregarPersona agregar = new AgregarPersona();
        listadoConsultas = agregar.personas;
        btnPersonas = findViewById(R.id.btnPersonas);
        btnCargos = findViewById(R.id.btnCargos);
        btnSalarios = findViewById(R.id.btnSalarios);
        txtResultado = findViewById(R.id.txtResultado);
        btnInicio = findViewById(R.id.btnInicio);
        btnPersonas.setOnClickListener(this);
        btnCargos.setOnClickListener(this);
        btnSalarios.setOnClickListener(this);
        btnInicio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPersonas) {
            consultasPersonas(listadoConsultas);
        }
        if (v.getId() == R.id.btnSalarios) {
            consultasSalarios(listadoConsultas);
        }
        if (v.getId() == R.id.btnCargos) {
            List<String> listadoCargos = listaCargos(listadoConsultas);
            comparacionCargos(listadoConsultas,listadoCargos);
        }
        if (v.getId() == R.id.btnInicio) {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    public void consultasPersonas(List<Persona> list){
        int edad=100;
        int edadM=0;
        String mayor="";
        String menor="";
        for (int i=0;i<list.size();i++){
            if (list.get(i).getEdad()<edad){
                edad = list.get(i).getEdad();
                menor="Persona Menor\n"+list.get(i).getNombre()+" "+list.get(i).getApellido()+" "+list.get(i).getEdad()
                        +" Años  "+list.get(i).getEmail()+" "+list.get(i).getCargo()+" $"+list.get(i).getSalario();
            }
            if (list.get(i).getEdad()>edadM){
                edadM = list.get(i).getEdad();
                mayor="Persona Mayor\n"+list.get(i).getNombre()+" "+list.get(i).getApellido()+" "+list.get(i).getEdad()
                        +" Años  "+list.get(i).getEmail()+" "+list.get(i).getCargo()+" $"+list.get(i).getSalario();
            }
        }
        String resultado = mayor +"\n"+menor;
        txtResultado.setText(resultado);
    }

    public void consultasSalarios(List<Persona> list){
        int salario = 100000000;
        int salarioM = 0;
        int promedio = 0;
        String mayor="";
        String menor="";
        for (int i=0;i<list.size();i++){
            if (list.get(i).getSalario()<salario){
                salario = list.get(i).getSalario();
                menor="Salario Menor\n"+list.get(i).getNombre()+" "+list.get(i).getApellido()+" "+list.get(i).getEdad()
                        +" Años  "+list.get(i).getEmail()+" "+list.get(i).getCargo()+" $ "+list.get(i).getSalario();
            }
            if (list.get(i).getSalario()>salarioM){
                salarioM = list.get(i).getSalario();
                mayor="Salario Mayor\n"+list.get(i).getNombre()+" "+list.get(i).getApellido()+" "+list.get(i).getEdad()
                        +" Años  "+list.get(i).getEmail()+" "+list.get(i).getCargo()+" $ "+list.get(i).getSalario();
            }
            promedio = promedio + list.get(i).getSalario();
        }
        int tamaño = list.size();
        int prom = promedio / tamaño;
        String resultado = mayor +"\n"+menor+"\nPromedio \n"+ " $ "+prom;
        txtResultado.setText(resultado);
    }

    public List<String> listaCargos (List<Persona> list){
        ArrayList<String> listaCargos = new ArrayList();
        for (int i=0;i<list.size();i++){
            if(!listaCargos.contains(list.get(i).getCargo())) {
                listaCargos.add(list.get(i).getCargo());
            }
        }
        return listaCargos;

    }
    public void comparacionCargos(List<Persona> list,List<String>cargo) {
        Collections.sort(list, new Comparator<Persona>() {
            public int compare(Persona var1, Persona var2) {
                return var1.getCargo().compareTo(var2.getCargo());
            }
        });

        for (int j = 0; j < cargo.size(); j++) {
            int contador = 0;
            int suma=0;
            String cargos="";
            for (int i = 0; i < list.size(); i++) {
                if (cargo.get(j).equals(list.get(i).getCargo())) {
                    contador++;
                    cargos=list.get(i).getCargo();
                    suma=suma+list.get(i).getSalario();
                }
            }
            String result=txtResultado.getText().toString()
                    + "\n"+"Cargo: "+cargos+" Cantidad Personas por Cargo: "+contador + " Promedio Salario por Cargo: "+(suma/contador)+"\n";
            txtResultado.setText(result);
        }

    }
}


