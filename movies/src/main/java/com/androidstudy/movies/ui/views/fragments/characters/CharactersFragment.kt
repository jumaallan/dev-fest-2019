package com.androidstudy.movies.ui.views.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.androidstudy.movies.R
import com.androidstudy.movies.data.model.Movie
import com.androidstudy.movies.ui.adapter.CharactersAdapter
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import com.androidstudy.movies.utils.CustomGridLayoutManager
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val characterViewModel: CharacterViewModel by viewModel()
    private lateinit var adapter: CharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = CustomGridLayoutManager(activity!!.applicationContext, 2)
        layoutManager.setScrollEnabled(false)
        recyclerViewMovies.layoutManager = layoutManager

        adapter = CharactersAdapter(emptyList()) {}

        characterViewModel.fetchMovies().observe(this, Observer {
            setUpViews(it)
        })
    }

    private fun setUpViews(pagedList: List<Movie>?) {
        if (pagedList.isNullOrEmpty()) {

        } else {
            adapter.updateList(pagedList)
            recyclerViewMovies.adapter = adapter
        }
    }

}

