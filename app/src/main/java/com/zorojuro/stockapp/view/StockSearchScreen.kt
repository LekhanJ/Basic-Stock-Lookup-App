package com.zorojuro.stockapp.view

import android.icu.text.DecimalFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zorojuro.stockapp.models.StockSymbol
import com.zorojuro.stockapp.utility.Resource
import com.zorojuro.stockapp.viewmodels.StockViewModel

@Composable
fun StockSearchScreen (
    navController: NavController,
    viewModel: StockViewModel
) {
    var stockSymbol by remember { mutableStateOf("") }
    val stockState by viewModel.stock.collectAsState()
    val absoluteChangeFormat = remember { DecimalFormat("#,##0.00") }
    val percentChangeFormat = remember { DecimalFormat("0.00") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = stockSymbol,
            onValueChange = { stockSymbol = it },
            label = { Text("Enter Stock Symbol") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (stockSymbol.isNotEmpty()) {
                    viewModel.getStock(StockSymbol(stockSymbol))
                }
            }
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (val result = stockState) {
            is Resource.Success -> {
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column (
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "Company: ${result.data?.longName}",
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            "Symbol: ${result.data?.symbol}",
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            "Current price: ${result.data?.currentPrice}",
                            fontFamily = FontFamily.Monospace
                        )

                        val changeAbsolute = (result.data?.currentPrice?.minus(result.data.previousClose))!!
                        val changeColorAbsolute = if (changeAbsolute >= 0) androidx.compose.ui.graphics.Color.Green else androidx.compose.ui.graphics.Color.Red
                        val changeSignAbsolute = if (changeAbsolute >= 0) "+" else ""
                        Text(
                            "Change: $changeSignAbsolute${absoluteChangeFormat.format(changeAbsolute)}",
                            fontFamily = FontFamily.Monospace,
                            color = changeColorAbsolute
                        )

                        val changePercentage = (((result.data?.currentPrice?.minus(result.data.previousClose))?.div(result.data.previousClose))?.times(100))!!
                        val changeColorPercent = if (changePercentage >= 0) androidx.compose.ui.graphics.Color.Green else androidx.compose.ui.graphics.Color.Red
                        val changeSignPercent = if (changePercentage >= 0) "+" else ""
                        Text(
                            "Change%: $changeSignPercent${percentChangeFormat.format(changePercentage)}%",
                            fontFamily = FontFamily.Monospace,
                            color = changeColorPercent
                        )
                    }
                }
            }
            is Resource.Error -> {
                Text("Error: ${result.message}")
            }
            is Resource.Loading -> {
                CircularProgressIndicator()
            }
            null -> {

            }
        }
    }
}
