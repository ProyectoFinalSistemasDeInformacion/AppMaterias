package com.example.toshiba.basededatos3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toshiba.basededatos3.modelo.clases.java.Productos;

/**
 * Created by Toshiba on 26/10/2015.
 */
public class Administrar extends Activity implements View.OnClickListener {
private Button regresar;
private EditText n;
    private EditText cl;
    private EditText cr;
    private EditText t;
    private EditText p;
    private EditText a;
    private EditText e;

    private Button btnn;
    private Button btnm;
    private Button btnb;
    private Button btna;
    private Button btns;


    private BDSqLite bd;

    private int contador=0;
    Productos[] productos;

    String nombre,clave;
    int Id_,creditos,tarea, proyecto, examen, asistencia;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admi);
        btnb=(Button)findViewById(R.id.eliminarm);
        btna=(Button)findViewById(R.id.guardar);
        btnm=(Button)findViewById(R.id.modificm);
        btnn=(Button)findViewById(R.id.nuevom);
        regresar=(Button)findViewById(R.id.regresar);
        btns=(Button)findViewById(R.id.siguiente);

        n=(EditText)findViewById(R.id.nombrem);
        cr=(EditText)findViewById(R.id.creditosm);
        cl=(EditText)findViewById(R.id.clavem);
        t=(EditText)findViewById(R.id.taream);
        p=(EditText)findViewById(R.id.proyectom);
        e=(EditText)findViewById(R.id.examenm);
        a=(EditText)findViewById(R.id.listam);

        btns.setOnClickListener(this);
        btna.setOnClickListener(this);
        regresar.setOnClickListener(this);
        btnn.setOnClickListener(this);
        btnb.setOnClickListener(this);
        btnm.setOnClickListener(this);

        bd=new BDSqLite(getApplicationContext());

        productos=bd.ConsultarMaterias();

        if(productos.length>0){

            n.setText(productos[0].getNombre());
            cr.setText(String.valueOf(productos[0].getCosto()));
            cl.setText(productos[0].getDescripcion());
            t.setText(String.valueOf(productos[0].getTarea()));
            p.setText(String.valueOf(productos[0].getProyecto()));
            e.setText(String.valueOf(productos[0].getExamen()));
            a.setText(String.valueOf(productos[0].getAsistencia()));
            contador++;


            }
        else{


            Toast.makeText(Administrar.this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
            Intent mostrarn=new Intent(this, Nuevo.class);
            startActivity(mostrarn);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regresar:
        Intent mostrar=new Intent(this, VerDatos.class);
        startActivity(mostrar);
                break;

            case R.id.nuevom:
                Intent mostrarn=new Intent(this, Nuevo.class);
                startActivity(mostrarn);
                break;

            case R.id.siguiente:
                if(productos.length>0){
                    if(contador<productos.length){
                        contador++;
                        if(contador==productos.length){
                            contador--;
                        }

                        n.setText(productos[contador].getNombre());
                        cr.setText(String.valueOf(productos[contador].getCosto()));
                        cl.setText(productos[contador].getDescripcion());
                        t.setText(String.valueOf(productos[contador].getTarea()));
                        p.setText(String.valueOf(productos[contador].getProyecto()));
                        e.setText(String.valueOf(productos[contador].getExamen()));
                        a.setText(String.valueOf(productos[contador].getAsistencia()));
                    }

                }
                break;

            case R.id.guardar:
                if(productos.length>0){
                    if(contador>=0){
                        contador--;
                        if(contador<0){
                            contador++;
                        }

                        n.setText(productos[contador].getNombre());
                        cr.setText(String.valueOf(productos[contador].getCosto()));
                        cl.setText(String.valueOf(productos[contador].getDescripcion()));
                        t.setText(String.valueOf(productos[contador].getTarea()));
                        p.setText(String.valueOf(productos[contador].getProyecto()));
                        e.setText(String.valueOf(productos[contador].getExamen()));
                        a.setText(String.valueOf(productos[contador].getAsistencia()));
                    }

                }
                break;

            case R.id.eliminarm:

                if(productos.length==1){
                    contador=0;
                }
                Id_=productos[contador].getId();

                bd.EliminarMaterias(Id_);

                contador=0;

                Toast.makeText(this, nombre+" Eliminado con exito...", Toast.LENGTH_SHORT).show();

                productos=bd.ConsultarMaterias();
                if(productos.length>0){

                    n.setText(productos[0].getNombre());
                    cr.setText(String.valueOf(productos[0].getCosto()));
                    cl.setText(productos[0].getDescripcion());
                    t.setText(String.valueOf(productos[0].getTarea()));
                    p.setText(String.valueOf(productos[0].getProyecto()));
                    e.setText(String.valueOf(productos[0].getExamen()));
                    a.setText(String.valueOf(productos[0].getAsistencia()));
                    contador++;


                }
                else{


                    Toast.makeText(Administrar.this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
                    Intent mostrarnn=new Intent(this, Nuevo.class);
                    startActivity(mostrarnn);
                }
                break;

            case R.id.modificm:

                Id_=productos[contador].getId();
                nombre=n.getText().toString();
                creditos=Integer.valueOf(cr.getText().toString());
                clave=cl.getText().toString();
                tarea=Integer.valueOf(t.getText().toString());
                proyecto=Integer.valueOf(p.getText().toString());
                examen=Integer.valueOf(e.getText().toString());
                asistencia=Integer.valueOf(a.getText().toString());

                bd.ModificarMaterias(Id_,nombre,creditos,clave,tarea,proyecto,examen,asistencia);
                productos=bd.ConsultarMaterias();

                Toast.makeText(this, nombre+" modificado con exito...", Toast.LENGTH_SHORT).show();


                break;

    }}
}
