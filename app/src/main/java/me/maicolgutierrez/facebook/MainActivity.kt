package me.maicolgutierrez.facebook

import FacebookLoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.maicolgutierrez.facebook.ui.screens.FacebookRegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

           val myNaveController = rememberNavController()

            NavHost(navController = myNaveController, startDestination = "login", modifier = Modifier.fillMaxSize()){
                composable(route = "login"){FacebookLoginScreen(myNaveController)}
                    composable(route="register"){
                    FacebookRegisterScreen(myNaveController)
                }
            }
        }
    }
}




