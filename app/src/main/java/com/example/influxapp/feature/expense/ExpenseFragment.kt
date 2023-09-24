package com.example.influxapp.feature.expense

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.influxapp.R
import com.example.influxapp.database.models.Expense
import com.example.influxapp.feature.ExpenseViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpenseFragment : Fragment() {


    private lateinit var updateBtn: Button
    private lateinit var rootView: ConstraintLayout

    private lateinit var closeBtn: ImageButton
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var amountLayout: TextInputLayout
    private lateinit var labelLayout: TextInputLayout
    private lateinit var amountInput: TextInputEditText
    private lateinit var labelInput: TextInputEditText

    private val viewModel: ExpenseViewModel by viewModels()

    private lateinit var expense: Expense

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expense = (arguments?.getParcelable("expense") as? Expense)!!

        descriptionInput = view.findViewById(R.id.descriptionInput)
        labelInput = view.findViewById(R.id.labelInput)
        labelLayout = view.findViewById(R.id.labelLayout)
        amountInput = view.findViewById(R.id.amountInput)
        amountLayout = view.findViewById(R.id.amountLayout)
        closeBtn = view.findViewById(R.id.closeBtn)
        updateBtn = view.findViewById(R.id.updateBtn)
        rootView = view.findViewById(R.id.rootView)

        labelInput.setText(expense.name)
        amountInput.setText(expense.amount.toString())
        descriptionInput.setText(expense.description)


        rootView.setOnClickListener {
            requireActivity().window.decorView.clearFocus()

            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }

        labelInput.addTextChangedListener {
            updateBtn.visibility = View.VISIBLE
            if(it!!.isNotEmpty())
                labelLayout.error = null
        }

        amountInput.addTextChangedListener {
            updateBtn.visibility = View.VISIBLE
            if(it!!.count() > 0)
                amountLayout.error = null
        }

        descriptionInput.addTextChangedListener {
            updateBtn.visibility = View.VISIBLE
        }

        updateBtn.setOnClickListener {
            val label = labelInput.text.toString()
            val description = descriptionInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                labelLayout.error = "Please neter a valid label"

            else if(amount == null)
                amountLayout.error = "Please enter a valid amount"
            else {
                val finalAmount = (Math.abs(amount) * -1.0)
                val expense  = Expense(expense.id, label, finalAmount, description)
                viewModel.update(expense)
                findNavController().navigateUp()
            }
        }

        closeBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}