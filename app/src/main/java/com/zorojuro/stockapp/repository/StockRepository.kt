package com.zorojuro.stockapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zorojuro.stockapp.api.StockService
import com.zorojuro.stockapp.BuildConfig
import com.zorojuro.stockapp.models.Stock
import com.zorojuro.stockapp.models.StockSymbol
import com.zorojuro.stockapp.utility.Resource

class StockRepository(private val stockService: StockService) {
    suspend fun getStock(stockSymbol: StockSymbol): Resource<Stock> {
        return try {
            val response = stockService.getStock(BuildConfig.API_KEY, BuildConfig.API_HOST, stockSymbol)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to retrieve the stock.")
            }
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred.")
        }
    }
}