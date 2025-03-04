package net.domisafonov.compasstestproject.ui.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import net.domisafonov.compasstestproject.R
import net.domisafonov.compasstestproject.ui.tenthcharacterscreen.TenthCharacterScreenUi
import net.domisafonov.compasstestproject.ui.wordcountscreen.WordCountScreenUi

@Composable
fun MainScreenUi(
    modifier: Modifier = Modifier,
    onTenthClick: () -> Unit = {},
    onWordCountClick: () -> Unit = {},
) {

    val viewModel: MainScreenViewModel = hiltViewModel()

    val isActivated by viewModel.isActivated.collectAsState()

    if (isActivated) {
        ActivatedUi(modifier, onTenthClick, onWordCountClick)
    } else {
        Box(modifier = modifier.fillMaxSize()) {
            Button(
                onClick = { viewModel.onButtonClick() },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "Do it!")
            }
        }
    }
}

@Composable
private fun ActivatedUi(
    modifier: Modifier,
    onTenthClick: () -> Unit,
    onWordCountClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickable() { onTenthClick() }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.tenth_screen_label),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.headlineSmall,
                )

                TenthCharacterScreenUi(
                    modifier = Modifier
                        .fillMaxSize(),
                    doCompactView = true,
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clickable { onWordCountClick() },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.word_count_screen_label),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.headlineSmall,
                )

                WordCountScreenUi(
                    modifier = Modifier
                        .fillMaxSize(),
                    doCompactView = true,
                )
            }
        }
    }
}
