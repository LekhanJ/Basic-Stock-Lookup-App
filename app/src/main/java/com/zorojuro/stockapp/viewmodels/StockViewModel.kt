package com.zorojuro.stockapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zorojuro.stockapp.models.Stock
import com.zorojuro.stockapp.models.StockSymbol
import com.zorojuro.stockapp.repository.StockRepository
import com.zorojuro.stockapp.utility.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StockViewModel(private val repository: StockRepository) : ViewModel() {
    private val _stock = MutableStateFlow<Resource<Stock>?>(null)
    val stock: StateFlow<Resource<Stock>?> = _stock

    fun getStock(stockSymbol: StockSymbol) {
        viewModelScope.launch {
            _stock.value = Resource.Loading()
            val result = repository.getStock(stockSymbol)
            _stock.value = result
        }
    }
}