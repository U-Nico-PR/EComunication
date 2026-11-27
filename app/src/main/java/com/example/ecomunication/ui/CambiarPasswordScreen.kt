package com.example.ecomunication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecomunication.R
import com.example.ecomunication.ui.components.Contrasenia
import com.example.ecomunication.ui.components.ParteSuperior
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun CambiarPasswordScreen(
    onClickConfirmar: () -> Unit,
    onClickCancelar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        ParteSuperior(
            texto = stringResource(R.string.cambiar_password)
        )
        ConjuntoPasswords(
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_large))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = onClickConfirmar,
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(
                    text = "Confirmar"
                )
            }
            Button(
                onClick = onClickCancelar,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red.copy(alpha = 0.15f),
                    contentColor = Color.Red
                )
            ) {
                Text(
                    text = "Cancelar"
                )
            }
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
            onClickConfirmar = {},
            onClickCancelar = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}