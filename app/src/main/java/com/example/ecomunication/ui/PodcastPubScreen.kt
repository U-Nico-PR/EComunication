package com.example.ecomunication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.SmartToy
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecomunication.R
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun PodcastPublicadosScreen(
    botonNuevo: () -> Unit,
    botonEstadoPodcast: () -> Unit,
    botonFeedback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_large))
    ) {
        Text(
            text = stringResource(R.string.numero_podcasts, 10),
            style = MaterialTheme.typography.headlineMedium
        )
        Botones(
            onClickNuevo = botonNuevo,
            onClickVerEstado = botonEstadoPodcast,
        )
        CardVideo(
            onClickFeedback = botonFeedback
        )
    }
}

@Composable
fun Botones(
    onClickNuevo: () -> Unit,
    onClickVerEstado: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
    ) {
        Button(
            onClick = onClickNuevo,
            shape = MaterialTheme.shapes.medium,
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Añadir Video",
            )
            Text(
                text = "Nuevo"
            )
        }
        Button(
            onClick = onClickVerEstado,
            shape = MaterialTheme.shapes.medium
        ) {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = "Ver Estado de Podcast",
            )
            Text(
                text = "Ver Estado de Podcast",
            )
        }
    }
}

@Composable
fun CardVideo(
    onClickFeedback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ) {
            Text(
                text = "12-Dic-2026",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small)))
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = "Reproducir Video",
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
            Informacion(onClickFeedback = onClickFeedback)
        }
    }
}

@Composable
fun Informacion(
    onClickFeedback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Datos()
        Spacer(modifier = Modifier.weight(1f))
        BotFeedback(onClickFeedback = onClickFeedback)
    }
}

@Composable
fun Datos(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = "Titulo del Video",
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis // Pone ... si pasa de 2 lineas
        )
        Text(
            text = stringResource(R.string.comentarios, 2)
        )
    }
}

@Composable
fun BotFeedback(
    onClickFeedback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clickable( onClick = onClickFeedback ),
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.SmartToy,
                contentDescription = "Bot Feedback",
                tint = colorScheme.primary,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = "FeedBack",
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PodcastPublicacionesPreview() {
    EComunicationTheme() {
        PodcastPublicadosScreen(
            botonNuevo = {},
            botonFeedback = {},
            botonEstadoPodcast = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large)),
        )
    }
}