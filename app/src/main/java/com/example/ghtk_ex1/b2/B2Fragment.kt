package com.example.ghtk_ex1.b2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ghtk_ex1.R
import com.example.ghtk_ex1.databinding.FragmentB2Binding

class B2Fragment : Fragment() {
    private var _binding: FragmentB2Binding? = null
    private val binding get() = _binding!!

    private val viewModel: B2ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentB2Binding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.b2ViewModel = viewModel
        binding.b2Fragment = this
    }

    // Xác nhận các tọa độ đã điền
    fun submitCoordinates() {
        if (!checkErrorTextField()) {
            viewModel.setXA(binding.inputEditTextXa.text.toString().toDouble())
            viewModel.setYA(binding.inputEditTextYa.text.toString().toDouble())
            viewModel.setX1(binding.inputEditTextX1.text.toString().toDouble())
            viewModel.setY1(binding.inputEditTextY1.text.toString().toDouble())
            viewModel.setX2(binding.inputEditTextX2.text.toString().toDouble())
            viewModel.setY2(binding.inputEditTextY2.text.toString().toDouble())
            viewModel.setX3(binding.inputEditTextX3.text.toString().toDouble())
            viewModel.setY3(binding.inputEditTextY3.text.toString().toDouble())
            viewModel.setResult()
        }
    }

    // Kiểm tra tọa độ đã điền chưa
    private fun checkErrorTextField(): Boolean {
        if (binding.inputEditTextXa.text.isNullOrEmpty()) {
            binding.inputLayoutXa.isErrorEnabled = true
            binding.inputLayoutXa.error = getString(R.string.error_field_required)
            return true
        }

        if (binding.inputEditTextYa.text.isNullOrEmpty()) {
            binding.inputLayoutYa.isErrorEnabled = true
            binding.inputLayoutYa.error = getString(R.string.error_field_required)
            return true
        }

        if (binding.inputEditTextX1.text.isNullOrEmpty()) {
            binding.inputLayoutX1.isErrorEnabled = true
            binding.inputLayoutX1.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.inputLayoutX1.isErrorEnabled = false
        }

        if (binding.inputEditTextY1.text.isNullOrEmpty()) {
            binding.inputLayoutY1.isErrorEnabled = true
            binding.inputLayoutY1.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.inputLayoutY1.isErrorEnabled = false
        }

        if (binding.inputEditTextX2.text.isNullOrEmpty()) {
            binding.inputLayoutX2.isErrorEnabled = true
            binding.inputLayoutX2.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.inputLayoutX2.isErrorEnabled = false
        }

        if (binding.inputEditTextY2.text.isNullOrEmpty()) {
            binding.inputLayoutY2.isErrorEnabled = true
            binding.inputLayoutY2.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.inputLayoutY2.isErrorEnabled = false
        }

        if (binding.inputEditTextX3.text.isNullOrEmpty()) {
            binding.inputLayoutX3.isErrorEnabled = true
            binding.inputLayoutX3.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.inputLayoutX3.isErrorEnabled = false
        }

        if (binding.inputEditTextY3.text.isNullOrEmpty()) {
            binding.inputLayoutY3.isErrorEnabled = true
            binding.inputLayoutY3.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.inputLayoutY3.isErrorEnabled = false
        }

        return false
    }

    fun checkInputXa() {
        if (binding.inputEditTextXa.text.isNullOrEmpty()) {
            binding.inputLayoutXa.isErrorEnabled = true
            binding.inputLayoutXa.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutXa.isErrorEnabled = false
        }
    }

    fun checkInputYa() {
        if (binding.inputEditTextYa.text.isNullOrEmpty()) {
            binding.inputLayoutYa.isErrorEnabled = true
            binding.inputLayoutYa.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutYa.isErrorEnabled = false
        }
    }

    fun checkInputX1() {
        if (binding.inputEditTextX1.text.isNullOrEmpty()) {
            binding.inputLayoutX1.isErrorEnabled = true
            binding.inputLayoutX1.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutX1.isErrorEnabled = false
        }
    }

    fun checkInputY1() {
        if (binding.inputEditTextY1.text.isNullOrEmpty()) {
            binding.inputLayoutY1.isErrorEnabled = true
            binding.inputLayoutY1.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutY1.isErrorEnabled = false
        }
    }

    fun checkInputX2() {
        if (binding.inputEditTextX2.text.isNullOrEmpty()) {
            binding.inputLayoutX2.isErrorEnabled = true
            binding.inputLayoutX2.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutX2.isErrorEnabled = false
        }
    }

    fun checkInputY2() {
        if (binding.inputEditTextY2.text.isNullOrEmpty()) {
            binding.inputLayoutY2.isErrorEnabled = true
            binding.inputLayoutY2.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutY2.isErrorEnabled = false
        }
    }

    fun checkInputX3() {
        if (binding.inputEditTextX3.text.isNullOrEmpty()) {
            binding.inputLayoutX3.isErrorEnabled = true
            binding.inputLayoutX3.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutX3.isErrorEnabled = false
        }
    }

    fun checkInputY3() {
        if (binding.inputEditTextY3.text.isNullOrEmpty()) {
            binding.inputLayoutY3.isErrorEnabled = true
            binding.inputLayoutY3.error = getString(R.string.error_field_required)
        } else {
            binding.inputLayoutY3.isErrorEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}