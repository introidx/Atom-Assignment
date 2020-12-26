package com.example.atom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.core.preferencesKey
import com.example.atom.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    lateinit var auth : FirebaseAuth
    var user : FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
        user = auth.currentUser

        if (user != null){
            val intent = Intent(this , HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}