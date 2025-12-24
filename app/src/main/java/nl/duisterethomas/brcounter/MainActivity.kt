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

        val buttonToggleGroup1 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup1)
        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val buttonToggleGroup2 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup2)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val buttonToggleGroup3 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup3)
        val checkbox3 = findViewById<CheckBox>(R.id.checkbox3)
        val buttonToggleGroup4 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup4)
        val checkbox4 = findViewById<CheckBox>(R.id.checkbox4)
        val buttonToggleGroup5 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup5)
        val checkbox5 = findViewById<CheckBox>(R.id.checkbox5)
        val buttonToggleGroup6 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup6)
        val checkbox6 = findViewById<CheckBox>(R.id.checkbox6)
        val buttonToggleGroup7 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup7)
        val checkbox7 = findViewById<CheckBox>(R.id.checkbox7)
        val buttonToggleGroup8 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup8)
        val checkbox8 = findViewById<CheckBox>(R.id.checkbox8)

        var blankCount = 0
        var liveCount = 0
        var currentShot = 0

        fun shellShot(live: Boolean) {
            currentShot ++

            when (currentShot) {
                1 -> {
                    checkbox1.isChecked = true
                    buttonToggleGroup1.check(if (live) { R.id.buttonLive1 } else { R.id.buttonBlank1 })
                    buttonToggleGroup1.isEnabled = false
                }
                2 -> {
                    checkbox2.isChecked = true
                    buttonToggleGroup2.check(if (live) { R.id.buttonLive2 } else { R.id.buttonBlank2 })
                    buttonToggleGroup2.isEnabled = false
                }
                3 -> {
                    checkbox3.isChecked = true
                    buttonToggleGroup3.check(if (live) { R.id.buttonLive3 } else { R.id.buttonBlank3 })
                    buttonToggleGroup3.isEnabled = false
                }
                4 -> {
                    checkbox4.isChecked = true
                    buttonToggleGroup4.check(if (live) { R.id.buttonLive4 } else { R.id.buttonBlank4 })
                    buttonToggleGroup4.isEnabled = false
                }
                5 -> {
                    checkbox5.isChecked = true
                    buttonToggleGroup5.check(if (live) { R.id.buttonLive5 } else { R.id.buttonBlank5 })
                    buttonToggleGroup5.isEnabled = false
                }
                6 -> {
                    checkbox6.isChecked = true
                    buttonToggleGroup6.check(if (live) { R.id.buttonLive6 } else { R.id.buttonBlank6 })
                    buttonToggleGroup6.isEnabled = false
                }
                7 -> {
                    checkbox7.isChecked = true
                    buttonToggleGroup7.check(if (live) { R.id.buttonLive7 } else { R.id.buttonBlank7 })
                    buttonToggleGroup7.isEnabled = false
                }
                8 -> {
                    checkbox8.isChecked = true
                    buttonToggleGroup8.check(if (live) { R.id.buttonLive8 } else { R.id.buttonBlank8 })
                    buttonToggleGroup8.isEnabled = false
                }
            }
        }

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
                    shellShot(false)
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
                    shellShot(true)
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
                buttonToggleGroup1.isEnabled = true
                buttonToggleGroup1.clearChecked()
                checkbox1.isChecked = false

                buttonToggleGroup2.isEnabled = true
                buttonToggleGroup2.clearChecked()
                checkbox2.isChecked = false

                buttonToggleGroup3.isEnabled = true
                buttonToggleGroup3.clearChecked()
                checkbox3.isChecked = false

                buttonToggleGroup4.isEnabled = true
                buttonToggleGroup4.clearChecked()
                checkbox4.isChecked = false

                buttonToggleGroup5.isEnabled = true
                buttonToggleGroup5.clearChecked()
                checkbox5.isChecked = false

                buttonToggleGroup6.isEnabled = true
                buttonToggleGroup6.clearChecked()
                checkbox6.isChecked = false

                buttonToggleGroup7.isEnabled = true
                buttonToggleGroup7.clearChecked()
                checkbox7.isChecked = false

                buttonToggleGroup8.isEnabled = true
                buttonToggleGroup8.clearChecked()
                checkbox8.isChecked = false

                //Reset current shot
                currentShot = 0
            }
    }
}