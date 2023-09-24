package com.example.influxapp.feature.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influxapp.R
import com.example.influxapp.adapter.ExpenseAdapter
import com.example.influxapp.database.models.Expense
import com.example.influxapp.feature.ExpenseViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment: Fragment() {


    private lateinit var txt_user: TextView
    private lateinit var deletedExpense: Expense
    private lateinit var expenses : List<Expense>
    private lateinit var oldExpenses : List<Expense>

    private lateinit var expense: TextView
    private lateinit var budget: TextView
    private lateinit var balance: TextView
    private lateinit var addBtnExpense: Button
    private lateinit var addBtnBudget: Button
    private lateinit var btnGamification: Button
    private lateinit var btnFinancialGoal: Button
    private lateinit var btnInsight: Button

    private var userName = ""


    private val viewModel: ExpenseViewModel by viewModels()

    private lateinit var recyclerview: RecyclerView

    private val expensesAdapter = ExpenseAdapter { str -> gotoDetailScreen(str) }

    private fun gotoDetailScreen(expense: Expense) {
        Bundle().apply {
            putParcelable("expense", expense)
            if (expense.amount < 0) {
                findNavController().navigate(R.id.action_homeFragment_to_expenseFragment, this)
            }else{
                findNavController().navigate(R.id.action_homeFragment_to_budgetFragment, this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userName = requireActivity().intent?.getStringExtra("username").toString()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        expenses = arrayListOf()

        balance = view.findViewById(R.id.balance)
        budget = view.findViewById(R.id.budget)
        expense = view.findViewById(R.id.expense)
        txt_user = view.findViewById(R.id.txt_user)
        recyclerview = view.findViewById(R.id.recyclerview)
        addBtnBudget = view.findViewById(R.id.addBtnBudget)
        addBtnExpense = view.findViewById(R.id.addBtnExpense)

        btnGamification = view.findViewById(R.id.btnGamification)
        btnFinancialGoal = view.findViewById(R.id.btnFinancialGoal)
        btnInsight = view.findViewById(R.id.btnInsight)

        txt_user.text = userName
        initializedRecyclerview()
        setObserver()

        addBtnExpense.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addExpenseFragment)
        }

        addBtnBudget.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addBudgetFragment)
        }

        btnGamification.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gamificationFragment)
        }

        btnFinancialGoal.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_financialGoalFragment)
        }

        btnInsight.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_insightAnalyticsFragment)
        }
    }

    private fun setObserver() {
        viewModel.fetchExpenses().observe(viewLifecycleOwner, Observer {
            expenses = it
            updateDashboard()
            expensesAdapter.setData(it)
        })
    }

    private fun updateDashboard(){
        val totalAmount = expenses.map { it.amount }.sum()
        val budgetAmount = expenses.filter { it.amount>0 }.map{it.amount}.sum()
        val expenseAmount = totalAmount - budgetAmount

        balance.text = "$ %.2f".format(totalAmount)
        budget.text = "$ %.2f".format(budgetAmount)
        expense.text = "$ %.2f".format(expenseAmount)
    }


    private fun initializedRecyclerview(){
        recyclerview.apply {
            adapter = expensesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        // swipe to remove
        val itemTouchHelper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                deleteTransaction(expenses[viewHolder.bindingAdapterPosition])
            }

        }

        val swipeHelper = ItemTouchHelper(itemTouchHelper)
        swipeHelper.attachToRecyclerView(recyclerview)
    }

    private fun deleteTransaction(expense: Expense){
        deletedExpense = expense
        oldExpenses = expenses

        GlobalScope.launch {
            viewModel.deleteExpense(expense)

            expenses = expenses.filter { it.id != expense.id }
            requireActivity().runOnUiThread {
                updateDashboard()
                expensesAdapter.setData(expenses)
                showSnackbar()
            }
        }
    }


    private fun showSnackbar(){
        val view = requireActivity().findViewById<View>(R.id.coordinator)
        val snackbar = Snackbar.make(view, "Transaction deleted!",Snackbar.LENGTH_LONG)
        snackbar.setAction("Undo"){
            undoDelete()
        }
            .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            .setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            .show()
    }

    private fun undoDelete(){
        GlobalScope.launch {
            viewModel.insertExpense(deletedExpense)

            expenses = oldExpenses

            requireActivity().runOnUiThread {
                expensesAdapter.setData(expenses)
                updateDashboard()
            }
        }
    }
}