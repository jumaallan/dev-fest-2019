package com.androidstudy.devfest19.ui.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.androidstudy.devfest19.R
import com.androidstudy.devfest19.ui.adapter.CustomItemClickListener
import com.androidstudy.devfest19.ui.adapter.DynamicModuleRecyclerViewAdapter
import com.androidstudy.devfest19.ui.model.DynamicModule
import com.androidstudy.devfest19.utils.CustomGridLayoutManager
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

                        }
                    }
                })

        recyclerViewModules.adapter = adapter

    }

    private fun prepareDynamicModules(): List<DynamicModule> {
        val models = ArrayList<DynamicModule>()
        models.add(
            DynamicModule(
                "Movies",
                R.drawable.ic_launcher_background
            )
        )
        models.add(
            DynamicModule(
                "Music",
                R.drawable.ic_launcher_background
            )
        )
        models.add(
            DynamicModule(
                "News",
                R.drawable.ic_launcher_background
            )
        )
        models.add(
            DynamicModule(
                "Weather",
                R.drawable.ic_launcher_background
            )
        )
        return models
    }
}
