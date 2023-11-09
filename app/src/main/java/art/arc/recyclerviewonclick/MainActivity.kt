package art.arc.recyclerviewonclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.viewmodel.CreationExtras
import art.arc.recyclerviewonclick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var lista : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerList.setHasFixedSize(true)
        lista.add("Ala")
        lista.add("Ola")
        binding.recyclerList.adapter = ListAdapter(lista) {
           rowListClicked(it)
        }
    }

    private fun rowListClicked(s: String) {
        binding.selectedItem.text = s
    }
}