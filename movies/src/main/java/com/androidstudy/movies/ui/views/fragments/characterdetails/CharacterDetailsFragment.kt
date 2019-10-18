package com.androidstudy.movies.ui.views.fragments.characterdetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.androidstudy.movies.R
import com.androidstudy.movies.data.remote.Character
import com.androidstudy.movies.ui.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.viewModel

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {
    private val characterViewModel: CharacterViewModel by viewModel()
    val characterDetailsSafeArgs : CharacterDetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = characterDetailsSafeArgs.character
        setupViews(character)
    }

    private fun setupViews(character: Character) {
        bannerImgView.load(character.image)
        nameTxtView.text = character.name
        genderTxtView.text = character.gender
        typeTxtView.text = character.origin.name
        statusTxtView.text = character.status

    }
}