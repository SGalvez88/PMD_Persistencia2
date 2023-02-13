package com.example.pmd_persistencia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button botonGuardar;
    Button botonRecuperar;
    TextView txtIntro1;
    TextView txtIntro2;
    TextView txtShow1;
    TextView txtShow2;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonRecuperar = (Button) findViewById(R.id.botonRecuperar);
        txtIntro1 = (TextView) findViewById(R.id.dato1edit);
        txtIntro2 = (TextView) findViewById(R.id.dato2edit);
        txtShow1 = (TextView) findViewById(R.id.txVDato1);
        txtShow2 = (TextView) findViewById(R.id.txVDato2);
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Clave1", String.valueOf(txtIntro1.getText()));
                editor.putString("Clave2", String.valueOf(txtIntro2.getText()));
                editor.commit();
                txtIntro1.setText("");
                txtIntro2.setText("");
            }
        });

        botonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtShow1.setText(sharedPreferences.getString("Clave1", ""));
                txtShow2.setText(sharedPreferences.getString("Clave2", ""));
            }
        });
    }
}