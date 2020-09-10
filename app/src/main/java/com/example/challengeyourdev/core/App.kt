package com.example.challengeyourdev.core

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import com.example.challengeyourdev.core.utils.modules
import com.example.challengeyourdev.core.utils.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


//criado por arthur rodrigues

class App : Application(){

    val myModule = listOf(modules, viewModelModule)

    companion object{
        lateinit var instance : App
        var temInternet: Boolean = true
    }

    init{
        instance = this
    }

    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }

        val connectivityManager = this.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                temInternet = false
                //record wi-fi disconnect event
            }
            override fun onUnavailable() {
                temInternet = false
            }
            override fun onLosing(network: Network, maxMsToLive: Int) {
                temInternet = false
            }
            override fun onAvailable(network: Network) {
                temInternet = true
            }
        }

        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }
}