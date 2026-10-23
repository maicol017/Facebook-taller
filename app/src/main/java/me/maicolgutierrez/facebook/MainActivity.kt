package me.maicolgutierrez.facebook

import me.maicolgutierrez.facebook.ui.screens.FacebookLoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.maicolgutierrez.facebook.ui.screens.FacebookRegisterScreen
import me.maicolgutierrez.facebook.ui.screens.FeedScreen
import me.maicolgutierrez.facebook.ui.screens.RecuperarPasswordScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val myNavController = rememberNavController()

            NavHost(navController = myNavController, startDestination = "login", modifier = Modifier.fillMaxSize()) {
                composable(route="login"){
                    FacebookLoginScreen(
                        onClickRegister = {
                            myNavController.navigate("register")
                        },
                        onClickIniciarSesion = {
                            myNavController.navigate("feed")
                        },
                        // NUEVO: lleva a la pantalla de recuperar contraseña
                        onClickOlvide = {
                            myNavController.navigate("recuperar")
                        }
                    )
                }
                composable(route="register") {
                    FacebookRegisterScreen(onClickBack = {
                        myNavController.popBackStack()
                    })
                }
                composable(route="feed") { FeedScreen() }

                // NUEVO: ruta de recuperar contraseña
                composable(route="recuperar") {
                    RecuperarPasswordScreen(
                        onBack = {
                            myNavController.popBackStack()
                        },
                        onContinuar = { email ->
                            // Aquí va tu lógica (por ahora vuelve al login)
                            myNavController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}




