package com.example.influxapp.feature.financialgoal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.influxapp.R
import com.example.influxapp.adapter.ExpenseAdapter
import com.example.influxapp.adapter.GoalAdapter
import com.example.influxapp.database.models.Expense
import com.example.influxapp.database.models.Goals
import com.example.influxapp.feature.ExpenseViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FinancialGoalFragment : Fragment() {

    private lateinit var deletedGoal: Goals
    private lateinit var goals : List<Goals>
    private lateinit var oldGoals : List<Goals>


    private val viewModel: ExpenseViewModel by viewModels()

    private lateinit var recyclerview: RecyclerView
    private lateinit var btnDashboard: Button
    private lateinit var addBtnGoal: Button

    private val goalAdapter = GoalAdapter { str -> gotoDetailScreen(str) }

    private fun gotoDetailScreen(goal: Goals) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_financial_goal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goals = arrayListOf()

        recyclerview = view.findViewById(R.id.recyclerview)
        btnDashboard = view.findViewById(R.id.btnDashboard)
        addBtnGoal = view.findViewById(R.id.addBtnGoal)


        initializedRecyclerview()
        setObserver()


        btnDashboard.setOnClickListener {
            findNavController().navigate(R.id.action_financialGoalFragment_to_homeFragment)
        }

        addBtnGoal.setOnClickListener {
            findNavController().navigate(R.id.action_financialGoalFragment_to_addFinancialGoalFragment)
        }

    }

    private fun initializedRecyclerview(){
        recyclerview.apply {
            adapter = goalAdapter
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
                deleteTransaction(goals[viewHolder.bindingAdapterPosition])
            }

        }

        val swipeHelper = ItemTouchHelper(itemTouchHelper)
        swipeHelper.attachToRecyclerView(recyclerview)
    }


    private fun setObserver() {
        viewModel.fetchGoals().observe(viewLifecycleOwner, Observer {
            goals = it
            goalAdapter.setData(it)
        })
    }


    private fun deleteTransaction(goal: Goals){
        deletedGoal = goal
        oldGoals = goals

        GlobalScope.launch {
            viewModel.deleteGoal(goal)

            goals = goals.filter { it.id != goal.id }
            requireActivity().runOnUiThread {
                goalAdapter.setData(goals)
                showSnackbar()
            }
        }
    }


    private fun showSnackbar(){
        val view = requireActivity().findViewById<View>(R.id.coordinator)
        val snackbar = Snackbar.make(view, "Transaction deleted!", Snackbar.LENGTH_LONG)
        snackbar.setAction("Undo"){
            undoDelete()
        }
            .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.red))
            .setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            .show()
    }

    private fun undoDelete(){
        GlobalScope.launch {
            viewModel.insertGoal(deletedGoal)

            goals = oldGoals

            requireActivity().runOnUiThread {
                goalAdapter.setData(goals)
            }
        }
    }


}