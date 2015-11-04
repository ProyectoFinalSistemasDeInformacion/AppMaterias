package com.example.toshiba.basededatos3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Toshiba on 31/10/2015.
 */
public class NAlumnos extends Activity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtApP;
    private EditText txtApM;
    private EditText txtCorreo;

    private BDSqLite BaseDatos;

    String Nombre,ApellidoP,ApellidoM,Correo;

    private Button regresar;
    private Button guardar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevoa);

        txtNombre=(EditText)findViewById(R.id.editText_Nombre);
        txtApP=(EditText)findViewById(R.id.editText_Tipo);
        txtApM=(EditText)findViewById(R.id.editText_Stock);
        txtCorreo=(EditText)findViewById(R.id.editText_Precio);

        regresar=(Button)findViewById(R.id.btnVerDatos);
        guardar=(Button)findViewById(R.id.btnGuardar_);
        regresar.setOnClickListener(this);
        guardar.setOnClickListener(this);

        BaseDatos=new BDSqLite(getApplicationContext());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnVerDatos:
                Intent reg=new Intent(this, Alumnos.class);
                startActivity(reg);

            case R.id.btnGuardar_:

                Nombre=txtNombre.getText().toString();
                ApellidoP=txtApP.getText().toString();
                ApellidoM=txtApM.getText().toString();
                Correo=txtCorreo.getText().toString();

                BaseDatos.InsertarAlumnos(Nombre, ApellidoP, ApellidoM, Correo);

                Toast.makeText(this, "Se inserto " + Nombre + " exitosamente", Toast.LENGTH_SHORT).show();

                txtCorreo.setText("");
                txtApM.setText("");
                txtApP.setText("");
                txtNombre.setText("");
                break;
        }

    }
}
