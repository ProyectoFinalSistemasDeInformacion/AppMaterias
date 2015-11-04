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
public class VerDatos extends Activity  implements OnClickListener {

    private Button btnlistar;
    private Button btnadmi;
    private Button btnregresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);


        btnadmi=(Button)findViewById(R.id.button);

        btnregresar=(Button)findViewById(R.id.button3);
        btnlistar=(Button)findViewById(R.id.button2);

        btnlistar.setOnClickListener(this);
        btnregresar.setOnClickListener(this);
        btnadmi.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button:
                Intent mostrarPan=new Intent(this,ListaM.class);
                startActivity(mostrarPan);
                finish();
                break;


            case R.id.button2:
                Intent mostrarPantalla=new Intent(this,Administrar.class);
                startActivity(mostrarPantalla);
                finish();
                 break;

            case R.id.button3:
                Intent mostrar=new Intent(this,MainActivity.class);
                startActivity(mostrar);
                finish();
                break;

        }
    }
}
