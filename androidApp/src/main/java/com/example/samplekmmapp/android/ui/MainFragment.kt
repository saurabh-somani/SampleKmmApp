package com.example.samplekmmapp.android.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.samplekmmapp.android.databinding.FragmentMainBinding
import com.example.samplekmmapp.android.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainViewModel", "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainViewModel", "onStop: ")
    }
}