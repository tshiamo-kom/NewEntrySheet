package com.example.newentry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.newentry.databinding.FragmentNewEntrysheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NewEntrysheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewEntrysheetBinding
    private lateinit var entryViewModel: EntryViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        entryViewModel = ViewModelProvider(activity).get(entryViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewEntrysheetBinding.inflate(inflater,container, false)
        return binding.root
    }

    private fun saveAction() {
        entryViewModel.cate.value = binding.entryCategory.text.toString()
        entryViewModel.name.value = binding.entryName.text.toString()
        entryViewModel.desc.value = binding.entryDesc.text.toString()
        binding.entryCategory.setText("")
        binding.entryName.setText("")
        binding.entryDesc.setText("")
    }
}