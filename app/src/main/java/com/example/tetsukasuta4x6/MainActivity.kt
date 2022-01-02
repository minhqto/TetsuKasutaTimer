package com.example.tetsukasuta4x6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.tetsukasuta4x6.composables.AppTitle
import com.example.tetsukasuta4x6.composables.CountdownIndicator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContent {
            MaterialTheme {
                MainView()
            }

        }
    }

    @Composable
    private fun MainView() {
        Column {
            AppTitle()
            CountdownIndicator(
                color = R.color.teal_200,
                Modifier,
                progress = 0f,
                time = "0:00",
                size = 250,
                stroke = 12
            )
        }
    }


}