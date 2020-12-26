package com.example.atom.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.atom.HomeActivity
import com.example.atom.MainActivity
import com.example.atom.R
import com.example.atom.databinding.FragmentUserRegistrationScreenBinding
import kotlinx.coroutines.launch


class UserRegistrationScreen : Fragment() {

    private var _binding: FragmentUserRegistrationScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataStore: DataStore<Preferences>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserRegistrationScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        dataStore = requireContext().createDataStore("setting")


        binding.backBtnToUserRegistration.setOnClickListener {
            findNavController().navigate(
                R.id.action_userRegistrationScreen_to_loginScreen
            )
        }

        binding.btnContinue.setOnClickListener {
            val userName: String = binding.etUsername.text.toString()
            Toast.makeText(context, userName, Toast.LENGTH_SHORT).show()
            saveToDb(userName)
        }
        return view
    }

    private suspend fun save(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    private fun saveToDb(userName: String) {
        lifecycleScope.launch{
            save("name" , userName)
            Toast.makeText(context, "Data saved to prefs", Toast.LENGTH_LONG).show()
        }
        val intent = Intent(activity , HomeActivity::class.java )
        startActivity(intent)
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}