package com.example.appmovilesec01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun activityJuvilacion(){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp)
    )
    {
        Column (modifier = Modifier.fillMaxSize()
        ){
            var edad by remember{
                mutableStateOf("")
            }
            var sexo by remember{
                mutableStateOf("")
            }
            var resultado by remember{
                mutableStateOf("")
            }

            androidx.compose.material3.Text(text = "Juvilacion", textAlign = TextAlign.Center)
            Espacio(10)
            OutlinedTextField(value = edad, onValueChange = {edad = it}
                ,modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese su edad: ")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Espacio(10)
            OutlinedTextField(value = sexo, onValueChange = {sexo = it}
                ,modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese su sexo F o M: ")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Espacio(tamanio = 10)
            Button(onClick = {resultado = calcularJuvilacion(edad.toInt(),sexo.toString())}, modifier = Modifier.fillMaxWidth()) {
                androidx.compose.material3.Text(text = "Calcular Juvilacion")
            }
            androidx.compose.material3.Text(text = resultado)
        }

    }
}

fun calcularJuvilacion(edad: Int, sexo: String): String {

    var varEdad = edad
    var varSexo = ""
    var resultado = ""

    if (sexo =="M") {
        varSexo = "MASCULINO"
    }else if (sexo =="F"){
        varSexo = "FEMENINO"
    }else {
        varSexo =="Indisinto"
    }

    if(varEdad >= 60 && varSexo =="MASCULINO"){
        resultado = "Ya puede jubilarse"

    }else if(varEdad > 54 && varSexo =="FEMENINO"){
        resultado = "Ya puede jubilarse"
    }else {
        resultado = "Aun no puede jubilarse"
    }
    return "Su condicion en base a su sexo ${varSexo} y edad : ${varEdad} es: ${resultado}"
}

@Composable
fun Espacio(tamanio:Int){
    Spacer(modifier = Modifier.height(tamanio.dp))
}
