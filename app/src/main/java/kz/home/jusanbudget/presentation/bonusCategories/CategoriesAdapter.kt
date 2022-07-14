package kz.home.jusanbudget.presentation.bonusCategories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.home.jusanbudget.databinding.ItemAllCategoriesRvBinding
import kz.home.jusanbudget.domain.Category

class CategoriesAdapter() :
    ListAdapter<Category, CategoriesAdapter.CategoriesViewHolder>(CategoriesDiffUtilCallback()) {

    inner class CategoriesViewHolder(val binding: ItemAllCategoriesRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.tvCategoryName.text = item.name
            binding.tvMyBonuses.text = item.bonuses.toString()
            binding.tvPossibleBonuses.text = item.possibleBonus.toString()
            binding.ivCategoryIcon.setImageResource(item.img)
            binding.tvCategoryBonus.text = item.maxPercent.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            ItemAllCategoriesRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}

class CategoriesDiffUtilCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}