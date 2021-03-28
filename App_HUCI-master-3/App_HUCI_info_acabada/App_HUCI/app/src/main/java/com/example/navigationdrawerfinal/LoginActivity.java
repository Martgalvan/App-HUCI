package com.example.navigationdrawerfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    TextView textViewEmail, textViewPassword;
    Button buttonRegister, buttonLogin, buttonLogout;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);



        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.buttonLogin);

        // BOTON LOGIN
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (email.isEmpty() && password.isEmpty()) {
                    editTextEmail.setError("El email está vacío");
                    editTextEmail.requestFocus();
                    editTextPassword.setError("La contraseña está vacía");
                    editTextPassword.requestFocus();
                } else if (email.isEmpty()) {
                    editTextEmail.setError("El email estávacío");
                    editTextEmail.requestFocus();
                } else if (password.isEmpty()) {
                    editTextPassword.setError("La contraseña está vacía");
                    editTextPassword.requestFocus();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                editTextPassword.setError("Contraseña incorrecta");
                                editTextPassword.requestFocus();
                            } else {
                                //LOGIN CORRECTO
                                Intent myintent = new Intent(LoginActivity.this, CorrectLogin.class);
                                myintent.putExtra("email", email);
                                myintent.putExtra("pass", password);
                                startActivity(myintent);
                                SaveSharedPreference.setUserName(LoginActivity.this, email, password);

                            }
                        }
                    });
                }
            }
        });


        // BOTON REGISTRO
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (email.isEmpty() && password.isEmpty()) {
                    editTextEmail.setError("El email está vacío");
                    editTextEmail.requestFocus();
                    editTextPassword.setError("La contraseña está vacía");
                    editTextPassword.requestFocus();
                } else if (email.isEmpty()) {
                    editTextEmail.setError("El email está vacío");
                    editTextEmail.requestFocus();
                } else if (password.isEmpty()) {
                    editTextPassword.setError("La contraseña está vacía");
                    editTextPassword.requestFocus();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                try {
                                    throw task.getException();
                                }
                                // if user enters wrong email.
                                catch (FirebaseAuthWeakPasswordException weakPassword) {
                                    Log.d("TAG", "onComplete: weak_password");

                                    editTextPassword.setError("La contraseña es demasiado débil");
                                    editTextPassword.requestFocus();
                                }
                                // if user enters wrong password.
                                catch (FirebaseAuthInvalidCredentialsException malformedEmail) {
                                    Log.d("TAG", "onComplete: malformed_email");

                                    editTextEmail.setError("El email introducido no es válido");
                                    editTextEmail.requestFocus();
                                } catch (FirebaseAuthUserCollisionException existEmail) {
                                    Log.d("TAG", "onComplete: exist_email");

                                    editTextEmail.setError("Este email ya está registrado! Inicia sesión para continuar");
                                    editTextEmail.requestFocus();
                                } catch (Exception e) {
                                    Log.d("TAG", "onComplete: " + e.getMessage());
                                }
                            } else {
                                // REGISTRO CORRECTO
                                Intent myintent = new Intent(LoginActivity.this, CorrectLogin.class);
                                myintent.putExtra("email", email);
                                myintent.putExtra("pass", password);
                                startActivity(myintent);
                                SaveSharedPreference.setUserName(LoginActivity.this, email, password);

                            }
                        }
                    });
                } else {
                    // otro tipo de error
                }
            }
        });


    }
}



