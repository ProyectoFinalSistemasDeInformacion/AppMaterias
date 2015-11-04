package com.example.toshiba.basededatos3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiba on 31/10/2015.
 */
public class ListaM extends Activity implements View.OnClickListener {
private Button regresar;
private Button continuar;

    BDSqLite bd;
    private Spinner mat;
    private List<String> lista;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listamat);
        regresar=(Button)findViewById(R.id.button7);
        regresar.setOnClickListener(this);

        continuar=(Button)findViewById(R.id.button6);
        continuar.setOnClickListener(this);



        bd=new BDSqLite(this);
        cargar();

    }

    public void cargar (){
        BDSqLite baseHelper=new BDSqLite(this);
        int i=0;
        SQLiteDatabase db=baseHelper.getReadableDatabase();
        if(db!=null){
            Cursor c=db.rawQuery("select * from Materias",null);
            int cantidad=c.getCount();
            String[] arreglo=new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea="Mat: "+c.getString(1)+"----- '"+c.getString(3)+"'";
                    arreglo[i]=linea;
                    i++;
                }while (c.moveToNext());
            }

            ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arreglo);
            mat=(Spinner)findViewById(R.id.spinner);
            mat.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button7:
                Intent mostrar=new Intent(this, VerDatos.class);
                startActivity(mostrar);
                break;
            case R.id.button6:
                Intent mostrarc=new Intent(this, OpAlums.class);
                startActivity(mostrarc);
                break;
        }
    }

}