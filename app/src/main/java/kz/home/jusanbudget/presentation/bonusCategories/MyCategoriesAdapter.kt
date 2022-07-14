package kz.home.jusanbudget.presentation.bonusCategories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.home.jusanbudget.databinding.ItemMyCategoriesRvBinding
import kz.home.jusanbudget.domain.Category

class MyCategoriesAdapter() : ListAdapter<Category, MyCategoriesAdapter.MyCategoriesViewHolder>(MyCategoriesDiffUtilCallback()) {

    inner class MyCategoriesViewHolder(val binding: ItemMyCategoriesRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.tvCategoryName.text = item.name
            binding.tvPossibleBonuses.text = item.possibleBonus.toString()
            binding.ivCategoryIcon.setImageResource(item.img)
            binding.tvCategoryBonus.text = item.maxPercent.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoriesViewHolder {
        return MyCategoriesViewHolder(
            ItemMyCategoriesRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyCategoriesViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}

class MyCategoriesDiffUtilCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}