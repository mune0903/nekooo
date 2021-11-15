package com.mune0903.nuko.core.entity

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: String,
    val url: String,
    val breeds: List<Breed>
)
