package com.example.iiuctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SingupActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    //EditText editText3;
    ProgressBar progressBar;
    Button buttonSingUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        mAuth = FirebaseAuth.getInstance();
        editText1 = findViewById(R.id.crId);
        editText2 = findViewById(R.id.passwordId);
        //editText3 = findViewById(R.id.phoneNumId);
        progressBar = findViewById(R.id.prgressbarID);

        buttonSingUp = findViewById(R.id.singUpButton);

        buttonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    private void register() {

        String id = editText1.getText().toString().trim();
        String pass = editText2.getText().toString().trim();
        //String phone = editText3.getText().toString().trim();

        if(id.isEmpty()){
            editText1.setError("Enter your ID");
            editText1.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(id).matches()){
            editText1.setError("Enter a valid ID");
            editText1.requestFocus();
            return;
        }

        if(pass.isEmpty()){
            editText2.setError("Enter a password");
            editText2.requestFocus();
            return;
        }
        if(pass.length()<6){
            editText2.setError("Minimum length of password should be 6");
            editText2.requestFocus();
            return;
        }

//        if(phone.isEmpty()){
//            editText3.setError("Enter a password");
//            editText3.requestFocus();
//            return;
//        }
//        if(phone.length()<11 && phone.length()>11){
//            editText3.setError("Minimum length of password should be 6");
//            editText3.requestFocus();
//            return;
//        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(id,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    finish();
                    Toast.makeText(getApplicationContext(),"Register is successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),CrListActivity.class));
                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User is Already registerd!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

