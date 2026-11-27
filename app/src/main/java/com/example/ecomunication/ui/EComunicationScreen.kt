package com.example.ecomunication.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ecomunication.UserViewModel
import com.example.ecomunication.R
import com.example.ecomunication.ui.components.GrabacionAutomaticaScreen

enum class EComunicationScreen(@StringRes val title: Int) {
    CambiarPassword(title = R.string.cambiar_password),
    Configuration(title = R.string.cofiguracion),
    Tema(title = R.string.elegir_tema),
    EstadoPodcast(title = R.string.estado_podcast),
    FaseEval(title = R.string.fase_eval),
    Instrucciones(title = R.string.instrucctions),
    Loggin(title = R.string.iniciar_sesion),
    PodcastPub(title = R.string.podcast_publicados),
    Podcast(title = R.string.podcast),
    Proceso(title = R.string.proceso_video),
    Resumen(title = R.string.resumen_tema),
    Grabar(title = R.string.grabar)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EComunicationAppBar(
    navegarAtras: Boolean,
    nav: () -> Unit,
    actualScreen: EComunicationScreen,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = actualScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if(navegarAtras) {
                IconButton(onClick = nav) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription =stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun EComunicationApp(
    viewModel: UserViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = EComunicationScreen.valueOf(
        backStackEntry?.destination?.route ?: EComunicationScreen.Loggin.name
    )
    Scaffold(
        topBar = {
            EComunicationAppBar(
                navegarAtras = navController.previousBackStackEntry != null,
                actualScreen = currentScreen,
                nav = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = EComunicationScreen.Loggin.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = EComunicationScreen.Loggin.name) {
                LoginScreen(
                    siguiente = {
                        navController.navigate(EComunicationScreen.PodcastPub.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.PodcastPub.name) {
                PodcastPublicadosScreen(
                    onClickConfiguration = {
                        navController.navigate(EComunicationScreen.Configuration.name)
                    },
                    botonNuevo = {
                        navController.navigate(EComunicationScreen.Tema.name)
                    },
                    botonEstadoPodcast = {
                        navController.navigate(EComunicationScreen.EstadoPodcast.name)
                    },
                    botonFeedback = {
                        navController.navigate(EComunicationScreen.Podcast.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.Podcast.name) {
                PotcastScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.EstadoPodcast.name) {
                EstadoPodcastScreen(
                    regresar = {
                        if (navController.previousBackStackEntry != null) {
                            navController.navigateUp()
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.Tema.name) {
                ElegirTemaScreen(
                    onClickComenzar = {
                        navController.navigate(EComunicationScreen.Instrucciones.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.Instrucciones.name) {
                InstruccionesScreen(
                    onClickContinuar = {
                        //navController.navigate(EComunicationScreen.Resumen.name)
                        navController.navigate( EComunicationScreen.Grabar.name)

                    },
                    onClickCancel = {
                        navController.popBackStack(EComunicationScreen.Tema.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.Resumen.name) {
                ResumenTemaScreen(
                    // Aquí se debe poner una forma de pasar a la siguiente pantalla que es grabar el video.
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.FaseEval.name) {
                FaseEvalScreen(
                    onClick = {
                        navController.popBackStack(EComunicationScreen.PodcastPub.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.Configuration.name) {
                ConfigurarScreen(
                    onClickCambiarPassword = {
                        navController.navigate(EComunicationScreen.CambiarPassword.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.CambiarPassword.name) {
                CambiarPasswordScreen(
                    onClickConfirmar = { /* Aquí se pone la acción de cambiar contraseña*/},
                    onClickCancelar = {
                        navController.popBackStack(EComunicationScreen.Configuration.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
            composable(route = EComunicationScreen.Grabar.name) {
                GrabacionAutomaticaScreen(
                    duracionSegundos = 15,
                    onVideoGuardado = { urlDelVideo ->
                        // Aquí se indica guardar el video
                        navController.navigate(EComunicationScreen.FaseEval.name)
                    }
                )
            }
            composable(route = EComunicationScreen.FaseEval.name) {
                FaseEvalScreen(
                    onClick = {
                        navController.popBackStack(EComunicationScreen.PodcastPub.name, inclusive = false)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_large))
                )
            }
        }
    }
}
