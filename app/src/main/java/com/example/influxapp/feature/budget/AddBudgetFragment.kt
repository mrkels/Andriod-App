package com.example.influxapp.feature.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.influxapp.R
import com.example.influxapp.database.models.Expense
import com.example.influxapp.feature.ExpenseViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBudgetFragment: Fragment() {

    private lateinit var addTransactionBtn: Button

    private lateinit var closeBtn: ImageButton
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var amountLayout: TextInputLayout
    private lateinit var labelLayout: TextInputLayout
    private lateinit var amountInput: TextInputEditText
    private lateinit var labelInput: TextInputEditText

    private val viewModel: ExpenseViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_budget, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        descriptionInput = view.findViewById(R.id.descriptionInput)
        labelInput = view.findViewById(R.id.labelInput)
        labelLayout = view.findViewById(R.id.labelLayout)
        amountInput = view.findViewById(R.id.amountInput)
        amountLayout = view.findViewById(R.id.amountLayout)
        closeBtn = view.findViewById(R.id.closeBtn)
        addTransactionBtn = view.findViewById(R.id.addTransactionBtn)

        labelInput.addTextChangedListener {
            if(it!!.isNotEmpty())
                labelLayout.error = null
        }

        amountInput.addTextChangedListener {
            if(it!!.isNotEmpty())
                amountLayout.error = null
        }

        addTransactionBtn.setOnClickListener {
            val label = labelInput.text.toString()
            val description = descriptionInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                labelLayout.error = "Please enter a valid label"

            else if(amount == null)
                amountLayout.error = "Please enter a valid amount"
            else {
                val finalAmount = Math.abs(amount)
                val expenses  = Expense(0, label, finalAmount, description)
                viewModel.insertExpense(expenses)
                findNavController().navigateUp()
            }
        }

        closeBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}