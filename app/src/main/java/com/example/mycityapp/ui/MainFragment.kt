package com.example.mycityapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mycityapp.R
import com.example.mycityapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.category1Button.setOnClickListener {
            navigateToCategory("Coffee Shops")
        }
        binding.category2Button.setOnClickListener {
            navigateToCategory("Restaurants")
        }
        binding.category3Button.setOnClickListener {
            navigateToCategory("Shopping Centers")
        }
        binding.category4Button.setOnClickListener {
            navigateToCategory("Tourist Spots")
        }
    }

    private fun navigateToCategory(category: String) {
        val bundle = Bundle().apply { putString("category", category) }
        findNavController().navigate(R.id.action_mainFragment_to_categoryFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
