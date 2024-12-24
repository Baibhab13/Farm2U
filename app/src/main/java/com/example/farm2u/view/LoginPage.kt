package com.example.farm2u.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm2u.R
import com.example.farm2u.viewModel.BuyLoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: BuyLoginViewModel = viewModel() ) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Costumers\nGet Fresh Products",
            fontSize = 20.sp,
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.no_bg_logo_2),
            contentDescription = "login image",
            modifier = Modifier.size(200.dp),
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 2.dp),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ){

            TextButton(
                onClick = { navController.navigate("forgot") },
            ) {
                Text(
                    text = "Forgot Password?",
                    color = Color.Black,
                )
            }
        }

        Button(
            onClick = {
                navController.navigate("scaffold")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Login",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Don't have an account?",
                color = Color.Black,
                modifier = Modifier.padding(2.dp),
            )
            Text(
                text = "Sign Up",
                color = Color.Blue,
                modifier = Modifier
                    .padding(2.dp)
                    .clickable { navController.navigate("signup") }
            )
        }

        HorizontalDivider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.padding(20.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google logo",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook logo",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}