package com.example.mycityapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mycityapp.R
import com.example.mycityapp.model.RecommendationViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class CategoryFragment : Fragment() {

    private val viewModel: RecommendationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        val category = arguments?.getString("category") ?: "Coffee Shops"
        view.findViewById<TextView>(R.id.categoryTitle).text = category
        viewModel.loadRecommendations(category)

        val listView = view.findViewById<ListView>(R.id.recommendationListView)
        viewModel.recommendations.observe(viewLifecycleOwner) { recommendations ->
            val adapter = ArrayAdapter(
                requireContext(),
                R.layout.list_item,
                recommendations.map { it.title }
            )
            listView.adapter = adapter

            listView.setOnItemClickListener { _, _, position, _ ->
                val selectedRecommendation = recommendations[position]
                val bundle = Bundle().apply {
                    putString("category", category)  // Pass the current category
                    putString("title", selectedRecommendation.title)
                    putString("description", selectedRecommendation.description)
                    putInt("imageResource", selectedRecommendation.imageResId)
                    putInt("smallImage1ResId", selectedRecommendation.smallImage1ResId)
                    putInt("smallImage2ResId", selectedRecommendation.smallImage2ResId)
                    putInt("index", position)
                }
                findNavController().navigate(R.id.detailFragment, bundle)
            }

        }

        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        setBottomNavSelection(bottomNav, category)
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.category1 -> navigateToCategory("Coffee Shops")
                R.id.category2 -> navigateToCategory("Restaurants")
                R.id.category3 -> navigateToCategory("Shopping Centers")
                R.id.category4 -> navigateToCategory("Tourist Spots")
            }
            true
        }

        return view
    }

    private fun setBottomNavSelection(bottomNav: BottomNavigationView, category: String) {
        val selectedItemId = when (category) {
            "Coffee Shops" -> R.id.category1
            "Restaurants" -> R.id.category2
            "Shopping Centers" -> R.id.category3
            "Tourist Spots" -> R.id.category4
            else -> R.id.category1
        }
        bottomNav.selectedItemId = selectedItemId
    }

    private fun navigateToCategory(category: String) {
        val bundle = Bundle().apply { putString("category", category) }
        findNavController().navigate(R.id.categoryFragment, bundle)
    }
}
