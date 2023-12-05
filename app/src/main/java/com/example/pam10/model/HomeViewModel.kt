package com.example.pam10.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pam10.data.Siswa
import com.example.pam10.repository.RepositorySiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel (private val repositoriSiswa: RepositorySiswa): ViewModel(){

    companion object{
        private const val TIMEOUT_MILIES = 5_000L
    }
    val homeuistate : StateFlow<HomeUiState> = repositoriSiswa.getAllSiswaStream()
        .filterNotNull()
        .map { HomeUiState(listSiswa = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILIES),
            initialValue = HomeUiState()
        )
    data class HomeUiState(
        val listSiswa: List<Siswa> = listOf()
        )

}