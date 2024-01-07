package com.example.simple_calc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simple_calc_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        actionsBtns()

    }
    fun actionsBtns() {

        binding.btn1.setOnClickListener { mainTextActions("1") }
        binding.btn2.setOnClickListener { mainTextActions ("2") }
        binding.btn3.setOnClickListener { mainTextActions ("3") }
        binding.btn4.setOnClickListener { mainTextActions ("4") }
        binding.btn5.setOnClickListener { mainTextActions ("5") }
        binding.btn6.setOnClickListener { mainTextActions ("6") }
        binding.btn7.setOnClickListener { mainTextActions ("7") }
        binding.btn8.setOnClickListener { mainTextActions ("8") }
        binding.btn9.setOnClickListener { mainTextActions ("9") }
        binding.btnNull.setOnClickListener { mainTextActions ("0") }

        binding.btnPlus.setOnClickListener { mainTextActions ("+") }
        binding.btnPercent.setOnClickListener { mainTextActions ("%") }
        binding.btnMinus.setOnClickListener { mainTextActions ("-") }
        binding.btnMultipl.setOnClickListener { mainTextActions ("*") }
        binding.btnDot.setOnClickListener { mainTextActions (".") }
        binding.btnDevision.setOnClickListener { mainTextActions ("/") }

        binding.btnBackspace.setOnClickListener { btnBackspaceAction() }
    }

    fun mainTextActions(str: String){
        binding.mainText.append(str)
    }

    fun btnBackspaceAction (){
        binding.btnBackspace.setOnClickListener {
            val textMainVeiw = binding.mainText.text.toString()
            if (textMainVeiw.isNotEmpty()){
                binding.mainText.text = textMainVeiw.substring(0, textMainVeiw.length -1)
                binding.historyText.text = ""
            }
        }
    }

    fun calculatelogic() {

    }


}




