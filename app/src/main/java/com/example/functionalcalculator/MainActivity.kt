package com.example.functionalcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOne.setOnClickListener { appendOnExpression("1",true)   }
        tvTwo.setOnClickListener { appendOnExpression("2",true) }
        tvThree.setOnClickListener { appendOnExpression("3",true) }
        tvFour.setOnClickListener { appendOnExpression("4",true) }
        tvFive.setOnClickListener { appendOnExpression("5",true) }
        tvSix.setOnClickListener { appendOnExpression("6",true) }
        tvSeven.setOnClickListener { appendOnExpression("7",true) }
        tvEight.setOnClickListener { appendOnExpression("8",true) }
        tvNine.setOnClickListener { appendOnExpression("9",true) }
        tvZero.setOnClickListener { appendOnExpression("0",true) }
        tvDot.setOnClickListener { appendOnExpression(".",true) }


        tvPlus.setOnClickListener { appendOnExpression("+",false) }
        tvMinus.setOnClickListener { appendOnExpression("-",false) }
        tvMultiply.setOnClickListener { appendOnExpression("*",false) }
        tvDivide.setOnClickListener { appendOnExpression("/",false) }
        tvOpen.setOnClickListener { appendOnExpression("(",false) }
        tvClose.setOnClickListener { appendOnExpression(")",false) }

        tvClear.setOnClickListener { tvExpression.text=""
        tvResult.text=""}

        tvBack.setOnClickListener {
            val String =tvExpression.text.toString()
            if (String.isNotEmpty()){
                tvExpression.text = String.substring(0,String.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            val String =tvExpression.text.toString()
        }
        tvEquals.setOnClickListener { 
            try{
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()
            }catch (e:Exception){
                Log.d("Exception", "Message :" + e.message)
            }
        }


    }

    fun appendOnExpression( String : String, canClear : Boolean){


        if (tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if(canClear){
            tvResult.text=""
            tvExpression.append(String)
        }else{
            tvExpression.append(tvResult.text)
            tvExpression.append(String)
            tvResult.text=""
        }

    }
}