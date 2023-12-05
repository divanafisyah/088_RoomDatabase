package com.example.pam10.repository

import com.example.pam10.data.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositorySiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    fun getSiswaStream(id: Int): Flow<Siswa?>
    suspend fun insertSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa:Siswa)
}