package com.example.toshiba.basededatos3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toshiba.basededatos3.modelo.clases.java.Producto;

/**
 * Created by Toshiba on 31/10/2015.
 */
public class Alumnos extends Activity implements View.OnClickListener {

    private Button regresar;
    private Button nuevo;
    private Button modificar;
    private Button eliminar;
    private Button next;
    private Button back;

    private EditText txtNombre;
    private EditText txtApP;
    private EditText txtApM;
    private EditText txtCorreo;

    private BDSqLite BaseDatos;

    String Nombre,ApellidoP,ApellidoM,Correo;
    int Id_;

    private int contador=0;
    Producto[] producto;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alumnos);

        txtNombre=(EditText)findViewById(R.id.editText_NombreDatos);
        txtApP=(EditText)findViewById(R.id.editText_TipoDatos);
        txtApM=(EditText)findViewById(R.id.editText_StockDatos);
        txtCorreo=(EditText)findViewById(R.id.editText_PrecioDatos);


        regresar=(Button)findViewById(R.id.btnreg);
        nuevo=(Button)findViewById(R.id.btnNuevo);
        modificar=(Button)findViewById(R.id.btnModificar);
        eliminar=(Button)findViewById(R.id.btnEliminar);
        next=(Button)findViewById(R.id.btnSiguiente);
        back=(Button)findViewById(R.id.btnAnterior);

        regresar.setOnClickListener(this);
        nuevo.setOnClickListener(this);
        modificar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

        BaseDatos=new BDSqLite(getApplicationContext());

        producto=BaseDatos.ConsultarAlumnos();

        if(producto.length>0){

            txtNombre.setText(producto[0].getNombre());
            txtApP.setText(producto[0].getApellidoP());
            txtApM.setText(producto[0].getApellidoM());
            txtCorreo.setText(producto[0].getCorreo());
            contador++;


        }
        else{

            Toast.makeText(this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();

        }


    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnNuevo:
                Intent nuevo=new Intent(this,NAlumnos.class);
                startActivity(nuevo);
                break;

            case R.id.btnModificar:
                Id_=producto[contador].getId();
                Nombre=txtNombre.getText().toString();
                ApellidoP=txtApP.getText().toString();
                ApellidoM=txtApM.getText().toString();
                Correo=txtCorreo.getText().toString();

                BaseDatos.ModificarAlumnos(Id_, Nombre, ApellidoP, ApellidoM, Correo);
                producto=BaseDatos.ConsultarAlumnos();

                Toast.makeText(this, "Alumno "+Nombre+"modificado con exito...", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnEliminar:

                if(producto.length==1){
                    contador=0;
                }
                Id_=producto[contador].getId();

                BaseDatos.EliminarAlumnos(Id_);

                contador=0;

                Toast.makeText(this, Nombre+" Eliminado con exito...", Toast.LENGTH_SHORT).show();

                producto=BaseDatos.ConsultarAlumnos();
                if(producto.length>0){

                    txtNombre.setText(producto[0].getNombre());
                    txtApP.setText(producto[0].getApellidoP());
                    txtApM.setText(producto[0].getApellidoM());
                    txtCorreo.setText(producto[0].getCorreo());

                    contador++;


                }
                else{


                    Toast.makeText(this, "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
                    Intent mostrarnn=new Intent(this, NAlumnos.class);
                    startActivity(mostrarnn);
                }

                break;

            case R.id.btnreg:
                Intent reg=new Intent(this,OpAlums.class);
                startActivity(reg);
                break;

            case R.id.btnAnterior:
                if(producto.length>0){
                    if(contador>=0){
                        contador--;
                        if(contador<0){
                            contador++;
                        }

                        txtNombre.setText(producto[contador].getNombre());
                        txtApP.setText(producto[contador].getApellidoP());
                        txtApM.setText(producto[contador].getApellidoM());
                        txtCorreo.setText(producto[contador].getCorreo());


                    }

                }

                break;

            case R.id.btnSiguiente:
                if(producto.length>0){
                    if(contador<producto.length){
                        contador++;
                        if(contador==producto.length){
                            contador--;
                        }

                        txtNombre.setText(producto[contador].getNombre());
                        txtApP.setText(producto[contador].getApellidoP());
                        txtApM.setText(producto[contador].getApellidoM());
                        txtCorreo.setText(producto[contador].getCorreo());


                    }

                }
                break;
        }

    }
}
