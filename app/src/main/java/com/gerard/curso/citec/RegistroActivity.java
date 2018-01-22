package com.gerard.curso.citec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gerard.curso.citec.objetos.DatoRandom;
import com.gerard.curso.citec.objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class RegistroActivity extends AppCompatActivity {

    Button boton1,boton2;
    TextView dato1,dato2,numero1,numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        boton1 = findViewById(R.id.registro);
        boton2 = findViewById(R.id.volver);
        dato1 = findViewById(R.id.dato1);
        dato2 = findViewById(R.id.dato2);
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.DATORANDOM_REFERENCE);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatoRandom registro = new DatoRandom(dato1, dato2, numero1,numero2);
                myRef.child(FirebaseReferences.DATORANDOM_REFERENCE).push().setValue(registro);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistroActivity.this, UserProfileActivity.class);
            }
        });
    }

}
