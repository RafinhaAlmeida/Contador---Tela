package com.example.contador

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contador.ui.theme.ContadorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContadorScreen(modifier: Modifier = Modifier) {
    // RT1 + D3: estado com rememberSaveable (sobrevive à rotação de tela)
    var contador by rememberSaveable { mutableStateOf(0) }

    // D4: cor do número conforme a faixa de valor (cores do MaterialTheme)
    val corDoNumero = when {
        contador == 0 -> MaterialTheme.colorScheme.onSurfaceVariant
        contador < 10 -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.tertiary
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Contador") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Valor atual",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = contador.toString(),
                style = MaterialTheme.typography.displayLarge,
                color = corDoNumero
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = { contador++ }) {
                    Text("+ Somar")
                }
                // D1: botão desabilitado quando o valor é 0 (não fica negativo)
                OutlinedButton(
                    onClick = { contador-- },
                    enabled = contador > 0
                ) {
                    Text("− Subtrair")
                }
            }

            // D2: botão "Zerar" com estilo secundário
            TextButton(
                onClick = { contador = 0 },
                enabled = contador != 0
            ) {
                Text("Zerar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContadorScreenPreview() {
    ContadorTheme {
        ContadorScreen()
    }
}
