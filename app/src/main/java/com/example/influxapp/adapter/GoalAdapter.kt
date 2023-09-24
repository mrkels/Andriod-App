package com.example.influxapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.influxapp.R
import com.example.influxapp.database.models.Expense
import com.example.influxapp.database.models.Goals

class GoalAdapter(private var listener: (Goals) -> Unit) :
    RecyclerView.Adapter<GoalAdapter.GoalHolder>() {

    private var goals: List<Goals> = mutableListOf()

    class GoalHolder(view: View) : RecyclerView.ViewHolder(view) {
        val label : TextView = view.findViewById(R.id.label)
        val amount : TextView = view.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expenses_layout, parent, false)
        return GoalHolder(view)
    }

    override fun onBindViewHolder(holder: GoalHolder, position: Int) {
        val goal = goals[position]
        val context = holder.amount.context

        holder.amount.text = "${goal.date}\t $%.2f".format(goal.amount)

        holder.label.text = goal.name

        holder.itemView.setOnClickListener {
            listener(goals[position])
            //To details
        }
    }

    override fun getItemCount(): Int {
        return goals.size
    }

    fun setData(goals: List<Goals>){
        this.goals = goals
        notifyDataSetChanged()
    }
}