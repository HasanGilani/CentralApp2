package com.example.centralapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        val number1EditText: EditText = view.findViewById(R.id.number1)
        val number2EditText: EditText = view.findViewById(R.id.number2)
        val operationSpinner: Spinner = view.findViewById(R.id.operation)
        val calculateButton: Button = view.findViewById(R.id.calculate)
        val resultTextView: TextView = view.findViewById(R.id.result)

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDoubleOrNull()
            val number2 = number2EditText.text.toString().toDoubleOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (number1 != null && number2 != null) {
                val result = when (operation) {
                    "Addition" -> number1 + number2
                    "Subtraction" -> number1 - number2
                    "Multiplication" -> number1 * number2
                    "Division" -> {
                        if (number2 != 0.0) {
                            number1 / number2
                        } else {
                            "Cannot divide by zero"
                        }
                    }
                    else -> "Invalid operation"
                }
                resultTextView.text = result.toString()
            } else {
                resultTextView.text = "Please enter valid numbers"
            }
        }

        return view
    }
}