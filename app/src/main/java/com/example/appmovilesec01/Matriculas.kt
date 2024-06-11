package com.example.appmovilesec01

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

@Composable
fun Matricula(){


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 40.dp, bottom = 20.dp)
    ) {
        var resultado by remember { mutableStateOf("") }
        var cantidadCursos by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Total de Matricula ",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Espacio(10)
                OutlinedTextField(value = cantidadCursos, onValueChange = {cantidadCursos = it}
                    ,modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Ingrese la cantidad de cursos a llevar(Obligatorios 5): ")},
                    maxLines = 1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Espacio(tamanio = 10)
                Button(
                    onClick = { resultado = calcularMatricula(cantidadCursos.toInt()) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Calcular total")
                }
                Text(
                    text = resultado,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}

fun calcularMatricula(cursos: Int): String {

    var cantidad = validarCantidad(cursos)
    var mensaje = ""

    if(cantidad==1){
        var total = 0.0
        var descuento = 0.10
        var precioFijo=520.0

        if(cursos == 5 ){
            total=precioFijo
        }else if(cursos >5){
            total=precioFijo - (precioFijo * descuento)
        }else{
            total
        }
        mensaje= "El total de su matricula de acuerdo a la cantidad de cursos : ${cursos} y el total es : ${total}"
    }else{
        mensaje="No puede ser menor a 5 cursos"
    }

    return mensaje
}

fun validarCantidad(cursos: Int): Int {

    if(cursos >=5 ){
        return 1
    }else{
        return 0
    }
}
