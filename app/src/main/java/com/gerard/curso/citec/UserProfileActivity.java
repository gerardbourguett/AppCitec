package com.gerard.curso.citec;

import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {

    // Creating button.
    Button logout,registro,conexion ;

    // Creating TextView.
    TextView userEmailShow ;

    // Creating FirebaseAuth.
    FirebaseAuth firebaseAuth ;

    // Creating FirebaseAuth.
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        // Assigning ID's to button and TextView.
        logout = (Button)findViewById(R.id.logout);
        registro = (Button)findViewById(R.id.registro);

        userEmailShow = (TextView)findViewById(R.id.user_email);
        // Adding FirebaseAuth instance to FirebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();
        // On activity start check whether there is user previously logged in or not.
        if(firebaseAuth.getCurrentUser() == null){
            // Finishing current Profile activity.
            finish();
            // If user already not log in then Redirect to LoginActivity .
            Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            // Showing toast message.
            Toast.makeText(UserProfileActivity.this, "Por favor, ingrese para continuar", Toast.LENGTH_LONG).show();
        }
        // Adding firebaseAuth current user info into firebaseUser object.
        firebaseUser = firebaseAuth.getCurrentUser();
        // Getting logged in user email from firebaseUser.getEmail() method and set into TextView.
        userEmailShow.setText("Ingreso satisfactorio. Tu email de ingreso es = " + firebaseUser.getEmail());
        // Adding click listener on logout button.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Destroying login season.
                firebaseAuth.signOut();
                // Finishing current User Profile activity.
                finish();
                // Redirect to Login Activity after click on logout button.
                Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                // Showing toast message on logout.
                Toast.makeText(UserProfileActivity.this, "Ha cerrado sesión satisfactoriamente", Toast.LENGTH_LONG).show();
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        conexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(UserProfileActivity.this, BluetoothActivity.class);
            }
        });
    }
}