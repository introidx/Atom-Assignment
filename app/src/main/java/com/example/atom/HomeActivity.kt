package com.example.atom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atom.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class HomeActivity : AppCompatActivity() {

    private var _binding : ActivityHomeBinding ? = null
    private val binding get() = _binding!!

    lateinit var auth : FirebaseAuth
    var user : FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser

//        if (user != null){
//            val intent = Intent(this , MainActivity::class.java)
//            startActivity(intent)
//        }

    }


}