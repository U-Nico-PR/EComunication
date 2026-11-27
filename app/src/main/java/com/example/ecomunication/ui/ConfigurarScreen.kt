package com.example.ecomunication.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecomunication.R
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun ConfigurarScreen(
    onClickCambiarPassword: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Button(
            onClick = onClickCambiarPassword,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(R.dimen.padding_large))
        ) {
            Text(
                text = "Cambiar Contraseña",
            )
            Spacer(modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small)))
            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = "Cambiar contraseña"
            )
        }
        Text(
            text = "Configuración de Avatar",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            modifier = Modifier.fillMaxWidth()
        ) {
            AvatarOptionImage(
                imageRes = R.drawable.ic_launcher_foreground,
                contentDescription = "Avatar del usuario",
                onClick = {}
            )
        }
    }
}

@Composable
fun AvatarOptionImage(
    @DrawableRes imageRes: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .size(140.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
    )
}

@Preview(showBackground = true)
@Composable
fun ConfigurarPreview() {
    EComunicationTheme() {
        ConfigurarScreen(
            onClickCambiarPassword = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}