package com.example.ecomunication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.fromHtml
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ecomunication.R
import com.example.ecomunication.ui.theme.EComunicationTheme

@Composable
fun ElegirTemaScreen(
    onClickComenzar: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        CardTema(
            onClickComenzar = onClickComenzar,
            tema = "Big Data",
            resumen = "Análisis de grandes volúmenes de datos"
        )
        CardTema(
            onClickComenzar = onClickComenzar,
            tema = "Big Data",
            resumen = "Análisis de grandes volúmenes de datos"
        )
    }
}

@Composable
fun CardTema(
    onClickComenzar: () -> Unit,
    tema: String,
    resumen: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_large)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = AnnotatedString.fromHtml(
                    htmlString = stringResource(R.string.tema, tema)
                ),
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
            Text(
                text = "Resumen",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = resumen,
                fontSize = 12.sp,
            )
            Button(
                onClick = onClickComenzar,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Comenzar"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ElegirTemaPreview(modifier: Modifier = Modifier) {
    EComunicationTheme() {
        ElegirTemaScreen(
            onClickComenzar = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_large))
        )
    }
}

