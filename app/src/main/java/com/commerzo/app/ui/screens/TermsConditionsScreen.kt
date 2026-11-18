
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
import androidx.compose.material.icons.filled.Policy
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

@Composable
fun TermsConditionsScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Terms & Conditions",
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
                        imageVector = Icons.Default.Policy,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Terms of using COMMERZO",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Text(
                        text = "Please read these terms before using the COMMERZO application.",
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

            TermsSection(
                title = "1. Acceptance of Terms",
                body = """
                    By accessing or using COMMERZO, you agree to follow these Terms & Conditions and the applicable Privacy Policy.

                    If you do not agree with these terms, please stop using the application.
                """.trimIndent()
            )

            TermsSection(
                title = "2. Eligibility and Student Accounts",
                body = """
                    COMMERZO is an educational application intended for students and learners.

                    If you are under the age required to provide independent consent under applicable law, you must use the application with the involvement and permission of your parent or legal guardian.

                    You are responsible for providing accurate account information and keeping your account credentials secure.
                """.trimIndent()
            )

            TermsSection(
                title = "3. Permitted Use",
                body = """
                    You may use COMMERZO for personal learning, practice and educational purposes.

                    You agree not to:

                    • Misuse or disrupt application services
                    • Attempt unauthorized access to accounts, systems or data
                    • Upload harmful, misleading or unlawful content
                    • Copy, redistribute or commercially exploit app content without permission
                    • Interfere with the experience or security of other users
                """.trimIndent()
            )

            TermsSection(
                title = "4. Educational Content",
                body = """
                    COMMERZO provides educational resources, practice questions, tests and related learning features.

                    Content is provided for learning and revision purposes. We aim to maintain accuracy, but errors, omissions or outdated information may occur.

                    You should verify important academic information with your official board syllabus, textbooks and teachers.

                    COMMERZO does not guarantee particular examination marks, ranks, admissions or academic results.
                """.trimIndent()
            )

            TermsSection(
                title = "5. Intellectual Property",
                body = """
                    The COMMERZO name, branding, application design, original software and original content are protected by applicable intellectual property laws.

                    You may not reproduce, modify, distribute or commercially use protected materials without prior authorization.

                    Third-party materials remain subject to their respective owners' rights and licenses.
                """.trimIndent()
            )

            TermsSection(
                title = "6. Account Security and Responsibility",
                body = """
                    You are responsible for activity carried out through your account.

                    Do not share your password or verification codes with anyone.

                    If you suspect unauthorized access to your account, contact the support team.
                """.trimIndent()
            )

            TermsSection(
                title = "7. Third-Party Services",
                body = """
                    COMMERZO may depend on third-party services, including Google Firebase and authentication providers.

                    Their services may be subject to separate terms, policies, availability conditions and technical limitations.

                    COMMERZO is not responsible for independent changes or interruptions caused by third-party providers.
                """.trimIndent()
            )

            TermsSection(
                title = "8. Availability and Changes",
                body = """
                    We may update, improve, temporarily suspend or discontinue application features when necessary.

                    We aim to maintain service availability but cannot guarantee uninterrupted or error-free operation.
                """.trimIndent()
            )

            TermsSection(
                title = "9. Account Suspension or Termination",
                body = """
                    Access may be restricted or suspended where there is reasonable evidence of misuse, security risks or violations of these terms.

                    You may stop using COMMERZO at any time. Account deletion and related information requests are handled according to the Privacy Policy and applicable law.
                """.trimIndent()
            )

            TermsSection(
                title = "10. Limitation of Liability",
                body = """
                    To the extent permitted by applicable law, COMMERZO is provided on an as-available basis.

                    We do not guarantee that the application will always be available, error-free or suitable for every individual purpose.

                    Nothing in these terms excludes rights or protections that cannot legally be excluded under applicable law.
                """.trimIndent()
            )

            TermsSection(
                title = "11. Changes to These Terms",
                body = """
                    These terms may be revised when application features, policies or legal requirements change.

                    Updated terms will be published in the application with a revised date. Continued use after changes take effect may constitute acceptance where permitted by applicable law.
                """.trimIndent()
            )

            TermsSection(
                title = "12. Applicable Law",
                body = """
                    These terms are intended to operate subject to the applicable laws of India.

                    Any dispute will be handled by the appropriate legal forum in accordance with applicable law.
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
                    Text(
                        text = "Questions about these terms?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Please contact the COMMERZO support team for assistance.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
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
private fun TermsSection(
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
