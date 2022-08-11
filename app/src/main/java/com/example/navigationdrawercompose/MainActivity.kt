package com.example.navigationdrawercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationdrawercompose.ui.theme.NavigationDrawerComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerComposeTheme {

                val scaffoldState= rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState=scaffoldState,
                    topBar ={
                        AppBar (
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrwarerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title="Home",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home),
                                MenuItem(
                                    id = "settings",
                                    title="Settings",
                                    contentDescription = "Go to settings screen",
                                    icon = Icons.Default.Settings),

                                MenuItem(
                                    id = "help",
                                    title="Help",
                                    contentDescription = "Need Help?",
                                    icon = Icons.Default.Info),

                                ) ,
                            onItemClick = {
                                println("Clicked on ${it.title}")
                            }
                        )
                    }
                ) {

                }

            }
        }
    }
}
