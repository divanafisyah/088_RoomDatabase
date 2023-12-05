package com.example.pam10.repository

import android.content.Context
import com.example.pam10.data.DatabaseSiswa

interface ContainerApp{
    val repositoriSiswa : RepositorySiswa
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoriSiswa: RepositorySiswa by lazy {
        OfflineRepositorySiswa(DatabaseSiswa.getDatabase(context).siswaDao())
        }
}