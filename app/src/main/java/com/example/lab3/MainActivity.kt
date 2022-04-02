package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lab3.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity(), SwitchFragment {

    private lateinit var binding: ActivityMainBinding
    private var fragmentList: List<Fragment> = listOf(StartFragment(), SecondFragment(), ThirdFragment(), FourthFragment())
    private var btnList: MutableList<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnList.add(0, binding.titleBtn1)
        btnList.add(1, binding.titleBtn2)
        btnList.add(2, binding.titleBtn3)
        btnList.add(3, binding.titleBtn4)

        checkEnabledBtn()
    }

    private fun checkEnabledBtn() {
        if (fragmentList.size != btnList.size) return
        for (i in fragmentList.indices) {
            if (i != 0) btnList[i].isEnabled = false
            btnList[i].setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentList[i]).commit()
            }
        }
    }
    override fun nextFragment(check: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentList[check+1]).commit()
        enabledBtn(check+1)
    }
    override fun prevFragment(check: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentList[check-1]).commit()
    }
    private fun enabledBtn(check: Int) {
        for (i in 0..check) {
            btnList[i].isEnabled = true
        }
    }
}

interface SwitchFragment {
    fun nextFragment(check: Int)
    fun prevFragment(check: Int)
}