package com.example.iiuctime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    TextView textView;
    EditText CRid;
    EditText password;
    Button loginbutton;
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        textView = findViewById(R.id.singUpId);
        CRid = findViewById(R.id.crId);
        password = findViewById(R.id.passwordId);
        loginbutton = findViewById(R.id.Login_button);
        progressBar = findViewById(R.id.prgressbarID);

        sharedPreferences = getSharedPreferences("loginRef",MODE_PRIVATE);
        editor = sharedPreferences.edit();


//        FirebaseUser user = mAuth.getCurrentUser();
//
//        if(user!=null){
//
//        }

        if(sharedPreferences.getBoolean("isLogged", false))
        {
            Intent intent = new Intent(getApplicationContext(),CrListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return;
        }


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userlogin();
            }
        });



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SingupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userlogin(){
        String id = CRid.getText().toString().trim();
        String pass = password.getText().toString().trim();




        if(id.isEmpty()){
            CRid.setError("Enter your ID");
            CRid.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(id).matches()){
            CRid.setError("Enter a valid ID");
            CRid.requestFocus();
            return;
        }

        if(pass.isEmpty()){
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }
        if(pass.length()<6){
            password.setError("Minimum length of password should be 6");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(id,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    sharedPreferences.edit().putBoolean("isLogged",true).apply();
                    Intent intent = new Intent(getApplicationContext(),CrListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}