package com.example.ecomunication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecomunication.R
import com.example.ecomunication.ui.components.NotaYBoton
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun FaseEvalScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NotaYBoton(
            texto = R.string.fase_evaluacion,
            textoBoton = "Continuar",
            showIcon = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FaseEvalPreview() {
    EComunicationTheme() {
        FaseEvalScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}