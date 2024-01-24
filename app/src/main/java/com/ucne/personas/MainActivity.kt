package com.ucne.personas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucne.personas.ui.theme.PersonasTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla()
                }
            }
        }
    }
}


@Composable
fun Pantalla(modifier: Modifier = Modifier) {
    var expandido by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registro de personas",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 16.dp)
            )

            var nombre by remember { mutableStateOf("") }
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text(text = "Nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            var telefono by remember { mutableStateOf("") }
            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text(text = "Telefono") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            var celular by remember { mutableStateOf("") }
            OutlinedTextField(
                value = celular,
                onValueChange = { celular = it },
                label = { Text(text = "Celular") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )



            var email by remember { mutableStateOf("") }
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )
            var Fecha by remember { mutableStateOf("") }
            OutlinedTextField(
                value = Fecha,
                onValueChange = { Fecha = it },
                label = { Text(text = "Fecha de nacimiento") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp)
            )

            val ocupaciones = listOf("Bombero", "Ingeniero", "Médico", "Policia", "Militar")
            var ocupacionSeleccionada by remember { mutableStateOf("") }

            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = ocupacionSeleccionada,
                    onValueChange = { ocupacionSeleccionada = it },
                    readOnly = true,
                    enabled = false,
                    label = { Text(text = "Ocupación") },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                    },
                    modifier = Modifier
                        .clickable {
                            expandido = true
                            Log.e("tag", "expandido")
                        }
                        .fillMaxWidth()
                )
                DropdownMenu(
                    expanded = expandido,
                    onDismissRequest = { expandido = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ocupaciones.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                expandido = false
                                ocupacionSeleccionada = item
                            })
                        // DropdownMenuItem(onClick = { expandido = false
                        //ocupacionSeleccionada = item }) {
                        //Text(text = item)
                    }
                }
            }


            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Guardar")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    PersonasTheme {
        Pantalla()
    }
}