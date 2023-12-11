package com.example.stacker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

@SuppressLint("WrongViewCast")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var stacks: Int
        var outputChest: Int
        var outputStacks: Int
        var outputPieces: Int
        val outputChestText: TextView = findViewById(R.id.outputChest)
        val outputStacksText: TextView = findViewById(R.id.outputStacks)
        val outputPiecesText: TextView = findViewById(R.id.outputPieces)

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        val switch: Switch = findViewById(R.id.switch2)
        val buttonResultPieces: Button = findViewById(R.id.buttonResultPieces)
        val editTextPieces: EditText = findViewById(R.id.editTextNumber)

        buttonResultPieces.setOnClickListener {
            if (switch.isChecked) {
                stacks = 16
            }else {
                stacks = 64
            }
            val pieces = Integer.parseInt(editTextPieces.text.toString())
            val chest = stacks * 27
            //расчёт количества сундуков
            outputChest = pieces / (27 * stacks)
            outputChestText.text = outputChest.toString()

            //расчёт количества стаков
            outputStacks = (pieces - (outputChest * chest)) / stacks
            outputStacksText.text = outputStacks.toString()

            //расчёт количества штук
            outputPieces = (pieces - ((outputChest * chest) + (outputStacks * stacks))) % stacks
            outputPiecesText.text = outputPieces.toString()
        }
    }
}