package com.mune0903.nuko.core.entity

import kotlinx.serialization.Serializable

@Serializable
data class Breed(
    val name: String,
    val description: String
)
