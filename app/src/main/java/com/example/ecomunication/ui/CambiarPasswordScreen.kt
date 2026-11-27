package com.example.ecomunication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecomunication.R
import com.example.ecomunication.ui.components.Contrasenia
import com.example.ecomunication.ui.components.ParteSuperior
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun CambiarPasswordScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ParteSuperior(
            texto = stringResource(R.string.cambiar_password)
        )
        ConjuntoPasswords(
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_large))
        )
        Button(
            onClick = {},
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Confirmar"
            )
        }
    }
}

@Composable
fun ConjuntoPasswords(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Contrasenia(
            texto = "Ingresa tu actual contraseña:",
            etiqueta = "***************"
        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        Contrasenia(
            texto = "Ingresa tu nueva contraseña:",
            etiqueta = "***************"
        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        Contrasenia(
            texto = "Cofirma tu nueva contraseña:",
            etiqueta = "***************"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CambiarPasswordPreview() {
    EComunicationTheme() {
        CambiarPasswordScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}