package com.example.ecomunication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomunication.R
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun EstadoPodcastScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Regresar",
            )
            Text(
                text = "Regresar",
            )
        }
        // Aquí se van agregando las Cards de Tema que vienen en lista.
        CardTema(
            tema = "Ciberseguridad",
            estado = "En revisión",
            valor = 0,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
        CardTema(
            tema = "Base de Datos",
            estado = "Rechazado",
            valor = 1,
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun CardTema(
    tema: String,
    estado: String,
    valor: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tema,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = estado,
                    fontSize = 16.sp,
                    color = when (valor) {
                        0 -> Color.Green
                        1 -> Color.Red
                        else -> Color.Yellow
                    }
                )
            }
            if (valor == 1) {
                Motivo(
                    motivo = "Fuera de Contexto",
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
fun Motivo(
    motivo: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Motivo",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = motivo,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EstadoPodcastPreview() {
    EComunicationTheme() {
        EstadoPodcastScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}