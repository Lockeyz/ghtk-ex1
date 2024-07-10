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
            countOccurrences()
        }
    }

    private fun switchLayout() {
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }

    private fun countOccurrences(){
        val text = binding.stringEditText.text.toString()
        val charArray = text.toCharArray()

        val countMap = mutableMapOf<Char, Int>()
        val result = mutableListOf<String>()

        for (element in charArray) {
            if (countMap.containsKey(key = element)) {
                countMap[element] = countMap[element]!! + 1
            } else {
                countMap[element] = 1
            }
        }

        for ((element, count) in countMap) {
            if (element.toString() == " ") {
                result.add("Khoảng trắng xuất hiện $count lần")
            } else {
                result.add("Phần tử $element xuất hiện $count lần")
            }
        }

        val resultText = result.joinToString("\n")

        binding.result.text = resultText

    }
}
