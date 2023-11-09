package art.arc.recyclerviewonclick

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import art.arc.recyclerviewonclick.databinding.ListRowBinding

class ListAdapter(var lista : ArrayList<String>, private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListRowBinding.inflate(inflater, parent, false)
        return RowViewHolder(binding)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RowViewHolder).bind(lista[position], clickListener)
    }

    inner class RowViewHolder(private val binding: ListRowBinding) :
                    RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String, clickListener: (String) -> Unit) {
            binding.listElement.text = s
            binding.root.setOnClickListener { clickListener(s) }
        }
    }
}