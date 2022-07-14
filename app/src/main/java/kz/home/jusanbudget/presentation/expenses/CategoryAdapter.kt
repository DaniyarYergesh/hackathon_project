package kz.home.jusanbudget.presentation.expenses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.home.jusanbudget.domain.Category

class CategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CategoryViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryViewHolder).bind(data[position])
    }

    fun setItems(list: MutableList<Category>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}