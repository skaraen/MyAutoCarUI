package com.example.karaens.myautocarui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText lName,lKey;
    TextView lSignUp;
    Button lLogIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lName=findViewById(R.id.lName);
        lKey=findViewById(R.id.lKey);
        lSignUp=findViewById(R.id.lSignUp);
        lLogIn=findViewById(R.id.lLogIn);
        mAuth=FirebaseAuth.getInstance();

        lLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=lName.getText().toString();
                final String key=lKey.getText().toString();
                Log.d("tag","s0");

                if(name.isEmpty()){
                    lName.setError("Enter car name !");
                    lName.findFocus();
                }
                if(key.isEmpty()){
                    lKey.setError("Enter the key !");
                    lKey.findFocus();
                }
                if(!(key.isEmpty()||name.isEmpty())) {
                    Log.d("tag","s1");
                    mAuth.signInWithEmailAndPassword(name, key).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this, "Success !", Toast.LENGTH_LONG).show();
                                SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
                                editor.putInt("state",1);
                                editor.apply();
                            }
                            else
                                Toast.makeText(LoginActivity.this, "failure", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        lSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

    }
}
