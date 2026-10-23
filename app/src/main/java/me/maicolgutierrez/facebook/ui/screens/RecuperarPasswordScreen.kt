package me.maicolgutierrez.facebook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val RecuperarBorderGray = Color(0xFFCCD0D5)
private val RecuperarTextGray = Color(0xFF606770)
private val RecuperarDarkText = Color(0xFF1C1E21)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecuperarPasswordScreen(
    onBack: () -> Unit,
    onContinuar: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Recuperar contraseña",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = RecuperarDarkText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        // Flecha de volver hecha con texto (no necesita la librería de íconos)
                        Text(
                            text = "←",
                            fontSize = 24.sp,
                            color = RecuperarDarkText
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 24.dp)
        ) {
            HorizontalDivider(color = RecuperarBorderGray, thickness = 1.dp)

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Encuentra tu cuenta",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = RecuperarDarkText
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Introduce tu correo electrónico para buscar tu cuenta.",
                fontSize = 15.sp,
                color = RecuperarTextGray
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Correo electrónico",
                        color = RecuperarTextGray,
                        fontSize = 16.sp
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = FacebookBlue,
                    unfocusedBorderColor = RecuperarBorderGray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    cursorColor = FacebookBlue
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onContinuar(email) },
                enabled = email.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = FacebookBlue),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = "Continuar",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}