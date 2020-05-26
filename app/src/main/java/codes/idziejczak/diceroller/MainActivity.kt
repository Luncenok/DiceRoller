package codes.idziejczak.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    private var randomInt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        setImageRes()

        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        rollButton.setOnClickListener { rollDice() }
        countUpButton.setOnClickListener { countUp() }
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
        randomInt = (1..6).random()
        setImageRes()
    }

    private fun countUp() {
        if (randomInt != 6) {
            randomInt++
            setImageRes()
        }
    }

    private fun reset() {
        randomInt = 0
        setImageRes()
    }

    private fun setImageRes() {
        val drawableResource = when (randomInt) {
            0 -> R.drawable.empty_dice
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}
