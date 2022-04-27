package com.wemlart.janken

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class ResultFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Fragment を使った Nav Controller の取得
        val navController = this.findNavController()
        view.findViewById<Button>(R.id.result2TitleButton).setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_titleFragment)
        }
        view.findViewById<Button>(R.id.playAgainButton).setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_gameFragment)
        }
    }
}