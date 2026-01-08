package nl.duisterethomas.buckshotcounter

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.materialswitch.MaterialSwitch

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

        //Find all the elements
        val buttonPlus1 = findViewById<MaterialButton>(R.id.buttonPlus1)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val textViewCount1 = findViewById<TextView>(R.id.textViewCount1)
        val buttonMinus1 = findViewById<MaterialButton>(R.id.buttonMinus1)
        val buttonShot1 = findViewById<MaterialButton>(R.id.buttonShot1)

        val buttonPlus2 = findViewById<MaterialButton>(R.id.buttonPlus2)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textViewCount2 = findViewById<TextView>(R.id.textViewCount2)
        val buttonMinus2 = findViewById<MaterialButton>(R.id.buttonMinus2)
        val buttonShot2 = findViewById<MaterialButton>(R.id.buttonShot2)

        val buttonToggleGroup1 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup1)
        val button1_1 = findViewById<MaterialButton>(R.id.button1_1)
        val button2_1 = findViewById<MaterialButton>(R.id.button2_1)
        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val buttonToggleGroup2 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup2)
        val button1_2 = findViewById<MaterialButton>(R.id.button1_2)
        val button2_2 = findViewById<MaterialButton>(R.id.button2_2)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val buttonToggleGroup3 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup3)
        val button1_3 = findViewById<MaterialButton>(R.id.button1_3)
        val button2_3 = findViewById<MaterialButton>(R.id.button2_3)
        val checkbox3 = findViewById<CheckBox>(R.id.checkbox3)
        val buttonToggleGroup4 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup4)
        val button1_4 = findViewById<MaterialButton>(R.id.button1_4)
        val button2_4 = findViewById<MaterialButton>(R.id.button2_4)
        val checkbox4 = findViewById<CheckBox>(R.id.checkbox4)
        val buttonToggleGroup5 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup5)
        val button1_5 = findViewById<MaterialButton>(R.id.button1_5)
        val button2_5 = findViewById<MaterialButton>(R.id.button2_5)
        val checkbox5 = findViewById<CheckBox>(R.id.checkbox5)
        val buttonToggleGroup6 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup6)
        val button1_6 = findViewById<MaterialButton>(R.id.button1_6)
        val button2_6 = findViewById<MaterialButton>(R.id.button2_6)
        val checkbox6 = findViewById<CheckBox>(R.id.checkbox6)
        val buttonToggleGroup7 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup7)
        val button1_7 = findViewById<MaterialButton>(R.id.button1_7)
        val button2_7 = findViewById<MaterialButton>(R.id.button2_7)
        val checkbox7 = findViewById<CheckBox>(R.id.checkbox7)
        val buttonToggleGroup8 = findViewById<MaterialButtonToggleGroup>(R.id.buttonToggleGroup8)
        val button1_8 = findViewById<MaterialButton>(R.id.button1_8)
        val button2_8 = findViewById<MaterialButton>(R.id.button2_8)
        val checkbox8 = findViewById<CheckBox>(R.id.checkbox8)

        val switchSwapLiveBlank = findViewById<MaterialSwitch>(R.id.switchSwapLiveBlank)

        val buttonStart = findViewById<MaterialButton>(R.id.buttonStart)
        val buttonReset = findViewById<MaterialButton>(R.id.buttonReset)

        //Set the counters
        var blankCount = 0
        var liveCount = 0
        var currentShot = 0

        //Automatically show/hide shell rows
        fun updateShells() {
            val totalShells = blankCount + liveCount

            findViewById<LinearLayout>(R.id.shell1).visibility = if (totalShells >= 1) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell2).visibility = if (totalShells >= 2) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell3).visibility = if (totalShells >= 3) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell4).visibility = if (totalShells >= 4) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell5).visibility = if (totalShells >= 5) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell6).visibility = if (totalShells >= 6) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell7).visibility = if (totalShells >= 7) { View.VISIBLE } else { View.INVISIBLE }
            findViewById<LinearLayout>(R.id.shell8).visibility = if (totalShells >= 8) { View.VISIBLE } else { View.INVISIBLE }
        }

        //Auto note shot
        fun shellShot(live: Boolean) {
            when (currentShot) {
                1 -> {
                    checkbox1.isChecked = true
                    buttonToggleGroup1.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_1 } else { R.id.button2_1 })
                    buttonToggleGroup1.isEnabled = false
                }
                2 -> {
                    checkbox2.isChecked = true
                    buttonToggleGroup2.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_2 } else { R.id.button2_2 })
                    buttonToggleGroup2.isEnabled = false
                }
                3 -> {
                    checkbox3.isChecked = true
                    buttonToggleGroup3.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_3 } else { R.id.button2_3 })
                    buttonToggleGroup3.isEnabled = false
                }
                4 -> {
                    checkbox4.isChecked = true
                    buttonToggleGroup4.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_4 } else { R.id.button2_4 })
                    buttonToggleGroup4.isEnabled = false
                }
                5 -> {
                    checkbox5.isChecked = true
                    buttonToggleGroup5.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_5 } else { R.id.button2_5 })
                    buttonToggleGroup5.isEnabled = false
                }
                6 -> {
                    checkbox6.isChecked = true
                    buttonToggleGroup6.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_6 } else { R.id.button2_6 })
                    buttonToggleGroup6.isEnabled = false
                }
                7 -> {
                    checkbox7.isChecked = true
                    buttonToggleGroup7.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_7 } else { R.id.button2_7 })
                    buttonToggleGroup7.isEnabled = false
                }
                8 -> {
                    checkbox8.isChecked = true
                    buttonToggleGroup8.check(if (live xor switchSwapLiveBlank.isChecked) { R.id.button1_8 } else { R.id.button2_8 })
                    buttonToggleGroup8.isEnabled = false
                }
            }

            currentShot ++
        }

        //Link the counter buttons
        buttonPlus1
            .setOnClickListener {
                if (!switchSwapLiveBlank.isChecked) {
                    liveCount++
                    textViewCount1.text = liveCount.toString()
                } else {
                    blankCount++
                    textViewCount1.text = blankCount.toString()
                }
                updateShells()
                buttonMinus1.isEnabled = true
                buttonPlus1.isEnabled = (blankCount + liveCount) != 8
                buttonPlus2.isEnabled = (blankCount + liveCount) != 8
            }

        buttonMinus1
            .setOnClickListener {
                if (!switchSwapLiveBlank.isChecked) {
                    liveCount--
                    textViewCount1.text = liveCount.toString()
                    updateShells()
                    buttonMinus1.isEnabled = liveCount != 0
                } else {
                    blankCount--
                    textViewCount1.text = blankCount.toString()
                    updateShells()
                    buttonMinus1.isEnabled = blankCount != 0
                }
                buttonPlus1.isEnabled = true
                buttonPlus2.isEnabled = true
            }

        buttonPlus2
            .setOnClickListener {
                if (!switchSwapLiveBlank.isChecked) {
                    blankCount++
                    textViewCount2.text = blankCount.toString()
                } else {
                    liveCount++
                    textViewCount2.text = liveCount.toString()
                }
                updateShells()
                buttonMinus2.isEnabled = true
                buttonPlus1.isEnabled = (blankCount + liveCount) != 8
                buttonPlus2.isEnabled = (blankCount + liveCount) != 8
            }

        buttonMinus2
            .setOnClickListener {
                if (!switchSwapLiveBlank.isChecked) {
                    blankCount--
                    textViewCount2.text = blankCount.toString()
                    updateShells()
                    buttonMinus2.isEnabled = blankCount != 0
                } else {
                    liveCount--
                    textViewCount2.text = liveCount.toString()
                    updateShells()
                    buttonMinus2.isEnabled = liveCount != 0
                }
                buttonPlus1.isEnabled = true
                buttonPlus2.isEnabled = true
            }

        //Link the shot buttons
        buttonShot1
            .setOnClickListener {
                if (!switchSwapLiveBlank.isChecked) {
                    liveCount--
                    textViewCount1.text = liveCount.toString()
                    shellShot(true)
                    buttonShot1.isEnabled = liveCount != 0
                } else {
                    blankCount--
                    textViewCount1.text = blankCount.toString()
                    shellShot(false)
                    buttonShot1.isEnabled = blankCount != 0
                }
            }

        buttonShot2
            .setOnClickListener {
                if (!switchSwapLiveBlank.isChecked) {
                    blankCount--
                    textViewCount2.text = blankCount.toString()
                    shellShot(false)
                    buttonShot2.isEnabled = blankCount != 0
                } else {
                    liveCount--
                    textViewCount2.text = liveCount.toString()
                    shellShot(true)
                    buttonShot2.isEnabled = liveCount != 0
                }
            }

        //Link the swap Live Blank switch
        switchSwapLiveBlank
            .setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    //Set the text
                    textViewCount1.text = blankCount.toString()
                    textView1.text = "Blank"
                    button1_1.text = "Blank"
                    button1_2.text = "Blank"
                    button1_3.text = "Blank"
                    button1_4.text = "Blank"
                    button1_5.text = "Blank"
                    button1_6.text = "Blank"
                    button1_7.text = "Blank"
                    button1_8.text = "Blank"

                    textViewCount2.text = liveCount.toString()
                    textView2.text = "Live"
                    button2_1.text = "Live"
                    button2_2.text = "Live"
                    button2_3.text = "Live"
                    button2_4.text = "Live"
                    button2_5.text = "Live"
                    button2_6.text = "Live"
                    button2_7.text = "Live"
                    button2_8.text = "Live"

                    //Set the colors
                    buttonShot1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blue_button_bg)
                    button1_1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_3.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_4.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_5.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_6.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_7.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button1_8.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)

                    buttonShot2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.red_button_bg)
                    button2_1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_3.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_4.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_5.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_6.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_7.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button2_8.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)

                    //Set the buttons
                    buttonMinus1.isEnabled = blankCount != 0
                    buttonMinus2.isEnabled = liveCount != 0

                } else {
                    //Set the text
                    textViewCount1.text = liveCount.toString()
                    textView1.text = "Live"
                    button1_1.text = "Live"
                    button1_2.text = "Live"
                    button1_3.text = "Live"
                    button1_4.text = "Live"
                    button1_5.text = "Live"
                    button1_6.text = "Live"
                    button1_7.text = "Live"
                    button1_8.text = "Live"

                    textViewCount2.text = blankCount.toString()
                    textView2.text = "Blank"
                    button2_1.text = "Blank"
                    button2_2.text = "Blank"
                    button2_3.text = "Blank"
                    button2_4.text = "Blank"
                    button2_5.text = "Blank"
                    button2_6.text = "Blank"
                    button2_7.text = "Blank"
                    button2_8.text = "Blank"

                    //Set the colors
                    buttonShot1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.red_button_bg)
                    button1_1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_3.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_4.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_5.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_6.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_7.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)
                    button1_8.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.live_button_bg)

                    buttonShot2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blue_button_bg)
                    button2_1.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_2.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_3.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_4.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_5.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_6.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_7.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)
                    button2_8.backgroundTintList =
                        ContextCompat.getColorStateList(this, R.color.blank_button_bg)

                    //Set the buttons
                    buttonMinus1.isEnabled = liveCount != 0
                    buttonMinus2.isEnabled = blankCount != 0
                }

                //Set the states
                if (button1_1.isChecked) {
                    buttonToggleGroup1.check(R.id.button2_1)
                } else if (button2_1.isChecked) {
                    buttonToggleGroup1.check(R.id.button1_1)
                }
                if (button1_2.isChecked) {
                    buttonToggleGroup2.check(R.id.button2_2)
                } else if (button2_2.isChecked) {
                    buttonToggleGroup2.check(R.id.button1_2)
                }
                if (button1_3.isChecked) {
                    buttonToggleGroup3.check(R.id.button2_3)
                } else if (button2_3.isChecked) {
                    buttonToggleGroup3.check(R.id.button1_3)
                }
                if (button1_4.isChecked) {
                    buttonToggleGroup4.check(R.id.button2_4)
                } else if (button2_4.isChecked) {
                    buttonToggleGroup4.check(R.id.button1_4)
                }
                if (button1_5.isChecked) {
                    buttonToggleGroup5.check(R.id.button2_5)
                } else if (button2_5.isChecked) {
                    buttonToggleGroup5.check(R.id.button1_5)
                }
                if (button1_6.isChecked) {
                    buttonToggleGroup6.check(R.id.button2_6)
                } else if (button2_6.isChecked) {
                    buttonToggleGroup6.check(R.id.button1_6)
                }
                if (button1_7.isChecked) {
                    buttonToggleGroup7.check(R.id.button2_7)
                } else if (button2_7.isChecked) {
                    buttonToggleGroup7.check(R.id.button1_7)
                }
                if (button1_8.isChecked) {
                    buttonToggleGroup8.check(R.id.button2_8)
                } else if (button2_8.isChecked) {
                    buttonToggleGroup8.check(R.id.button1_8)
                }
            }

        //Link the Start and Reset buttons
        buttonStart
            .setOnClickListener {
                //Start the game
                currentShot = 1

                //Swap Start button with Reset
                buttonStart.visibility = View.GONE
                buttonReset.visibility = View.VISIBLE

                //Hide the editing buttons
                switchSwapLiveBlank.visibility = View.INVISIBLE
                buttonPlus1.visibility = View.GONE
                buttonMinus1.visibility = View.GONE
                buttonPlus2.visibility = View.GONE
                buttonMinus2.visibility = View.GONE

                //Show shot buttons
                buttonShot1.visibility = View.VISIBLE
                buttonShot2.visibility = View.VISIBLE

                //Enable shot buttons
                if (!switchSwapLiveBlank.isChecked) {
                    buttonShot1.isEnabled = liveCount != 0
                    buttonShot2.isEnabled = blankCount != 0
                } else {
                    buttonShot1.isEnabled = blankCount != 0
                    buttonShot2.isEnabled = liveCount != 0
                }
            }

        buttonReset
            .setOnClickListener {
                //Reset the game
                currentShot = 0

                //Reset counters
                blankCount = 0
                liveCount = 0
                textViewCount2.text = blankCount.toString()
                textViewCount1.text = liveCount.toString()

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

                //Reset visibility
                updateShells()

                //Swap Reset button with Start
                buttonStart.visibility = View.VISIBLE
                buttonReset.visibility = View.GONE

                //Show the editing buttons
                switchSwapLiveBlank.visibility = View.VISIBLE
                buttonPlus1.visibility = View.VISIBLE
                buttonMinus1.visibility = View.VISIBLE
                buttonPlus2.visibility = View.VISIBLE
                buttonMinus2.visibility = View.VISIBLE

                //Hide shot buttons
                buttonShot1.visibility = View.GONE
                buttonShot2.visibility = View.GONE

                //Reset the count buttons
                buttonMinus1.isEnabled = false
                buttonMinus2.isEnabled = false
                buttonPlus1.isEnabled = true
                buttonPlus2.isEnabled = true
            }
    }
}