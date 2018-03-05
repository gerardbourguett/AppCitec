package com.gerard.curso.citec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gerard.curso.citec.objetos.Adapter;
import com.gerard.curso.citec.objetos.Constructora;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {

    private RecyclerView rv;

    List<Constructora> constructoras;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        rv = findViewById(R.id.recyclerView);

        rv.setLayoutManager(new LinearLayoutManager(this));

        constructoras = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(constructoras);

        rv.setAdapter(adapter);


        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                constructoras.removeAll(constructoras);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Constructora constructora = snapshot.getValue(Constructora.class);
                    constructoras.add(constructora);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
