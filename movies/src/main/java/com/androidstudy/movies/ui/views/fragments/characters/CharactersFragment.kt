package com.androidstudy.movies.ui.views.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.androidstudy.movies.R
import com.androidstudy.movies.data.remote.Character
import com.androidstudy.movies.ui.adapter.CharactersAdapter
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import com.androidstudy.movies.utils.CustomGridLayoutManager
import com.androidstudy.movies.utils.SessionManager
import com.androidstudy.movies.utils.nonNull
import com.androidstudy.movies.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {
    private lateinit var sessionManager: SessionManager
    private val characterViewModel: CharacterViewModel by viewModel()
    private lateinit var adapter: CharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionManager = SessionManager(context!!)

        activity?.toast(sessionManager.isFirstTime().toString())

        //check if its user's first time
        if (!sessionManager.isFirstTime()) {
            characterViewModel.getCharacters()
        } else {
            characterViewModel.fetchLocalCharacters().nonNull().observe(this) {
                setUpViews(it)
            }
        }

        observeLiveData()

        val layoutManager = CustomGridLayoutManager(activity!!.applicationContext, 2)
        layoutManager.setScrollEnabled(false)
        recyclerViewMovies.layoutManager = layoutManager

        adapter = CharactersAdapter(emptyList()) {}


    }

    private fun observeLiveData() {
        characterViewModel.getCharactersResponse().nonNull().observe(this) {
            if (it.results.isNotEmpty()) {
                sessionManager.setNotFirstTime(true)
                setUpViews(it.results)
            }
        }
        characterViewModel.getCharactersError().nonNull().observe(this) {
            sessionManager.setNotFirstTime(false)
        }
    }

    private fun setUpViews(pagedList: List<Character>) {
        adapter.updateList(pagedList)
        recyclerViewMovies.adapter = adapter

    }

}

