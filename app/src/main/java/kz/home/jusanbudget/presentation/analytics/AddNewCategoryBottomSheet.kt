package kz.home.jusanbudget.presentation.analytics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.home.jusanbudget.R
import kz.home.jusanbudget.databinding.NewCategoryBottomSheetBinding
import kz.home.jusanbudget.domain.Category
import kz.home.jusanbudget.utils.categories
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AddNewCategoryBottomSheet : BottomSheetDialogFragment() {

    private val viewModel: FutureViewModel by sharedViewModel()
    private var _binding: NewCategoryBottomSheetBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NewCategoryBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.autoComplete.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.dropdown_item,
                categories.map { it.name })
        )

        binding.button2.setOnClickListener { dismiss() }

        fun iconGetter(value:String):Int{
            return categories.map { it.img }[categories.map { it.name }.indexOf(value)]
        }


        binding.addButton.setOnClickListener {
            val newCategory = Category(
                4,
                binding.autoComplete.text.toString(),
                0,0,
                iconGetter(binding.autoComplete.text.toString()),
                binding.tvSumma.text.toString().toFloat(),
                0f,
                0f,
                0,
                0f
            )
            viewModel.addNewCategory(newCategory)
            dismiss()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}