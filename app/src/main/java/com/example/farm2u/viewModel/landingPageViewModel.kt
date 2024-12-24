package com.example.farm2u.viewModel

import androidx.lifecycle.ViewModel
import com.example.farm2u.model.FAQItem

class LandingPageViewModel : ViewModel() {

    // List of FAQs
    val faqItems = listOf(
        FAQItem("What is FARM2U?", "FARM2U is a platform that connects farmers with consumers directly."),
        FAQItem("How do I sell on FARM2U?", "To sell, click on the 'Sell' button and follow the steps to list your products."),
        FAQItem("How do I buy products?", "To buy products, click on the 'Buy' button and explore our product range."),
        FAQItem("What payment methods are supported?", "We support all major credit cards, debit cards, and digital wallets."),
        FAQItem("Is delivery available?", "Yes, we provide doorstep delivery for all listed products.")
    )
}


