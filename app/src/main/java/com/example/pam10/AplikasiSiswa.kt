package com.example.pam10

import android.app.Application
import com.example.pam10.repository.ContainerApp
import com.example.pam10.repository.ContainerDataApp

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}