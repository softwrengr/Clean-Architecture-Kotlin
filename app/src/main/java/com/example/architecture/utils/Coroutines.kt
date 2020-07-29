package com.example.architecture.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


object Coroutines{

    fun Main(work: suspend(() -> Unit))  =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

    fun Worker(work: suspend(() -> Unit))  =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }
}