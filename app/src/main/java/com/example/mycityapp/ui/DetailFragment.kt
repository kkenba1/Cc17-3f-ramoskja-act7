package com.example.mycityapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.mycityapp.R
import com.example.mycityapp.model.RecommendationViewModel

class DetailFragment : Fragment() {

    private lateinit var recommendationImage: ImageView
    private lateinit var recommendationSmallImage1: ImageView
    private lateinit var recommendationSmallImage2: ImageView
    private lateinit var recommendationTitle: TextView
    private lateinit var recommendationDescription: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    private var currentIndex = 0
    private var category: String? = null
    private val viewModel: RecommendationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        recommendationImage = view.findViewById(R.id.recommendationImage)
        recommendationTitle = view.findViewById(R.id.recommendationTitle)
        recommendationSmallImage1 = view.findViewById(R.id.smallImageContainer1)
        recommendationSmallImage2 = view.findViewById(R.id.smallImageContainer2)
        recommendationDescription = view.findViewById(R.id.recommendationDescription)
        previousButton = view.findViewById(R.id.previousButton)
        nextButton = view.findViewById(R.id.nextButton)

        arguments?.let {
            category = it.getString("category")
            val title = it.getString("title")
            val description = it.getString("description")
            val imageResId = it.getInt("imageResource")
            val smallImage1ResId = it.getInt("smallImage1ResId")
            val smallImage2ResId = it.getInt("smallImage2ResId")
            currentIndex = it.getInt("index", 0)

            recommendationTitle.text = title
            recommendationDescription.text = description
            recommendationImage.setImageResource(imageResId)
            recommendationSmallImage1.setImageResource(smallImage1ResId)
            recommendationSmallImage2.setImageResource(smallImage2ResId)



            category?.let { cat ->
                viewModel.loadRecommendations(cat)
            }
        }

        previousButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateUI(currentIndex)
            }
        }

        nextButton.setOnClickListener {
            val recommendationsCount = viewModel.recommendations.value?.size ?: 0
            if (currentIndex < recommendationsCount - 1) {
                currentIndex++
                updateUI(currentIndex)
            }
        }

        return view
    }

    private fun updateUI(index: Int) {
        val recommendation = viewModel.recommendations.value?.get(index)
        recommendation?.let {
            recommendationTitle.text = it.title
            recommendationDescription.text = it.description
            recommendationImage.setImageResource(it.imageResId)
            recommendationSmallImage1.setImageResource(it.smallImage1ResId)
            recommendationSmallImage2.setImageResource(it.smallImage2ResId)
        }
    }
}
