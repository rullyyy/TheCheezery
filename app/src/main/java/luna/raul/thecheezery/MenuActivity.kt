package luna.raul.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnColdDrinks: Button = findViewById(R.id.button_cold_drinks) as Button
        var btnHotDrinks: Button = findViewById(R.id.button_hot_drinks) as Button
        var btnSweets: Button = findViewById(R.id.button_sweets) as Button
        var btnSalties: Button = findViewById(R.id.button_salties) as Button

        btnColdDrinks.setOnClickListener {
            var intent: Intent = Intent(this, ProductosActivity::class.java)
            startActivity(intent)
        }

        btnHotDrinks.setOnClickListener {
            var intent: Intent = Intent(this, HotDrinksActivity::class.java)
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            var intent: Intent = Intent(this, SweetsActivity::class.java)
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this, SaltiesActivity::class.java)
            startActivity(intent)
        }

    }

}