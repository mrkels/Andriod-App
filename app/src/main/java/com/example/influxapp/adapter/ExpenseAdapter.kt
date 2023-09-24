package com.example.influxapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.influxapp.R
import com.example.influxapp.database.models.Expense

class ExpenseAdapter(private var listener: (Expense) -> Unit) :
RecyclerView.Adapter<ExpenseAdapter.ExpenseHolder>() {

    private var expenses: List<Expense> = mutableListOf()

    class ExpenseHolder(view: View) : RecyclerView.ViewHolder(view) {
        val label : TextView = view.findViewById(R.id.label)
        val amount : TextView = view.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expenses_layout, parent, false)
        return ExpenseHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseHolder, position: Int) {
        val expense = expenses[position]
        val context = holder.amount.context

        if (expense.amount >= 0) {
            holder.amount.text = "+ $%.2f".format(expense.amount)
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.green))
        } else {
            holder.amount.text = "- $%.2f".format(Math.abs(expense.amount))
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.red))
        }

        holder.label.text = expense.name

        holder.itemView.setOnClickListener {
            listener(expenses[position])
            //To details

        }
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    fun setData(expenses: List<Expense>){
        this.expenses = expenses
        notifyDataSetChanged()
    }
}