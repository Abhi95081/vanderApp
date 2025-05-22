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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun SignupScreen() {
    val shape = RoundedCornerShape(16.dp)

    var username by remember { mutableStateOf("") }
    var userpass by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var userphone by remember { mutableStateOf("") }
    var useremail by remember { mutableStateOf("") }
    var userpincode by remember { mutableStateOf("") }
    var userAddress by remember { mutableStateOf("") }

    val cardColor by animateColorAsState(
        targetValue = Color.White,
        label = "Card Color Animation"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFBBDEFB), Color(0xFF90CAF9))
                )
            )
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "App Logo",
            tint = Color(0xFF0D47A1),
            modifier = Modifier.size(72.dp)
        )

        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF0D47A1)
        )

        Text(
            text = "Sign up to get started",
            color = Color.DarkGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, shape),
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = cardColor),
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextField(value = username, onValueChange = { username = it }, label = "Username", icon = Icons.Default.Person)
                CustomTextField(
                    value = userpass,
                    onValueChange = { userpass = it },
                    label = "Password",
                    icon = Icons.Default.Lock,
                    isPassword = true,
                    showPassword = showPassword,
                    onTogglePassword = { showPassword = !showPassword }
                )
                CustomTextField(value = userphone, onValueChange = { userphone = it }, label = "Phone", icon = Icons.Default.Phone, keyboardType = KeyboardType.Phone)
                CustomTextField(value = useremail, onValueChange = { useremail = it }, label = "Email", icon = Icons.Default.Email, keyboardType = KeyboardType.Email)
                CustomTextField(value = userAddress, onValueChange = { userAddress = it }, label = "Address", icon = Icons.Default.Home, minLines = 3)
                CustomTextField(value = userpincode, onValueChange = { userpincode = it }, label = "Pincode", icon = Icons.Default.LocationOn, keyboardType = KeyboardType.Number)

                Button(
                    onClick = { /* Handle signup */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = shape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF42A5F5),
                        contentColor = Color.White
                    )
                ) {
                    Text("Sign Up", fontSize = 17.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    isPassword: Boolean = false,
    showPassword: Boolean = false,
    onTogglePassword: (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    minLines: Int = 1
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null) },
        trailingIcon = if (isPassword) {
            {
                val visibilityIcon = if (showPassword) Icons.Default.ArrowForward else Icons.Default.ArrowBack
                IconButton(onClick = { onTogglePassword?.invoke() }) {
                    Icon(visibilityIcon, contentDescription = "Toggle password visibility")
                }
            }
        } else null,
        visualTransformation = if (isPassword && !showPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = minLines == 1,
        minLines = minLines,
        modifier = Modifier.fillMaxWidth()
    )
}
