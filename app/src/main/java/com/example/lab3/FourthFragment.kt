package com.example.lab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab3.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    private lateinit var binding: FragmentFourthBinding
    private var check = 3
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        binding.result.text = MainFragment.result().toString()
        prevBtnClick()

        val view: View = binding.root
        return view
    }

    private fun prevBtnClick(){
        binding.prevBtn4.setOnClickListener {
            val switchFragment = requireActivity() as SwitchFragment
            switchFragment.prevFragment(check)
        }
    }
}