package com.example.gpt_tests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gpt_tests.ui.theme.Gpt_TestsTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Gpt_TestsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel:userViewModel = hiltViewModel()
                    val list = viewModel.getData()
                    DisplayData(list,innerPadding)

                }
            }
        }
    }
}

@Composable
fun DisplayData(list:List<String>,padding:PaddingValues){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()) {
            items(list.size){index->
                Text(
                    modifier = Modifier
                    .fillMaxWidth(),
                    text = list[index],
                    fontSize = 30.sp)
            }
        }
    }
}