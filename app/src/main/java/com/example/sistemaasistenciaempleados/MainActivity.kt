package com.example.sistemaasistenciaempleados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sistemaasistenciaempleados.controller.UsuarioController
import com.example.sistemaasistenciaempleados.ui.theme.SistemaAsistenciaEmpleadosTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SistemaAsistenciaEmpleadosTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrueba()
                }
            }
        }
    }
}

@Composable
fun PantallaPrueba() {
    val coroutineScope = rememberCoroutineScope()
    // Instanciamos el controlador que creaste
    val controller = remember { UsuarioController() }
    var mensaje by remember { mutableStateOf("Presiona el botón para probar") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = mensaje)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Lanzamos una corrutina porque las llamadas de red no pueden bloquear la pantalla principal
            coroutineScope.launch {
                mensaje = "Conectando al servidor..."
                // Usamos las credenciales de Juan Perez de tu GestionDB.sql
                val usuario = controller.login("JuanPe@gestion.com", "123456")

                if (usuario != null) {
                    mensaje = "¡Éxito! Bienvenido, ${usuario.nombre} ${usuario.apellido}"
                } else {
                    mensaje = "Error: No se pudo conectar o credenciales inválidas"
                }
            }
        }) {
            Text("Probar Inicio de Sesión")
        }
    }
}