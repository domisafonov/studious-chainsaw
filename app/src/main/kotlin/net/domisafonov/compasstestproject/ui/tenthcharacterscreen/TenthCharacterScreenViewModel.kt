package net.domisafonov.compasstestproject.ui.tenthcharacterscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.domisafonov.compasstestproject.domain.usecase.ObserveTenthCharacterTextUc
import net.domisafonov.compasstestproject.domain.usecase.RefreshAboutPageUc
import javax.inject.Inject

@HiltViewModel
class TenthCharacterScreenViewModel @Inject constructor(
    observeTenthCharacterTextUc: ObserveTenthCharacterTextUc,
    private val refreshAboutPageUc: RefreshAboutPageUc,
) : ViewModel() {

    val text: Flow<String?> = observeTenthCharacterTextUc.execute()

    private val _isRefreshCompleted = MutableStateFlow(false)
    val isRefreshCompleted: StateFlow<Boolean> = _isRefreshCompleted.asStateFlow()

    fun setRefreshing(isRefreshing: Boolean) {
        if (isRefreshing) {
            viewModelScope.launch {
                refreshAboutPageUc.execute()
                _isRefreshCompleted.value = true
            }
        } else {
            _isRefreshCompleted.value = false
        }
    }
}
