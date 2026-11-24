package com.example.movera.data


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val auth: FirebaseAuth
) {
    val isLoggedIn: Boolean get() = auth.currentUser != null

    suspend fun signUp(email: String, password: String): Result<Unit> = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        Result.success(Unit)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun signIn(email: String, password: String): Result<Unit> = try {
        auth.signInWithEmailAndPassword(email, password).await()
        Result.success(Unit)
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }

    fun signOut() = auth.signOut()
}

fun Throwable.toAuthMessage(): String = when (this) {
    is FirebaseAuthWeakPasswordException -> "Şifrə ən azı 6 simvol olmalıdır"
    is FirebaseAuthUserCollisionException -> "Bu e-poçt artıq qeydiyyatdan keçib"
    is FirebaseAuthInvalidCredentialsException -> "E-poçt və ya şifrə yanlışdır"
    is FirebaseAuthInvalidUserException -> "Belə hesab tapılmadı"
    else -> "Xəta baş verdi, internet bağlantısını yoxlayın"
}