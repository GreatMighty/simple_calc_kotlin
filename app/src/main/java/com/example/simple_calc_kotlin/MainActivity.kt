package com.example.simple_calc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simple_calc_kotlin.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {


    private lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionsBtns()
        btnResult()
        btnAllClear()

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

        binding.btnPlus.setOnClickListener { if (binding.historyText.text.isNotEmpty()){mainTextActions ("+") }}
        binding.btnMinus.setOnClickListener { if (binding.historyText.text.isNotEmpty())mainTextActions ("-") }
        binding.btnMultipl.setOnClickListener { if (binding.historyText.text.isNotEmpty())mainTextActions ("*") }
        binding.btnDot.setOnClickListener { if (binding.historyText.text.isNotEmpty())mainTextActions (".") }
        binding.btnDevision.setOnClickListener { if (binding.historyText.text.isNotEmpty())mainTextActions ("/") }

        binding.btnBackspace.setOnClickListener { btnBackspaceAction() }
    }

    fun mainTextActions(str: String){
        binding.historyText.append(str)
    }

    fun btnBackspaceAction (){
        binding.btnBackspace.setOnClickListener {
            val textMainVeiw = binding.historyText.text.toString()
            if (textMainVeiw.isNotEmpty()){
                binding.mainText.text = ""
                binding.historyText.text = textMainVeiw.substring(0, textMainVeiw.length -1)
            }
        }
    }

    fun btnAllClear (){
        binding.btnAllClear.setOnClickListener {
            binding.mainText.text = ""
            binding.historyText.text = ""
        }
    }

    fun btnResult (){
        binding.btnResult.setOnClickListener {
            try {
                val ex = ExpressionBuilder(binding.historyText.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    binding.mainText.text = longRes.toString()
                else
                    binding.mainText.text = result.toString()

            }catch (e:Exception) {
                    Log.d("Ошибка", "Сообзение: ${e.message}")
            }
        }
    }
}




