package com.commerzo.app.data.model.profile

data class StudentProfile(
    val userId: String = "",
    val displayName: String = "",
    val email: String = "",
    val phoneNumber: String? = null,
    val photoUrl: String? = null,
    val role: String = "student",
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L
)
