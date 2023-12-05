package com.example.pam10.repository

import com.example.pam10.data.Siswa
import com.example.pam10.data.SiswaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositorySiswa (private val siswaDao: SiswaDao): RepositorySiswa
{
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()

    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)

    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
}