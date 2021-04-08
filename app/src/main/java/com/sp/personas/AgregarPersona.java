package com.sp.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.regex.Pattern;

import Clases.Persona;

import static java.lang.Integer.parseInt;

public class AgregarPersona extends AppCompatActivity implements View.OnClickListener{

    Persona persona = new Persona();

    public static ArrayList<Persona> personas = new ArrayList();

    private Button btnAgregarPer;
    private Button btnInicio;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEdad;
    private EditText txtEmail;
    private EditText txtCargo;
    private EditText txtSalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        btnAgregarPer = findViewById(R.id.btnAgregarPer);
        btnInicio = findViewById(R.id.btnInicio);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);
        txtEmail = findViewById(R.id.txtEmail);
        txtCargo = findViewById(R.id.txtCargo);
        txtSalario = findViewById(R.id.txtSalario);
        btnInicio.setOnClickListener(this);
        btnAgregarPer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAgregarPer){
            String nombre =txtNombre.getText().toString();
            String apellido =txtApellido.getText().toString();
            String edad =txtEdad.getText().toString();
            String email =txtEmail.getText().toString();
            String cargo =txtCargo.getText().toString();
            String salario =txtSalario.getText().toString();
            if (nombre.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el Nombre",R.layout.custom_toast).show();
                return;
            }
            if (apellido.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el Apellido",R.layout.custom_toast).show();
                return;
            }
            if (edad.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar la Edad",R.layout.custom_toast).show();
                return;
            }
            if (!isValidEmail(email)){
                CustomToastView.makeErrorToast(this,"Error al validar el Email",R.layout.custom_toast).show();
                return;
            }
            if (cargo.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el Cargo",R.layout.custom_toast).show();
                return;
            }
            if (salario.isEmpty()){
                CustomToastView.makeErrorToast(this,"Error al validar el Salario",R.layout.custom_toast).show();
                return;
            }


            Persona nuevaPersona;
            nuevaPersona = new Persona();
            nuevaPersona.setNombre(nombre);
            nuevaPersona.setApellido(apellido);
            nuevaPersona.setEdad(parseInt(edad));
            nuevaPersona.setEmail(email);
            nuevaPersona.setCargo(cargo);
            nuevaPersona.setSalario(parseInt(salario));

            personas.add(nuevaPersona);
            Intent intent = new Intent(this,ListarPersonas.class);
            startActivity(intent);

        }

        if (v.getId() == R.id.btnInicio) {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }


    private boolean isValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }


}
