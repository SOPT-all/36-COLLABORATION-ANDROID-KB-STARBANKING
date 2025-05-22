package org.sopt.starbanking.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.starbanking.presentation.savingsDetail.SavingsDetailScreen
import org.sopt.starbanking.ui.theme.StarBankingTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigator = rememberNavController()
            // TODO : val mainNavigator = rememberMainNavigator(navigator)

            StarBankingTheme {
                SavingsDetailScreen(
                    accountId = 2
                    // TODO: navigator = mainNavigator
                )
            }
        }
    }
}