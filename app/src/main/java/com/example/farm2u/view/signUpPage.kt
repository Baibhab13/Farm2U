package com.example.farm2u.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm2u.R
import com.example.farm2u.viewModel.signUpViewModel

@Composable
fun SignUp(navController: NavHostController, viewModel: signUpViewModel = viewModel()) {
    Column (
        modifier = Modifier.fillMaxSize().background(color = Color(0xFFF7F7F7)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        IconButton(
            onClick = { navController.navigate("buylogin") },
        ){
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        Text(
            text = "Sign Up",
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.Start).padding(start = 10.dp)
        )

        Text(
            text = "Register with your valid credentials",
            fontSize = 15.sp,
            modifier = Modifier.align(Alignment.Start).padding(start = 10.dp, top = 5.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.farming),
            contentDescription = "why choose farm2u",
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp, start = 30.dp, bottom = 20.dp)
                .aspectRatio(16 / 7f)
                .clip(RoundedCornerShape(topStart = 150.dp, bottomStart = 150.dp)),
            contentScale = ContentScale.FillWidth
        )

        Form(navController, viewModel)

    }
}

@Composable
fun Form(navController: NavHostController, viewModel: signUpViewModel) {
    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Name",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(top = 5.dp)
        )
        OutlinedTextField(
            value = viewModel.name.value,
            onValueChange = { viewModel.name.value = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Email",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(top = 5.dp)
        )
        OutlinedTextField(
            value = viewModel.eemail.value,
            onValueChange = { viewModel.eemail.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "New Password",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(top = 5.dp)
        )
        OutlinedTextField(
            value = viewModel.newpassword.value,
            onValueChange = { viewModel.newpassword.value = it },
            label = { Text("New Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Confirm Password",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start).padding(top = 5.dp)
        )
        OutlinedTextField(
            value = viewModel.confirmpassword.value,
            onValueChange = { viewModel.confirmpassword.value = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
                .clip(RectangleShape)
        ) {
            Text(
                text = "Sign Up",
            )
        }

        Row() {
            Text(
                text = "Already have an account?",
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterVertically).padding(top = 10.dp)
            )
            Text(
                text = "Login",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.c5),
                modifier = Modifier.align(Alignment.CenterVertically).padding(top = 10.dp, start = 5.dp)
                    .clickable { navController.navigate("buylogin") }
            )
        }

    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUp(navController = rememberNavController())
}
