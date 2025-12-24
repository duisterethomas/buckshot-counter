package nl.duisterethomas.brcounter

import android.os.Bundle
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Keep screen on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val textViewBlank = findViewById<TextView>(R.id.textViewBlank)
        val textViewLive = findViewById<TextView>(R.id.textViewLive)

        var blankCount = 0
        var liveCount = 0

        //Link the counter buttons
        findViewById<MaterialButton>(R.id.buttonPlusBlank)
            .setOnClickListener {
                blankCount ++
                textViewBlank.text = blankCount.toString()
            }

        findViewById<MaterialButton>(R.id.buttonMinusBlank)
            .setOnClickListener {
                if (blankCount != 0) {
                    blankCount --
                    textViewBlank.text = blankCount.toString()
                }
            }
        findViewById<MaterialButton>(R.id.buttonPlusLive)
            .setOnClickListener {
                liveCount ++
                textViewLive.text = liveCount.toString()
            }

        findViewById<MaterialButton>(R.id.buttonMinusLive)
            .setOnClickListener {
                if (liveCount != 0) {
                    liveCount --
                    textViewLive.text = liveCount.toString()
                }
            }

        //Link the clear button
        findViewById<MaterialButton>(R.id.buttonClear)
            .setOnClickListener {
                //Reset counters
                blankCount = 0
                liveCount = 0
                textViewBlank.text = blankCount.toString()
                textViewLive.text = liveCount.toString()

                //Reset known shells
                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup1)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox1).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup2)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox2).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup3)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox3).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup4)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox4).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup5)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox5).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup6)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox6).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup7)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox7).isChecked = false

                findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup8)
                    .clearChecked()
                findViewById<CheckBox>(R.id.checkbox8).isChecked = false
            }
    }
}