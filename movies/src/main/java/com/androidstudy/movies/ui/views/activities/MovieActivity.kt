package com.androidstudy.movies.ui.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.androidstudy.devfest19.ui.views.MainActivity
import com.androidstudy.movies.R
import com.androidstudy.movies.di.injectFeature
import com.androidstudy.devfest19.R as devfest

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        injectFeature()
        setupNavigation()
    }

    private fun setupNavigation() {
       Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(devfest.menu.home_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == devfest.id.action_home) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
