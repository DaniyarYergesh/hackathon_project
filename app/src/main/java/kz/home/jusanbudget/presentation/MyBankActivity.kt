package kz.home.jusanbudget.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kz.home.jusanbudget.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyBankActivity : AppCompatActivity() {
    private val viewModel: MyBankViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_bank)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.selectedItemId = R.id.page2

        val budgetCV = findViewById<CardView>(R.id.budget_cv)
        budgetCV.setOnClickListener {
            val intent = Intent(this, BudgetActivity::class.java)
            startActivity(intent)
        }

        //viewModel.register()
        //viewModel.authorization()

    }
}