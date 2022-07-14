package kz.home.jusanbudget.presentation.analytics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.home.jusanbudget.databinding.ItemSecondPageRvBinding
import kz.home.jusanbudget.domain.Category

class FutureAdapter(    private val deleteItem: (Category) -> Unit,): ListAdapter<Category, FutureAdapter.FutureViewHolder>(FutureAdapterDiffUtilCallback()), CategoryAdapterItemTouchHelper {

    inner class FutureViewHolder(val binding: ItemSecondPageRvBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:Category){
            binding.tvSpentMoney.text = item.spent.toString()
            binding.ivCategoryIcon.setImageResource(item.img)
            binding.tvCategoryName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutureViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
        return FutureViewHolder(ItemSecondPageRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    }

    override fun onBindViewHolder(holder: FutureViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun onDismiss(position: Int) {
        val category = getItem(position)
        deleteItem(category)
        notifyItemRemoved(position)
    }

}

class FutureAdapterDiffUtilCallback: DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}