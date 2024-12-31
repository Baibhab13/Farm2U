package com.example.farm2u.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.farm2u.R
import android.content.Context
import android.content.res.Configuration
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

import com.example.farm2u.model.FAQItem
import com.example.farm2u.viewModel.LandingPageViewModel

@Composable
fun LandingPage(navController: NavHostController, viewModel: LandingPageViewModel = viewModel()) {
    var selectedLanguage by remember { mutableStateOf("English") }
    val context = LocalContext.current  // Get current context
    val faqItems = viewModel.faqItems

    // Recompose when the language changes
    LaunchedEffect(selectedLanguage) {
        // Update locale whenever language changes
        setLocale(context, selectedLanguage)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Language Selector
        LanguageSelector(
            selectedLanguage = selectedLanguage,
            onLanguageChange = { newLanguage ->
                if (newLanguage != selectedLanguage) {
                    selectedLanguage = newLanguage
                }
            }
        )

        Header(navController)

        Text(
            text = stringResource(id = R.string.why_choose_farm2u),  // Use string resource
            fontSize = 32.sp,
            color = colorResource(id = R.color.teal_700),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.features_img),
            contentDescription = "why choose farm2u",
        )

        FAQSection(faqItems)
        Footer(navController)
    }
}

@Composable
fun LanguageSelector(selectedLanguage: String, onLanguageChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Column {
            // Dropdown trigger button
            Button(onClick = { expanded = !expanded }) {
                Text(text = selectedLanguage)
            }

            // Dropdown menu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // Toggle languages
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onLanguageChange("Hindi")
                    },
                    text = { Text(text = "English") }
                )
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        onLanguageChange("English")
                    },
                    text = { Text(text = "Hindi") }
                )
            }
        }
    }
}

// Set the Locale based on selected language
fun setLocale(context: Context, language: String) {
    val locale = when (language) {
        "Hindi" -> Locale("hi")
        else -> Locale("en")
    }
    Locale.setDefault(locale)

    val config = context.resources.configuration
    config.setLocale(locale)

    // Update the configuration context to reflect the new locale
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}

@Composable
fun Header(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.bg_logo_landing_page_03),
            contentDescription = "background logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.aspectRatio(16f / 8f)
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(bottom = 40.dp, end = 5.dp)
        ) {
            Text(
                text = "Fresh from Farm,",
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.End),
                color = colorResource(id = R.color.c1),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Direct to your doorstep",
                fontSize = 25.sp,
                color = colorResource(id = R.color.c1),
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp)
        ) {
            Button(
                onClick = { navController.navigate("login / sell") },
                modifier = Modifier.padding(end = 1.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.c1)
                )
            ) {
                Text(
                    text = "Sell",
                    color = Color.Black,
                    fontSize = 15.sp
                )
            }

            Button(
                onClick = { navController.navigate("login / buy") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.c1)
                ),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = "Buy",
                    color = Color.Black,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun FAQSection(faqItems: List<FAQItem>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Frequently Asked Questions",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        faqItems.forEach { faqItem ->
            FAQItemCard(faqItem)
        }
    }
}

@Composable
fun FAQItemCard(faqItem: FAQItem) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (expanded) colorResource(id = R.color.c2) else colorResource(id = R.color.c1)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = faqItem.question,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (expanded) colorResource(id = R.color.c1) else colorResource(id = R.color.teal_700)
            )

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically() + fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = faqItem.answer,
                    fontSize = 16.sp,
                    color = if (expanded) colorResource(id = R.color.c1) else colorResource(id = R.color.teal_700),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Footer(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = colorResource(id = R.color.teal_700))
    ) {
        Text(
            text = "About Us",
            fontSize = 25.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, bottom = 5.dp, top = 10.dp)
                .clickable { navController.navigate("about us") },
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Copyright @ 2024 Farm2U\n" +
                    "Privacy Policy\n" +
                    "Terms of Service\n" +
                    "Career",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, bottom = 5.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook logo",
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Image(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "LinkedIn logo",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
