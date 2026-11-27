package com.example.ecomunication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecomunication.R
import com.example.ecomunication.ui.theme.EComunicationTheme


@Composable
fun ResumenTema(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.texto_cronometro)
        )
        Text(
            text = stringResource(R.string.tiempo_cronometro, "7:21"),
            fontWeight = FontWeight.Bold
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 2.dp,
            color = Color.Black
        )
        Text(
            text = AnnotatedString.fromHtml(
                htmlString = stringResource(R.string.tema, "Big Data")),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
        )
        Text(
            text = "Información",
            fontWeight = FontWeight.Bold,
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xADFFED75)
            ),
            border = BorderStroke(
                width = 1.5.dp,
                color = MaterialTheme.colorScheme.primary // O Color(0x)
            )
        ) {
            Text(
                text = stringResource(R.string.big_data),
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)),
                textAlign = TextAlign.Justify,
            )
        }
        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)))
    }
}

@Preview(showBackground = true)
@Composable
fun ResumenTemaPreview() {
    EComunicationTheme() {
        ResumenTema(modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}