package com.androidstudy.movies.ui.views.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.androidstudy.movies.R
import com.androidstudy.movies.data.models.CharactersResponseModel
import com.androidstudy.movies.ui.adapter.CharactersAdapater
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import com.androidstudy.movies.utils.nonNull
import com.androidstudy.movies.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*
import org.jetbrains.anko.toast

class CharactersFragment : Fragment(R.layout.fragment_characters) {
    private val characterViewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }
    lateinit var adapater: CharactersAdapater

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapater = CharactersAdapater(emptyList()) {

        }
        recyclerViewMovies.adapter = adapater
        getCharacters()
        observeLiveData()
    }

    private fun observeLiveData() {
        characterViewModel.getCharactersResponse().nonNull()
            .observe(this) { characterResponseModel ->
                setUpViews(characterResponseModel)
            }
        characterViewModel.getCharactersError().nonNull().observe(this) {
            activity?.toast(it)
        }
    }

    private fun setUpViews(characterResponseModel: CharactersResponseModel) {
        activity?.toast(characterResponseModel.results.size.toString())
        adapater.updateList(characterResponseModel.results)

    }

    private fun getCharacters() {
        characterViewModel.getCharacters()
    }
}

