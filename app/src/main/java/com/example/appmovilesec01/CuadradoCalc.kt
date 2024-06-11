package com.example.appmovilesec01

import android.widget.ScrollView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.ScrollingView

@Composable
fun CuadradoActivty() {
    var resultado by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp, bottom = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Generar Total Cuadrados Comprendidos entre 15 y 70",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Espacio(tamanio = 10)
                Button(
                    onClick = { resultado = calcularCuadrados() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Calcular Cuadrados")
                }
                Text(
                    text = resultado,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}

fun calcularCuadrados(): String {

    //DECLARAMOS EL ARRAY
    var result = StringBuilder()

    for ( i in 15..70){
        val cuadradoNum = i*i
        val mitad = i/2
        result.append("El cuadrado del ${i} es : ${cuadradoNum} y su mitad es ${mitad}")
    }
    return result.toString()
}
