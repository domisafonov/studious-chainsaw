package net.domisafonov.compasstestproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import net.domisafonov.compasstestproject.ui.NavHost
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme

@Stable
class AppState(
    val navController: NavHostController,
)

@Composable
fun ComposeApp(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    val appState = remember { appState }

    CompassTestProjectTheme {
        Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
            NavHost(
                appState = appState,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}
