package com.example.newentry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.newentry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var entryViewModel: EntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        entryViewModel = ViewModelProvider(this).get(EntryViewModel::class.java)
        binding.newEntryButton.setOnClickListener {
            NewEntrysheet().show(supportFragmentManager, "newEntryTag")
        }

        entryViewModel.cate.observe(this){
            binding.entryCategory.text = String.format("Entry Category: %s", it)
        }
        entryViewModel.name.observe(this){
            binding.entryName.text = String.format("Entry Name: %s", it)
        }
        entryViewModel.desc.observe(this){
            binding.entryDesc.text = String.format("Entry Description: %s", it)
        }
    }
}