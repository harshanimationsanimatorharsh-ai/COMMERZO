package com.commerzo.app.data.repository.profile

import com.commerzo.app.data.model.profile.StudentProfile
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserProfileRepository {

    private val firestore = FirebaseFirestore.getInstance()

    private val usersCollection = firestore.collection("users")

    suspend fun getProfile(userId: String): Result<StudentProfile?> {
        return try {
            val snapshot = usersCollection
                .document(userId)
                .get()
                .await()

            if (!snapshot.exists()) {
                Result.success(null)
            } else {
                val profile = snapshot.toObject(StudentProfile::class.java)
                Result.success(profile)
            }
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    suspend fun createOrUpdateProfile(profile: StudentProfile): Result<Unit> {
        return try {
            usersCollection
                .document(profile.userId)
                .set(profile)
                .await()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    suspend fun updateProfile(
        userId: String,
        updates: Map<String, Any?>
    ): Result<Unit> {
        return try {
            usersCollection
                .document(userId)
                .update(updates)
                .await()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    suspend fun deleteProfile(userId: String): Result<Unit> {
        return try {
            usersCollection
                .document(userId)
                .delete()
                .await()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}
