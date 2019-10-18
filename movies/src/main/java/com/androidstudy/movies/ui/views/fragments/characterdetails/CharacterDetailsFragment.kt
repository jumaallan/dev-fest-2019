package com.androidstudy.movies.ui.views.fragments.characterdetails

import androidx.fragment.app.Fragment
import com.androidstudy.movies.R
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.ext.viewModel

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {
    private val characterViewModel: CharacterViewModel by viewModel()
}