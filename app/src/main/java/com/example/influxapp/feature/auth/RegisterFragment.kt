package com.example.influxapp.feature.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.influxapp.HomeActivity
import com.example.influxapp.R
import com.example.influxapp.database.models.UserModel
import com.example.influxapp.feature.ExpenseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: ExpenseViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fullName = view.findViewById<EditText>(R.id.txtName)
        val txtUsername = view.findViewById<EditText>(R.id.txtUsername)
        val password = view.findViewById<EditText>(R.id.txtPwd)
        val btn = view.findViewById<Button>(R.id.btnRegister)
        val linkLogin = view.findViewById<TextView>(R.id.lnkLogin)

        btn.setOnClickListener {
            if (fullName.text.isNotEmpty() && txtUsername.text.isNotEmpty() && password.text.isNotEmpty()) {
                viewModel.insertUser(UserModel(0, fullName.text.toString(), txtUsername.text.toString(), password.text.toString(), true))
                findNavController().navigate(R.id.action_registerFragment_to_signInFragment)
            }else {
                Toast.makeText(requireContext(), "Fields cannot be Empty", Toast.LENGTH_LONG).show()
            }
        }

        linkLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_signInFragment)
        }
        onClick()
    }

    private fun onClick() {

    }

}