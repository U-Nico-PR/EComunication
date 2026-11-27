package com.example.ecomunication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecomunication.R
import com.example.ecomunication.ui.components.NotaYBoton
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun Instrucciones(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cerrar"
            )
        }
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)))
        NotaYBoton(
            texto = R.string.instrucciones,
            textoBoton = "Continuar",
            showIcon = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstruccionesPreview() {
    EComunicationTheme() {
        Instrucciones(
            modifier = Modifier
                . fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}