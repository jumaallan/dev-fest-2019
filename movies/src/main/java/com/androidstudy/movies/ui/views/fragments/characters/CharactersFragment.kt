package com.androidstudy.movies.ui.views.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.androidstudy.devfest19.core.livedata.nonNull
import com.androidstudy.devfest19.core.livedata.observe
import com.androidstudy.movies.R
import com.androidstudy.movies.ui.adapter.CharactersAdapter
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import com.androidstudy.movies.utils.SessionManager
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {
    private lateinit var sessionManager: SessionManager
    private val characterViewModel: CharacterViewModel by viewModel()
    private lateinit var charactersAdapter: CharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionManager = SessionManager(requireContext())

        //check if its user's first time
        if (!sessionManager.isFirstTime()) {
            characterViewModel.getCharacters()
        } else {
            characterViewModel.fetchLocalCharacters().nonNull().observe(this) {
                charactersAdapter.updateList(it)
            }
        }

        observeLiveData()

        charactersAdapter = CharactersAdapter(emptyList()) {
            val characterFragmentAction =
                CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(it)
            findNavController().navigate(characterFragmentAction)
        }

        recyclerViewMovies.adapter = charactersAdapter
    }

    private fun observeLiveData() {
        characterViewModel.getCharactersResponse().nonNull().observe(this) {
            if (it.results.isNotEmpty()) {
                sessionManager.setNotFirstTime(true)
                charactersAdapter.updateList(it.results)
            }
        }
        characterViewModel.getCharactersError().nonNull().observe(this) {
            sessionManager.setNotFirstTime(false)
        }
    }

}