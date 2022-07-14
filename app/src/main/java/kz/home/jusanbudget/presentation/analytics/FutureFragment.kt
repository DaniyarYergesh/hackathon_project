package kz.home.jusanbudget.presentation.analytics

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kz.home.jusanbudget.databinding.FragmentFutureBinding
import kz.home.jusanbudget.domain.Category
import kz.home.jusanbudget.utils.categories
import kz.home.jusanbudget.utils.months
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FutureFragment : Fragment() {

    private var _binding: FragmentFutureBinding? = null
    private val binding get() = _binding!!
    private lateinit var barChart: BarChart
    private val viewModel: FutureViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFutureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        barChart = binding.barChart



        barChart.data = generateBarData()
        barChart.setVisibleXRangeMaximum(5f)
        barChart.axisLeft.isEnabled =false
        barChart.axisRight.isEnabled =false
        barChart.getXAxis().isEnabled = false

        barChart.animateXY(500, 500)
        barChart.description.text = "Average of months"

//        val xAxis = barChart.xAxis
//        xAxis.valueFormatter = IndexAxisValueFormatter(categories.map { it.name })
//        xAxis.position =XAxis.XAxisPosition.BOTTOM_INSIDE
//        xAxis.labelCount = categories.size

        val adapter = FutureAdapter(viewModel::deleteCategory)
        binding.rvMyCategories.adapter = adapter

        viewModel.categoryList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
            binding.sumOfAll.text = it.map { it.spent }.sum().toString()

        }


        binding.button.setOnClickListener {
            AddNewCategoryBottomSheet().show(childFragmentManager, null)
        }

        val itemTouchHelper = ItemTouchHelper(CategoryItemTouch(adapter))
        itemTouchHelper.attachToRecyclerView(binding.rvMyCategories)
    }

    private fun generateBarData(): BarData {
        val entries1: ArrayList<BarEntry> = ArrayList()
        val colors = mutableListOf<Int>()
        val temp = mutableListOf<Category>()

        for (i in months.indices)
            temp.add(months[i])

        for (i in temp.indices) {
            entries1.add(BarEntry((i+2).toFloat(), temp[i].spent))
            colors.add(Color.GREEN)
        }


        val ds1 = BarDataSet(entries1, "Months")
        ds1.color=Color.GREEN

        ds1.colors = colors
        ds1.valueTextColor = Color.BLACK
        ds1.valueTextSize = 12f


        val d = BarData(ds1)

        return d
    }

}