package com.example.multiverseradar

import android.app.Application
import androidx.room.Room
import com.example.multiverseradar.data.local.AppDatabase
import com.example.multiverseradar.data.remote.RickAndMortyApi
import com.example.multiverseradar.data.repository.CharacterRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MultiverseApp : Application() {

    lateinit var repository: CharacterRepository
        private set

    override fun onCreate() {
        super.onCreate()

        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "multiverse.db"
        ).build()

        val api = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)

        repository = CharacterRepository(api, database.characterDao())
    }
}
