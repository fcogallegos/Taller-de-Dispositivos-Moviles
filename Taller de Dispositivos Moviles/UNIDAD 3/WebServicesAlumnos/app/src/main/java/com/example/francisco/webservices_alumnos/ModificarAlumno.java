package com.example.francisco.webservices_alumnos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by francisco on 11/04/18.
 */

public class ModificarAlumno extends AppCompatActivity {

    EditText txtNombre, txtDireccion;
    Button btnModificar;
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_alumno);

        txtNombre = findViewById(R.id.txtNombreModificar);
        txtDireccion = findViewById(R.id.txtDireccionModificar);
        btnModificar = findViewById(R.id.btnModificar);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b != null){
            id = Integer.parseInt(b.get("id").toString());
            txtNombre.setText(b.get("nombre").toString());
            txtDireccion.setText(b.get("direccion").toString());
        }

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombre.getText().toString();
                String direccion = txtDireccion.getText().toString();

                new AlumnoAPI().execute("http://10.58.1.42:8080/datos1/actualizar_alumno.php",id+"",nombre,direccion);

                finish();
                MainActivity.adapter.notifyDataSetChanged();
            }
        });

    }

}
