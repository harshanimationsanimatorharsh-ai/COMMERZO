
package com.commerzo.app.data.model.progress

data class StudentProgress(
    val userId: String = "",
    val lifetimeXpUnits: Long = 0L,
    val weeklyXpUnits: Long = 0L,
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastActiveDate: String = "",
    val seasonId: String = "",
    val totalActiveSeconds: Long = 0L,
    val totalCorrectAnswers: Long = 0L,
    val updatedAt: Long = 0L
) {
    val lifetimeXp: Double
        get() = lifetimeXpUnits / 2.0

    val weeklyXp: Double
        get() = weeklyXpUnits / 2.0
}
