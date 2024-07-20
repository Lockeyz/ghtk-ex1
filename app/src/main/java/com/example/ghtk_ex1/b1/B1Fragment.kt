package com.example.ghtk_ex1.b1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ghtk_ex1.R
import com.example.ghtk_ex1.databinding.FragmentB1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class B1Fragment : Fragment() {
    private var _binding: FragmentB1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: B1ViewModel by viewModels()

//    lateinit var adapter: B1Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_b1, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // tạo các biến liên kết với fragment
        binding.b1ViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.b1Fragment = this

        binding.recyclerView.adapter = CharacterAdapter(requireContext(), viewModel.resultList.value!!)
    }

    // Hàm nhận chuỗi nhập vào
    fun submitString(){
        if (!checkErrorTextField()) {
            viewModel.setCurrentString(binding.stringEditText.text.toString())
            viewModel.setResultList()
        }

        binding.recyclerView.adapter = CharacterAdapter(requireContext(), viewModel.resultList.value!!)
    }

    // Kiem tra chuoi da nhap chua
    fun checkErrorTextField(): Boolean {
        if (binding.stringEditText.text.isNullOrEmpty()) {
            binding.stringInputLayout.isErrorEnabled = true
            binding.stringInputLayout.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.stringInputLayout.isErrorEnabled = false
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
