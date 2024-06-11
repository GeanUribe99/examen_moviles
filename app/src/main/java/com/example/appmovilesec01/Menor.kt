package com.example.appmovilesec01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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


@Composable
fun NumeroMenorActivity(){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp)
    )
    {
        Column (modifier = Modifier.fillMaxSize()
        ){
            var num1 by remember{
                mutableStateOf("")
            }
            var num2 by remember{
                mutableStateOf("")
            }
            var num3 by remember{
                mutableStateOf("")
            }
            var num4 by remember{
                mutableStateOf("")
            }
            var resultado by remember{
                mutableStateOf("")
            }

            Text(text = "Numero menor", textAlign = TextAlign.Center)
            Espacio(10)
            OutlinedTextField(value = num1, onValueChange = {num1 = it}
                ,modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese num1: ") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(10)
            OutlinedTextField(value = num2, onValueChange = {num2 = it}
                ,modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese num2: ") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(10)
            OutlinedTextField(value = num3, onValueChange = {num3 = it}
                ,modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese num3: ") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(10)
            OutlinedTextField(value = num4, onValueChange = {num4 = it}
                ,modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese num4: ") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Espacio(tamanio = 10)
            Button(onClick = {resultado = calcularNumMenor(num1.toInt(),num2.toInt(),num3.toInt(),num4.toInt(),)}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Calcular Menor")
            }
            Text(text = resultado)
        }

    }



}

fun calcularNumMenor(num1: Int, num2: Int, num3: Int, num4: Int): String {

    var varResult = 0

    varResult = minOf(num1, num2, num3, num4)

    return "El numero menor es : ${varResult}"
}
