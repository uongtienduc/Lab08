package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterScreen extends AppCompatActivity {

    TextInputLayout regName, regEmail, regPassword, regPassword2;
    Button regBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        
        regName = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regPassword = findViewById(R.id.password);
        regPassword2 = findViewById(R.id.password2);
        regBtn = findViewById(R.id.button3);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("user");

                String name = regName.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();
                String password2 = regPassword2.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, email, password, password2);

                reference.child(email).setValue(helperClass);
            }
        });


    }
}