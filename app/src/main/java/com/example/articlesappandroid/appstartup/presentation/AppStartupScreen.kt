package com.example.articlesappandroid.appstartup.presentation


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun AppStartupScreen(navController: NavController){
    Greeting(name = "sadsasaddsasdasdadsa sadadsdasdsaads")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ArticlesAppAndroidTheme {
//        Greeting("Android")
//    }
//}