package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }
    }

    private fun calculateLoan() {
        if(editTextCarPrice.text.isEmpty()) {
            editTextCarPrice.setError(getString(R.string.input_error))
            return
        }
        if(editTextDownPayment.text.isEmpty()) {
            editTextDownPayment.setError(getString(R.string.input_error))
            return
        }
        val carPrice: Int = editTextCarPrice.text.toString().toInt()

        if(editTextDownPayment.text.isEmpty()) {
            editTextDownPayment.setError(getString(R.string.input_error))
            return
        }
        val downPayment: Int = editTextDownPayment.text.toString().toInt()

        if(editTextLoanPeriod.text.isEmpty()) {
            editTextLoanPeriod.setError(getString(R.string.input_error))
            return
        }
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()

        if(editTextInterestRate.text.isEmpty()) {
            editTextInterestRate.setError(getString(R.string.input_error))
            return
        }
        val interestRate: Float = editTextInterestRate.text.toString().toFloat()

        val carLoan: Int = carPrice - downPayment
        val interest: Float = carLoan * interestRate * loanPeriod
        val monthlyRepayment: Float = (carLoan + interest) / loanPeriod / 12

        val currency = Currency.getInstance(Locale.getDefault())

        textViewLoan.text = String.format("Loan : %3s %d", currency, carLoan)
        textViewInterest.text = String.format("Interest : %3s %.2f", currency, interest)
        textViewMonthlyRepayment.text = String.format("Monthly Repayment : %3s %.2f", currency, monthlyRepayment)
    }

    fun reset(view: View) {
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextLoanPeriod.text = null
        editTextInterestRate.text = null
        textViewLoan.text = "Loan :"
        textViewInterest.text = "Interest :"
        textViewMonthlyRepayment.text = "Monthly Repayment :"
    }
}
