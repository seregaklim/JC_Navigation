package com.example.jc_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jc_navigation.ui.Screen1
import com.example.jc_navigation.ui.Screen2
import com.example.jc_navigation.ui.Screen3
import com.example.jc_navigation.ui.theme.JC_NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             //переключаемся между экранами
            val navController = rememberNavController()

            JC_NavigationTheme {

                NavHost(

                    navController = navController,
                   //экран по умолчанию
                    startDestination = "screen_1"
                ) {
                    composable("screen_1"){
                        Screen1 {
                            navController.navigate("screen_2")
                        }
                    }
                    composable("screen_2"){
                        Screen2 {
                            navController.navigate("screen_3")
                        }
                    }
                    composable("screen_3"){
                        Screen3 {
                            navController.navigate("screen_1"){
                                // оставить стек первого экрана
                                popUpTo("screen_1"){
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
