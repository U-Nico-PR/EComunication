package com.example.ecomunication.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ecomunication.R

@Composable
fun ParteSuperior(
    texto: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.Mic,
                contentDescription = "Logo Micrófono",
                modifier = Modifier.size(56.dp),
                tint = colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)))
        Text(
            text = texto,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Contrasenia(
    texto: String,
    etiqueta: String,
) {
    Text(
        text = texto,
        style = MaterialTheme.typography.headlineSmall
    )
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(etiqueta)
        },
        singleLine = true,
        visualTransformation = if (true) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (true) Icons.Default.Visibility else Icons.Default.VisibilityOff
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Mostrar Contraseña"
                )
            }
        },
        shape = shapes.large,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun NotaYBoton(
    @StringRes texto: Int,
    textoBoton: String,
    showIcon: Boolean,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Text(
            text = stringResource(texto),
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_large))
        )
    }
    Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)))
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = textoBoton
        )
        if (showIcon) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Continuar"
            )
        }
    }
}