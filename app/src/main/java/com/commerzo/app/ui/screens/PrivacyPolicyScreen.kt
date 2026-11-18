
package com.commerzo.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Security
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commerzo.app.ui.theme.CommerzoDimensions
import com.commerzo.app.ui.viewmodel.settings.SettingsViewModel

@Composable
fun PrivacyPolicyScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Privacy Policy",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(
                    horizontal = CommerzoDimensions.ScreenHorizontal,
                    vertical = CommerzoDimensions.Space12
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(22.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Your privacy matters",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Text(
                        text = "This policy explains how COMMERZO handles information when you use the Android application.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        lineHeight = 22.sp
                    )

                    Text(
                        text = "Last updated: 18 November 2026",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            PrivacySection(
                title = "1. Information We Handle",
                body = """
                    Depending on the sign-in method and features you use, COMMERZO may process:

                    • Name or display name
                    • Email address
                    • Mobile number
                    • Profile photo URL provided by a sign-in provider
                    • Account identifier used to associate your profile
                    • Learning-related information such as practice activity, test results, bookmarks and progress where those features store such information
                    • App preferences such as your selected appearance and notification preference

                    Please do not submit passwords, financial details or other sensitive personal information in feedback or support messages.
                """.trimIndent()
            )

            PrivacySection(
                title = "2. Sign-in and Authentication",
                body = """
                    COMMERZO currently uses Firebase Authentication for supported sign-in methods, including Google sign-in, email and password, and phone verification.

                    Email verification may be required for email/password accounts. Authentication providers process information according to their own privacy policies and terms.
                """.trimIndent()
            )

            PrivacySection(
                title = "3. Storage and Service Providers",
                body = """
                    COMMERZO uses Google Firebase services for authentication and Cloud Firestore for student profile information.

                    Information sent to these services is processed by the relevant service provider to operate the app. Their handling of information is also governed by their own terms and privacy documentation.

                    Some app preferences are stored locally on your device.
                """.trimIndent()
            )

            PrivacySection(
                title = "4. How We Use Information",
                body = """
                    Information may be used to:

                    • Create and manage your account
                    • Authenticate your identity
                    • Display and maintain your student profile
                    • Provide learning and practice features
                    • Save relevant preferences and learning activity
                    • Respond to support requests
                    • Maintain and improve app reliability and security
                """.trimIndent()
            )

            PrivacySection(
                title = "5. Sharing of Information",
                body = """
                    We do not sell your personal information.

                    Information may be processed by service providers that help operate COMMERZO, such as Google Firebase. Information may also be disclosed when required by applicable law or to address legitimate security and abuse concerns.
                """.trimIndent()
            )

            PrivacySection(
                title = "6. Data Retention and Account Deletion",
                body = """
                    Information is retained for as long as needed to operate the relevant features, maintain records, or meet applicable legal requirements.

                    Important current limitation: deleting an account through the current Android app removes its Firebase Authentication account, but the associated Firestore profile document is not automatically deleted by that operation.

                    To request review or deletion of remaining profile information, contact the support email listed below. A deletion request may require account verification.
                """.trimIndent()
            )

            PrivacySection(
                title = "7. Security",
                body = """
                    We use services and technical measures intended to protect account and app information. However, no online service or electronic storage method can guarantee absolute security.

                    Keep your sign-in credentials private and use only the official COMMERZO app.
                """.trimIndent()
            )

            PrivacySection(
                title = "8. Children and Students",
                body = """
                    COMMERZO is an educational application that may be used by students. If you are under the age required to provide consent under applicable law, use the app with the involvement and permission of a parent or legal guardian.

                    Parents or guardians who have questions about a student's information can contact the support address below.
                """.trimIndent()
            )

            PrivacySection(
                title = "9. Changes to This Policy",
                body = """
                    This policy may be updated when app features, data practices or legal requirements change. The latest revision date will be displayed at the top of this screen.
                """.trimIndent()
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Privacy questions?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "For privacy-related questions or requests, contact:",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = SettingsViewModel.SUPPORT_EMAIL,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Text(
                text = "COMMERZO • Learn. Practice. Score.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun PrivacySection(
    title: String,
    body: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = body,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 23.sp
            )
        }
    }
}
