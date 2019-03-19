package com.example.mhz.smartpark

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.example.mhz.smartpark.model.Calculator
import com.example.mhz.smartpark.model.SubscriptionType
import java.text.NumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // activity layout
        setContentView(R.layout.activity_main)

        // initialize the calculator
        val calculator = Calculator()

        val calculateButton = findViewById<Button>(R.id.CalculateButton)
        val initButton = findViewById<Button>(R.id.initButton)

        //initialize the periods radiogroup
        val radioGroup = findViewById<RadioGroup>(R.id.RadioButtons)

        val carNumberEditText = findViewById<EditText>(R.id.CarNumber)

        val price = findViewById<EditText>(R.id.Price)
        val result = findViewById<TextView>(R.id.AmountResult)
        val resultTaxe = findViewById<TextView>(R.id.AmountResultTaxe)

        //price oversight
        price.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                when {
                    price.text.toString().length == 1 -> price.setText((price.text.toString().toInt() * 1000).toString())
                    price.text.toString().length == 2 -> price.setText((price.text.toString().toInt() * 100).toString())
                }
            }

        }

        fun calculate() {
            if (carNumberEditText.text.toString().isEmpty() || price.text.toString().isEmpty()) {
                Toast.makeText(this, "Champs vide !!", Toast.LENGTH_SHORT).show()
                return
            }

            val carNumber = carNumberEditText.text.toString().toLong()
            val unitaryPlacePrice = price.text.toString().toLong()
            val subscriptionType = SubscriptionType.fromLabel(findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString())

            val amount = calculator.calculateAmount(subscriptionType, unitaryPlacePrice, carNumber)

            result.text = (NumberFormat.getNumberInstance(Locale.US).format(amount))
            resultTaxe.text = (NumberFormat.getNumberInstance(Locale.US).format(amount * 1.19))
        }

        radioGroup.setOnCheckedChangeListener({ radio_group, _ ->
            val radio: RadioButton = findViewById(radio_group.checkedRadioButtonId)
            calculate()
            Toast.makeText(applicationContext, "${radio.text}", Toast.LENGTH_SHORT).show()

        })

        calculateButton.setOnClickListener({
            calculate()
        })

        initButton.setOnClickListener({
            carNumberEditText.setText("0")
            price.setText("0")

            result.text = "0"
            resultTaxe.text = "0"
        })
    }
}
