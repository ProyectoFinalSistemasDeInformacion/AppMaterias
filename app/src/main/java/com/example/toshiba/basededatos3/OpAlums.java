package com.example.toshiba.basededatos3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Toshiba on 31/10/2015.
 */
public class OpAlums extends Activity implements View.OnClickListener {

    private Button listar;
    private Button regresar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opalums);

        listar=(Button)findViewById(R.id.mostrar);
        regresar=(Button)findViewById(R.id.reg);

        listar.setOnClickListener(this);
        regresar.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mostrar:
                Intent mostraraPan=new Intent(this,Alumnos.class);
                startActivity(mostraraPan);
                break;
            case R.id.reg:
                Intent mostrarPan=new Intent(this,ListaM.class);
                startActivity(mostrarPan);
                break;
        }
    }
}
