package com.zorojuro.stockapp.api

import com.zorojuro.stockapp.models.Stock
import com.zorojuro.stockapp.models.StockSymbol
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface StockService {
    @POST("/info")
    suspend fun getStock(
        @Header("x-rapidapi-key") key: String,
        @Header("x-rapidapi-host") host: String,
        @Body stockRequestBody: StockSymbol
    ) : Response<Stock>
}