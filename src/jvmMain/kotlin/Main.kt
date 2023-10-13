/*
https://github.com/JetBrains/compose-multiplatform-desktop-template
https://www.goodwin.dev/dev/2022/3/9/how-to-create-a-desktop-app-using-kotlin-and-compose-desktop/
https://androidexample365.com/a-full-stack-desktop-app-with-desktop-compose-and-spring-boot/

Сборка:  ./gradlew createDistributable
 */

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
  var text by remember { mutableStateOf("Hello, World!") }

  MaterialTheme {
    Scaffold(
      topBar = { MyTopAppBar() }
    ) {
      Button(onClick = {
        text = "Hello, Desktop!"
      }) {
        Text(text)
      }
    }
  }
}

@Composable
fun MyTopAppBar() {
  TopAppBar(
    title = { Text("Simple TopAppBar") },
    navigationIcon = {
      IconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Filled.Menu, contentDescription = null)
      }
    },
    actions = {
      // RowScope here, so these icons will be placed horizontally
      IconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
      }
      IconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Filled.Add, contentDescription = "Localized description")
      }
    }
  )
}

fun main() = application {
  Window(onCloseRequest = ::exitApplication) {
    App()
  }
}
