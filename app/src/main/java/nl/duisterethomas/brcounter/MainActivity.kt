package nl.duisterethomas.brcounter

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

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

        var blankCount = 0
        var liveCount = 0

        //Link the counter buttons
        findViewById<MaterialButton>(R.id.buttonPlusBlank)
            .setOnClickListener {
                blankCount ++
                findViewById<TextView>(R.id.textViewBlank).text = blankCount.toString()
            }

        findViewById<MaterialButton>(R.id.buttonMinusBlank)
            .setOnClickListener {
                if (blankCount != 0) {
                    blankCount --
                    findViewById<TextView>(R.id.textViewBlank).text = blankCount.toString()
                }
            }
        findViewById<MaterialButton>(R.id.buttonPlusLive)
            .setOnClickListener {
                liveCount ++
                findViewById<TextView>(R.id.textViewLive).text = liveCount.toString()
            }

        findViewById<MaterialButton>(R.id.buttonMinusLive)
            .setOnClickListener {
                if (liveCount != 0) {
                    liveCount --
                    findViewById<TextView>(R.id.textViewLive).text = liveCount.toString()
                }
            }
    }
}