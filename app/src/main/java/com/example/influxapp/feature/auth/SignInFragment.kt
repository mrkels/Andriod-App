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
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.influxapp.HomeActivity
import com.example.influxapp.R
import com.example.influxapp.feature.ExpenseViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignInFragment : Fragment() {

    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtUsername = view.findViewById<EditText>(R.id.txtUsername)

        val txtPwd = view.findViewById<EditText>(R.id.txtPwd)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        val lnkRegister = view.findViewById<TextView>(R.id.lnkRegister)

        btnLogin.setOnClickListener {
            if (txtUsername.text.isNotEmpty() && txtPwd.text.isNotEmpty()) {
                viewModel.checkUser(txtUsername.text.toString().trim(), txtPwd.text.toString().trim()).observe(viewLifecycleOwner, Observer {
                    if (it){
                        val intent = Intent(requireContext(), HomeActivity::class.java)
                        intent.putExtra("username", txtUsername.text.toString())
                        startActivity(intent)
                    }else{
                        Toast.makeText(requireContext(), "Please try again, \nUsername Or Password Incorrect", Toast.LENGTH_LONG).show()
                    }
                })
            }else {
                Toast.makeText(requireContext(), "Fields cannot be Empty", Toast.LENGTH_LONG).show()
            }
        }


        lnkRegister.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_registerFragment)
        }
    }

}