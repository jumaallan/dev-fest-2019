package com.androidstudy.devfest19.ui.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.androidstudy.devfest19.R
import com.androidstudy.devfest19.ui.adapter.CustomItemClickListener
import com.androidstudy.devfest19.ui.adapter.DynamicModuleRecyclerViewAdapter
import com.androidstudy.devfest19.ui.model.DynamicModule
import com.androidstudy.devfest19.utils.*
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var splitInstallManager: SplitInstallManager

    private val movieModule by lazy { getString(R.string.title_movies) }
    private val musicModule by lazy { getString(R.string.title_music) }
    private val weatherModule by lazy { getString(R.string.title_weather) }
    private val newsModule by lazy { getString(R.string.title_news) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splitInstallManager = SplitInstallManagerFactory.create(this)

        setup()

    }

    private fun setup() {
        val layoutManager = CustomGridLayoutManager(this, 2)
        layoutManager.setScrollEnabled(false)
        recyclerViewModules.layoutManager = layoutManager

        val adapter =
            DynamicModuleRecyclerViewAdapter(
                prepareDynamicModules(),
                this,
                object : CustomItemClickListener {
                    override fun onItemClick(v: View, position: Int) {
                        val modules = prepareDynamicModules()[position]
                        when (modules.dynamicModuleTitle) {
                            Constants.MAIN_DASHBOARD_CARD_MOVIES -> {
                                if (splitInstallManager.installedModules.contains(movieModule)) {
                                    startActivity(intentTo(Activities.MovieModule.Movie))
                                } else {
                                    toast("Movie Module is not installed")
                                }
                            }
                            Constants.MAIN_DASHBOARD_CARD_MUSIC -> {
                                if (splitInstallManager.installedModules.contains(musicModule)) {
                                    startActivity(intentTo(Activities.MusicModule.Music))
                                } else {
                                    toast("Music Module is not installed")
                                }
                            }
                            Constants.MAIN_DASHBOARD_CARD_NEWS -> {
                                if (splitInstallManager.installedModules.contains(newsModule)) {
                                    startActivity(intentTo(Activities.NewsModule.News))
                                } else {
                                    toast("News Module is not installed")
                                }
                            }
                            Constants.MAIN_DASHBOARD_CARD_WEATHER -> {
                                if (splitInstallManager.installedModules.contains(weatherModule)) {
                                    startActivity(intentTo(Activities.WeatherModule.Weather))
                                } else {
                                    toast("Weather Module is not installed")
                                }
                            }
                        }
                    }
                })

        recyclerViewModules.adapter = adapter

    }

    private fun prepareDynamicModules(): List<DynamicModule> {
        val models = ArrayList<DynamicModule>()
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_MOVIES,
                R.drawable.ic_dashboard_movies
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_MUSIC,
                R.drawable.ic_dashboard_music
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_NEWS,
                R.drawable.ic_dashboard_news
            )
        )
        models.add(
            DynamicModule(
                Constants.MAIN_DASHBOARD_CARD_WEATHER,
                R.drawable.ic_dashboard_weather
            )
        )
        return models
    }
}
