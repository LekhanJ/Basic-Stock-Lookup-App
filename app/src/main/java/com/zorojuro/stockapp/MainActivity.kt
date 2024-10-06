package com.zorojuro.stockapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zorojuro.stockapp.api.RetrofitHelper
import com.zorojuro.stockapp.api.StockService
import com.zorojuro.stockapp.repository.StockRepository
import com.zorojuro.stockapp.ui.theme.StockAppTheme
import com.zorojuro.stockapp.viewmodels.StockViewModel
import com.zorojuro.stockapp.viewmodels.StockViewModelFactory
import com.zorojuro.stockapp.view.StockSearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val stockService = RetrofitHelper.getStockServiceInstance().create(StockService::class.java)

        val stockRepository = StockRepository(stockService)

        val stockViewModelFactory = StockViewModelFactory(stockRepository)

        val stockViewModel: StockViewModel = ViewModelProvider(this, stockViewModelFactory).get(StockViewModel::class.java)

        setContent {
            StockAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "stock_search_screen"
                ) {
                    composable("stock_search_screen") {
                        StockSearchScreen(navController, stockViewModel)
                    }
                }
            }
        }
    }
}