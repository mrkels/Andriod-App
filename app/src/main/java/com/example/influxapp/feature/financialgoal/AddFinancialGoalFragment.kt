package com.example.influxapp.feature.financialgoal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.influxapp.R
import com.example.influxapp.database.models.Expense
import com.example.influxapp.database.models.Goals
import com.example.influxapp.feature.ExpenseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFinancialGoalFragment : Fragment() {

    private lateinit var closeBtn: ImageButton
    private lateinit var saveButton: Button

    private lateinit var goalNameEditText: EditText

    private lateinit var goalAmountEditText: EditText

    private lateinit var targetDateEditText: EditText

    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_financial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeBtn = view.findViewById(R.id.closeBtn)
        saveButton = view.findViewById(R.id.saveButton)

        goalNameEditText = view.findViewById(R.id.goalNameEditText)

        goalAmountEditText = view.findViewById(R.id.goalAmountEditText)

        targetDateEditText = view.findViewById(R.id.targetDateEditText)

        saveButton.setOnClickListener {
            val label = goalNameEditText.text.toString()
            val date = targetDateEditText.text.toString()
            val amount = goalAmountEditText.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                goalNameEditText.error = "Please enter a valid label"

            else if(amount == null)
                goalAmountEditText.error = "Please enter a valid amount"
            else {
                val finalAmount = Math.abs(amount)
                val goal  = Goals(0, label, finalAmount, date)
                viewModel.insertGoal(goal)
                findNavController().navigateUp()
            }
        }

        closeBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}