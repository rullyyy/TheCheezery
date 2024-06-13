package luna.raul.thecheezery

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SaltiesActivity : AppCompatActivity() {

    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_salties)

        agregaProductos()

        var listView : ListView = findViewById(R.id.lvSalties)

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, salties)
        listView.adapter = adaptador
    }

    fun agregaProductos(){
        salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
        salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))
    }

    private class AdaptadorProductos : BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflator = LayoutInflater.from(contexto)
            var vista =  inflator.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista

        }

    }

}