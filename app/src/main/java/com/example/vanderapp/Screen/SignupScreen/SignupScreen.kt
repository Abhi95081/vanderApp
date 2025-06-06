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

@OptIn(ExperimentalMaterial3Api::class)
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB))))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = Color(0xFF0D47A1),
            modifier = Modifier
                .size(80.dp)
                .padding(top = 32.dp)
        )

        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF0D47A1),
            modifier = Modifier.padding(top = 12.dp)
        )

        Text(
            text = "Create a new account below",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = shape,
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
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
                CustomTextField(value = userAddress, onValueChange = { userAddress = it }, label = "Address", icon = Icons.Default.Home, minLines = 2)
                CustomTextField(value = userpincode, onValueChange = { userpincode = it }, label = "Pincode", icon = Icons.Default.LocationOn, keyboardType = KeyboardType.Number)

                Button(
                    onClick = { /* Signup logic */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .shadow(4.dp, shape),
                    shape = shape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
                ) {
                    Text("Sign Up", fontSize = 16.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
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
        leadingIcon = { Icon(imageVector = icon, contentDescription = null) },
        trailingIcon = if (isPassword) {
            {
                IconButton(onClick = { onTogglePassword?.invoke() }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.ArrowForward else Icons.Default.ArrowBack,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        } else null,
        visualTransformation = if (isPassword && !showPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        singleLine = minLines == 1,
        modifier = Modifier.fillMaxWidth()
    )
}
