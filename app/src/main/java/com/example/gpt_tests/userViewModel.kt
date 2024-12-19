package com.example.gpt_tests

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class userViewModel@Inject constructor(
    val repo : UserRepository
) : ViewModel() {
    fun getData() = repo.getData()
}