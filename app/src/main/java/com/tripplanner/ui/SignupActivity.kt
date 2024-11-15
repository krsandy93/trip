package com.tripplanner.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.tripplanner.R

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_signup)



        edtEmail = findViewById(R.id.edtEmailSignup)
        edtPassword = findViewById(R.id.edtPasswordSignup)
        btnSignup = findViewById(R.id.btnSignup)
        auth = Firebase.auth
        btnSignup.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signUpUser(email, password)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUpUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        baseContext,
                        "Authentication Sucess.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    val user = auth.currentUser
                    /*updateUI(user)*/
                    finish()
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(
                        baseContext,
                        "Authentication failed."+task.exception,
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }
        /*auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign up successful, navigate to login screen
                    Toast.makeText(this, "Sign up successful!", Toast.LENGTH_SHORT).show()
                    finish()  // Close the signup activity and return to login
                } else {
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }*/
    }
}
