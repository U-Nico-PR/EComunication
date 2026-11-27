package com.example.ecomunication.ui

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.SmartDisplay
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
import androidx.compose.ui.input.InputMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomunication.R
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun PotcastScreen(
    modifier: Modifier = Modifier
){
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        Video(titulo = "Ciberseguridad")
        Evaluacion(
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_medium))
        )
        Coments()
    }
}


@Composable
fun Coments(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CarComentario(comentario = "Te recomiento que hables un poco de tu experiencia. Una anecdota.")
    }
}

@Composable
fun CarComentario(
    comentario: String
) {
    Card() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = "Bot Feedback",
                    tint = colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Alumno",
                )
                Text(
                    text = comentario,
                )
            }
        }
    }
}
@Composable
fun Video(
    titulo: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_medium)))
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.SmartDisplay,
                    contentDescription = "Reproducir Video",
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            Text(
                text = titulo,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun Evaluacion(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        DetalleEvaluacion(
            rango = "Aceptable",
            comunicacion = "Muletillas",
            fraccion = "7/10",
            modifier = Modifier
                .fillMaxWidth(),
        )
        DetalleEvaluacion(
            rango = "Deficiente",
            comunicacion = "Tono de Voz",
            fraccion = "2/10",
            modifier = Modifier
                .fillMaxWidth(),
        )
        DetalleEvaluacion(
            rango = "Aceptable",
            comunicacion = "Guíon",
            fraccion = "10/10",
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}

@Composable
fun DetalleEvaluacion(
    comunicacion: String,
    rango: String,
    fraccion: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = comunicacion,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = rango,
                    style = MaterialTheme.typography.headlineSmall,
                    color = when(rango) {
                        "Aceptable", "aceptable" -> Color.Green
                        "Deficiente", "deficiente" -> Color.Red
                        else -> Color.Gray
                    }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = fraccion,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PortcastPreview() {
    EComunicationTheme() {
        PotcastScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}