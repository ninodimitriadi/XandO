package com.example.myapplicationxando

import android.content.DialogInterface
import android.graphics.Color
import android.icu.text.RelativeDateTimeFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button

    private lateinit var resetButton: Button

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    var winnerPlayer = 0
    private var allmoves = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private  fun init(){

        Button1 = findViewById(R.id.Button1)
        Button2 = findViewById(R.id.Button2)
        Button3 = findViewById(R.id.Button3)
        Button4 = findViewById(R.id.Button4)
        Button5 = findViewById(R.id.Button5)
        Button6 = findViewById(R.id.Button6)
        Button7 = findViewById(R.id.Button7)
        Button8 = findViewById(R.id.Button8)
        Button9 = findViewById(R.id.Button9)

        resetButton = findViewById(R.id.resetButton)

        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)

        resetButton.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        if (clickedView is Button){

            var buttonNumber = 0

            when (clickedView.id){
                R.id.Button1 -> buttonNumber = 1
                R.id.Button2 -> buttonNumber = 2
                R.id.Button3 -> buttonNumber = 3
                R.id.Button4 -> buttonNumber = 4
                R.id.Button5 -> buttonNumber = 5
                R.id.Button6 -> buttonNumber = 6
                R.id.Button7 -> buttonNumber = 7
                R.id.Button8 -> buttonNumber = 8
                R.id.Button9 -> buttonNumber = 9

            }

            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }

            if (clickedView.id == R.id.resetButton){
                Button1.text = ""
                Button1.isEnabled = true
                Button1.setBackgroundColor(Color.rgb(98, 0, 238))
                Button2.text = ""
                Button2.isEnabled = true
                Button2.setBackgroundColor(Color.rgb(98, 0, 238))
                Button3.text = ""
                Button3.isEnabled = true
                Button3.setBackgroundColor(Color.rgb(98, 0, 238))
                Button4.text = ""
                Button4.isEnabled = true
                Button4.setBackgroundColor(Color.rgb(98, 0, 238))
                Button5.text = ""
                Button5.isEnabled = true
                Button5.setBackgroundColor(Color.rgb(98, 0, 238))
                Button6.text = ""
                Button6.isEnabled = true
                Button6.setBackgroundColor(Color.rgb(98, 0, 238))
                Button7.text = ""
                Button7.isEnabled = true
                Button7.setBackgroundColor(Color.rgb(98, 0, 238))
                Button8.text = ""
                Button8.isEnabled = true
                Button8.setBackgroundColor(Color.rgb(98, 0, 238))
                Button9.text = ""
                Button9.isEnabled = true
                Button9.setBackgroundColor(Color.rgb(98, 0, 238))

                winnerPlayer = 0
                activePlayer = 1
                firstPlayer.clear()
                secondPlayer.clear()
                allmoves = 0
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            allmoves += 1
            activePlayer = 2

        }else{
            clickedView.text = "O"
            clickedView.setBackgroundColor(Color.YELLOW)
            secondPlayer.add(buttonNumber)
            allmoves += 1
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check(){

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (allmoves == 9){
            Toast.makeText(this, "Tie", Toast.LENGTH_LONG).show()
        }
        if (winnerPlayer != 0){
            if (winnerPlayer == 1) {
                Toast.makeText(this, "X wins", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "O wins", Toast.LENGTH_LONG).show()
            }
             disableButtons()
        }


    }

    private fun disableButtons(){

        Button1.isEnabled = false
        Button2.isEnabled = false
        Button3.isEnabled = false
        Button4.isEnabled = false
        Button5.isEnabled = false
        Button6.isEnabled = false
        Button7.isEnabled = false
        Button8.isEnabled = false
        Button9.isEnabled = false

    }

}