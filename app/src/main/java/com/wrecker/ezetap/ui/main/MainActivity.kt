package com.wrecker.ezetap.ui.main

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wrecker.ezetap.ui.components.AppToolbar
import com.wrecker.ezetap.ui.theme.EzetapTheme
import com.wrecker.ezetap.ui.utils.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var state: MainViewState
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            state = viewModel.state.collectAsState().value
            navController = rememberNavController()

            val scaffoldState = rememberScaffoldState()
            val navBackStackEntry = navController.currentBackStackEntry
            val currentDestination = navBackStackEntry?.destination
            EzetapTheme {
                Box(Modifier.fillMaxSize()) {


                    Scaffold(
                        scaffoldState = scaffoldState,
                        topBar = {

                            AppToolbar(
                                modifier = Modifier.fillMaxWidth(),
                                title = state.uiData?.`heading-text` ?: "Assignment",
                                icon = { /*TODO*/ }) {

                            }
                        }
                    ) {

                        NavHost(
                            navController = navController,
                            startDestination = if (state.shouldShowProgress || state.uiData == null) Routes.HOME
                            else Routes.DETAILS
                        ) {
                            composable(route = Routes.HOME) {
                                HomeScreen(state = state, navController = navController)
                            }
                            composable(route = Routes.DETAILS) {
                                DetailsScreen(
                                    state,
                                    navController,
                                    onValueChanged = { key, value ->
                                        when (key) {
                                            "text_name" -> viewModel.updateNameValue(value)
                                            "text_phone" -> viewModel.updatePhoneValue(value)
                                            "text_city" -> viewModel.updateCityValue(value)
                                        }
                                    })
                            }
                        }
                    }

                }
            }
        }
    }

    @Composable
    private fun HomeScreen(state: MainViewState, navController: NavHostController) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {

            OutlinedButton(
                onClick = {
                    viewModel.fetchUi("")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Text(text = "Fetch UI Element")
            }
        }
    }

    @Composable
    private fun DetailsScreen(
        state: MainViewState,
        navController: NavHostController,
        onValueChanged: (String, String) -> Unit
    ) {

        Log.d(TAG, state.uiData?.uidata?.get(0)?.value.toString())
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            state.uiData?.let {
                var label = ""
                items(it.uidata) { item ->

                    when (item.uitype?.trim()) {
                        "label" -> label = item.value.toString()
                        "edittext" -> {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        paddingValues = PaddingValues(
                                            vertical = 8.dp,
                                            horizontal = 32.dp
                                        )
                                    ),
                                value = when (item.key) {
                                    "text_name" -> state.textName
                                    "text_phone" -> state.textPhone
                                    "text_city" -> state.textCity
                                    else -> ""
                                },
                                onValueChange = {
                                    item.key?.let { it1 ->
                                        onValueChanged(
                                            it1,
                                            it
                                        )
                                    }
                                },
                                label = { Text(label) },

                                )
                        }
                        "button" -> OutlinedButton(
                            onClick = { navController.navigate(Routes.DETAILS) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp)
                        ) {
                            Text(text = item.value.toString())
                        }
                    }
                }
            }
        }
    }
}