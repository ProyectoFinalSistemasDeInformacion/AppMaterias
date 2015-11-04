package com.example.toshiba.basededatos3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {
    final static String user = "admin";
    final static String pass = "admin";


    private Button log;
    EditText nombre;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pass);
        log = (Button) findViewById(R.id.login);
        log.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        nombre.getText();
        password.getText();

        String a = nombre.getText().toString();
        String b = password.getText().toString();

        if (a.equals(user) && b.equals(pass)) {

            Intent mostar = new Intent(this, VerDatos.class);
            startActivity(mostar);
            finish();
        } else
            Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show();
        password.setText("");


    }

}