package com.example.toshiba.basededatos3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Toshiba on 24/10/2015.
 */
public class Nuevo extends Activity  implements OnClickListener {



    private Button btnnew;

    private Button btnbsck;

    private BDSqLite bd;

    private EditText cl;
    private EditText cr;
    private EditText t;
    private EditText p;
    private EditText a;
    private EditText e;
    private EditText n;

    String nombre,clave;
    int creditos,tarea, proyecto, examen, asistencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);
        n=(EditText)findViewById(R.id.nombre);
        cr=(EditText)findViewById(R.id.creditos);
        cl=(EditText)findViewById(R.id.clave);
        t=(EditText)findViewById(R.id.tarea);
        p=(EditText)findViewById(R.id.proyecto);
        e=(EditText)findViewById(R.id.examen);
        a=(EditText)findViewById(R.id.lista);

        bd=new BDSqLite(getApplicationContext());


        btnnew=(Button)findViewById(R.id.button4);
        btnbsck=(Button)findViewById(R.id.button5);

        btnnew.setOnClickListener(this);
        btnbsck.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button5:
                Intent mostrarPantalla=new Intent(this,Administrar.class);
                startActivity(mostrarPantalla);
                finish();
                break;

            case R.id.button4:
                nombre=n.getText().toString();
                creditos=Integer.valueOf(cr.getText().toString());
                clave=cl.getText().toString();
                tarea=Integer.valueOf(t.getText().toString());
                proyecto=Integer.valueOf(p.getText().toString());
                examen=Integer.valueOf(e.getText().toString());
                asistencia=Integer.valueOf(a.getText().toString());


                    bd.InsertarMaterias(nombre,creditos,clave,tarea,proyecto,examen,asistencia);

                    Toast.makeText(this,"Se guardo la materia " +nombre+ " exitosamente", Toast.LENGTH_LONG).show();
                    n.setText("");
                    cr.setText("");
                    cl.setText("");
                    t.setText("");
                    p.setText("");
                    e.setText("");
                    a.setText("");


                break;


        }
    }
}

