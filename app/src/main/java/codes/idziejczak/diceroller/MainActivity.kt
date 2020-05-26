package codes.idziejczak.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "Hello World!") resultText.text = "1"
        else {
            val actualInt = resultText.text.toString().toInt()
            if (actualInt != 6) resultText.text = (actualInt + 1).toString()
        }
    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }
}
