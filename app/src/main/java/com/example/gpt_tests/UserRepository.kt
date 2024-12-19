package com.example.gpt_tests

import javax.inject.Singleton

@Singleton
class UserRepository {
    fun getData():List<String> = listOf("Nagy,Hany,Malak,Ahmed,Mohammed,ALi, Sameh,Bashar,Arafa,Mostafa")
}