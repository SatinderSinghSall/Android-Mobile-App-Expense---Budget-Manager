package com.example.expensebudgetmanager.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.expensebudgetmanager.data.repository.AuthRepository
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    // Firebase Auth Repo
    val repo = AuthRepository()
    val scope = rememberCoroutineScope()

    // Input states
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    // Validation errors
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    // Loading + error handling
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {}
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 28.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            Spacer(Modifier.height(30.dp))

            Text(
                text = "Welcome Back 👋",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Text(
                text = "Log in to continue tracking your expenses.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(12.dp))

            // EMAIL
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = false
                },
                label = { Text("Email Address") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                isError = emailError
            )

            if (emailError) {
                Text(
                    text = "Enter a valid email address",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // PASSWORD
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = false
                },
                label = { Text("Password") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                isError = passwordError,
                visualTransformation =
                    if (showPassword) VisualTransformation.None
                    else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = if (showPassword)
                                Icons.Default.Visibility
                            else Icons.Default.VisibilityOff,
                            contentDescription = "Toggle Password"
                        )
                    }
                }
            )

            if (passwordError) {
                Text(
                    text = "Password must be at least 6 characters.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // 🔥 Firebase error
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            // 🔄 Loading
            if (isLoading) {
                CircularProgressIndicator()
            }

            Spacer(Modifier.height(12.dp))

            // LOGIN BUTTON
            Button(
                onClick = {
                    emailError = email.isBlank() || !email.contains("@")
                    passwordError = password.length < 6

                    if (!emailError && !passwordError) {
                        isLoading = true
                        errorMessage = ""

                        scope.launch {
                            val result = repo.login(email, password)
                            isLoading = false

                            if (result.isSuccess) {
                                navController.navigate("dashboard") {
                                    popUpTo("login") { inclusive = true }
                                }
                            } else {
                                errorMessage = result.exceptionOrNull()?.message ?: "Login failed"
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text("Log In")
            }

            // SIGNUP LINK
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Don't have an account?",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate("signup")
                    }
                )
            }

            Spacer(Modifier.height(18.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}
