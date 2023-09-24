package com.example.influxapp.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.influxapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsightAnalyticsFragment: Fragment(){

    private lateinit var closeBtn: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.insightsandanalytics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        closeBtn = view.findViewById(R.id.closeBtn)

        closeBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}