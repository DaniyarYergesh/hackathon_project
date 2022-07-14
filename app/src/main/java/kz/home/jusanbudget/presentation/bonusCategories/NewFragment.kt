package kz.home.jusanbudget.presentation.bonusCategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.home.jusanbudget.databinding.FragmentNewBinding
import kz.home.jusanbudget.utils.myCategories
import kz.home.jusanbudget.utils.otherCategories

class NewFragment : Fragment() {

    private var idCounter = 0
    private var _binding: FragmentNewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Log.e("", viewModel.getAllBonus())

        val adapter = CategoriesAdapter()
        binding.rvAllCategories.adapter = adapter
        adapter.submitList(otherCategories)

        val secondAdapter = MyCategoriesAdapter()
        binding.rvMyCategories.adapter = secondAdapter
        secondAdapter.submitList(myCategories)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}