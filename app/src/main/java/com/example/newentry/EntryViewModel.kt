package com.example.newentry

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EntryViewModel: ViewModel() {

    var cate = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var desc = MutableLiveData<String>()
}