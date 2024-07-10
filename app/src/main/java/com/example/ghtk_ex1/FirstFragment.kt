package com.example.ghtk_ex1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ghtk_ex1.databinding.FragmentFirstBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private var isFirstFragment = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSwitch.setOnClickListener {
            switchLayout()
        }

        binding.btnCalculate.setOnClickListener {
            countCharArray()
        }
    }

    private fun switchLayout() {
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }

    private fun countCharArray() {
        val text = binding.stringEditText.text.toString()
        val charArray = text.toCharArray()
        val result = charArray.size
        binding.result.text = context?.resources?.getString(R.string.result1, result.toString())
    }
}
