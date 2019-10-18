package com.androidstudy.movies.ui.views.fragments.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.androidstudy.movies.R
import com.androidstudy.movies.data.models.CharactersResponseModel
import com.androidstudy.movies.ui.adapter.CharactersAdapter
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import com.androidstudy.movies.utils.CustomGridLayoutManager
import com.androidstudy.movies.utils.nonNull
import com.androidstudy.movies.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val characterViewModel: CharacterViewModel by viewModel()
    private lateinit var adapter: CharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = CustomGridLayoutManager(activity!!.applicationContext, 2)
        layoutManager.setScrollEnabled(false)
        recyclerViewMovies.layoutManager = layoutManager

        adapter = CharactersAdapter(emptyList()) {

        }
        recyclerViewMovies.adapter = adapter
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
        adapter.updateList(characterResponseModel.results)
    }

    private fun getCharacters() {
        characterViewModel.getCharacters()
    }
}

