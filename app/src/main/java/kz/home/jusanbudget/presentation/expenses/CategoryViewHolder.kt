package kz.home.jusanbudget.presentation.expenses

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.home.jusanbudget.R
import kz.home.jusanbudget.domain.Category

class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_category, parent, false)) {
    private val imageView = itemView.findViewById<ImageView>(R.id.icon)
    private val nameTextView = itemView.findViewById<TextView>(R.id.name)
    private val spentTextView = itemView.findViewById<TextView>(R.id.spent)
    private val bonusTextView = itemView.findViewById<TextView>(R.id.bonus)

    fun bind(item: Category) {
        nameTextView.text = item.name
        imageView.setImageResource(item.img)
        spentTextView.text = item.spent.toString()
        bonusTextView.text = item.bonuses.toString()
    }
}