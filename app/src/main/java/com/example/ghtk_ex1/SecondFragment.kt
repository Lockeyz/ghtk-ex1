package com.example.ghtk_ex1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ghtk_ex1.databinding.FragmentSecondBinding
import kotlin.math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSwitch.setOnClickListener {
            switchLayout()
        }
        binding.btnCalculate.setOnClickListener { calculateResult() }
    }

    private fun switchLayout() {
        findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
    }

    private fun calculateResult() {
        val xA =
            binding.inputEditTextXa.text
                .toString()
                .toDouble()
        val yA =
            binding.inputEditTextYa.text
                .toString()
                .toDouble()
        val x1 =
            binding.inputEditTextX1.text
                .toString()
                .toDouble()
        val y1 =
            binding.inputEditTextY1.text
                .toString()
                .toDouble()
        val x2 =
            binding.inputEditTextX2.text
                .toString()
                .toDouble()
        val y2 =
            binding.inputEditTextY2.text
                .toString()
                .toDouble()
        val x3 =
            binding.inputEditTextX3.text
                .toString()
                .toDouble()
        val y3 =
            binding.inputEditTextY3.text
                .toString()
                .toDouble()

        val triangleArea = calculateTriangleArea(x1, y1, x2, y2, x3, y3)
        val sum4pointsArea =
            calculateTriangleArea(xA, yA, x1, y1, x2, y2) +
            calculateTriangleArea(xA, yA, x1, y1, x3, y3,) + 
            calculateTriangleArea(xA, yA, x2, y2, x3, y3)
        if (triangleArea < sum4pointsArea) {
            binding.textViewResult.text = "Điểm A nằm trong tam giác"
        } else {
            binding.textViewResult.text = "Điểm A không nằm trong tam giác"
        }
    }

    private fun calculateTriangleArea(
        x1: Double,
        y1: Double,
        x2: Double,
        y2: Double,
        x3: Double,
        y3: Double,
    ): Double {
        val area =
            0.5 *
                abs(
                    x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2),
                )
        return area
    }
}
