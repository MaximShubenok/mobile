package com.example.lab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab3.databinding.FragmentSecondBinding

class  SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private var check = 1
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        nextBtnClick()
        prevBtnClick()

        val view: View = binding.root
        return view
    }

    private fun nextBtnClick() {
        binding.nextBtn2.setOnClickListener {
            val switchFragment = requireActivity() as SwitchFragment
            try {
                MainFragment.secondVal = binding.secondValue.text.toString().toDouble()
            }
            catch (e: Exception) {
                MainFragment.secondVal = null
            }
            switchFragment.nextFragment(check)
        }
    }

    private fun prevBtnClick(){
        binding.prevBtn2.setOnClickListener {
            val switchFragment = requireActivity() as SwitchFragment
            switchFragment.prevFragment(check)
        }
    }
}