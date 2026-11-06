package com.example.threadhandlerwizard

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ProgressFragment : Fragment(R.layout.frag_progress) {

    private val vm: WorkViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bar = view.findViewById<ProgressBar>(R.id.progressBar)
        val percent = view.findViewById<TextView>(R.id.txtPercent)
        val status = view.findViewById<TextView>(R.id.txtStatus)

        vm.progress.observe(viewLifecycleOwner) { p ->
            bar.progress = p
            percent.text = getString(R.string.percent_format, p)
        }
        vm.status.observe(viewLifecycleOwner) { s ->
            status.text = s
        }
    }
}
