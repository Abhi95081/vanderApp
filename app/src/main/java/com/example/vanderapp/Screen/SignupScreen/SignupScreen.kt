package com.example.vanderapp.Screen.SignupScreen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SignupScreen() {
    val shape = RoundedCornerShape(20.dp)

    var username by remember { mutableStateOf("") }
    var userpass by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var userphone by remember { mutableStateOf("") }
    var useremail by remember { mutableStateOf("") }
    var userpincode by remember { mutableStateOf("") }
    var userAddress by remember { mutableStateOf("") }

    var isCardClicked by remember { mutableStateOf(false) }

    // 💡 Fixed single color animation
    val cardColor by animateColorAsState(
        targetValue = if (isCardClicked) Color(0xFFFFF8E1) else Color(0xFFE1F5FE),
        label = "Card Color Animation"
    )

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = if (isCardClicked)
                        listOf(Color(0xFFFFECB3), Color(0xFFFFCC80))
                    else
                        listOf(Color(0xFFE3F2FD), Color(0xFF90CAF9))
                )
            )
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Your Account",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF0D47A1)
        )
        Text(
            text = "Sign up to continue",
            color = Color.DarkGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 12.dp, shape = shape)
                .combinedClickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = true),
                    onClick = { isCardClicked = !isCardClicked }
                ),
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = cardColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = userpass,
                    onValueChange = { userpass = it },
                    label = { Text("Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                    trailingIcon = {
                        val icon = if (showPassword) Icons.Default.KeyboardArrowLeft else Icons.Default.KeyboardArrowRight
                        IconButton(onClick = { showPassword = !showPassword }) {
                            Icon(icon, contentDescription = "Toggle Password")
                        }
                    },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = userphone,
                    onValueChange = { userphone = it },
                    label = { Text("Phone Number") },
                    leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = useremail,
                    onValueChange = { useremail = it },
                    label = { Text("Email Address") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = userAddress,
                    onValueChange = { userAddress = it },
                    label = { Text("Address") },
                    leadingIcon = { Icon(Icons.Default.Home, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )

                OutlinedTextField(
                    value = userpincode,
                    onValueChange = { userpincode = it },
                    label = { Text("Pincode") },
                    leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = { /* Handle signup */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = shape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues()
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient(
                                    listOf(Color(0xFFFFC107), Color(0xFF42A5F5))
                                ),
                                shape = shape
                            )
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Sign Up", fontSize = 17.sp)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}
