plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.commerzo.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.commerzo.app"
        minSdk = 24
        targetSdk = 36
        versionCode = 6
        versionName = "5.3.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            val keystorePath =
                System.getenv("COMMERZO_KEYSTORE_FILE")

            if (!keystorePath.isNullOrBlank()) {
                storeFile = file(keystorePath)
                storePassword =
                    System.getenv("COMMERZO_KEYSTORE_PASSWORD")
                keyAlias =
                    System.getenv("COMMERZO_KEY_ALIAS")
                keyPassword =
                    System.getenv("COMMERZO_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        getByName("debug") {
            // Keep normal Android debug signing.
        }

        getByName("release") {
            signingConfig =
                signingConfigs.getByName("release")

            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes +=
                "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(
            org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
        )

        optIn.add(
            "androidx.compose.material3.ExperimentalMaterial3Api"
        )
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.activity:activity-compose:1.11.0")

    implementation(
        platform(
            "androidx.compose:compose-bom:2025.09.01"
        )
    )

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation(
        "androidx.lifecycle:lifecycle-runtime-ktx:2.9.3"
    )

    implementation(
        "androidx.lifecycle:lifecycle-viewmodel-compose:2.9.3"
    )

    implementation(
        "androidx.navigation:navigation-compose:2.9.4"
    )

    implementation(
        "androidx.compose.material:material-icons-extended"
    )

    debugImplementation(
        "androidx.compose.ui:ui-tooling"
    )

    // Firebase
    implementation(
        platform(
            "com.google.firebase:firebase-bom:34.19.0"
        )
    )

    implementation(
        "com.google.firebase:firebase-auth"
    )

    // Google Sign-In / Credential Manager
    implementation(
        "androidx.credentials:credentials:1.3.0"
    )

    implementation(
        "androidx.credentials:credentials-play-services-auth:1.3.0"
    )

    implementation(
        "com.google.android.libraries.identity.googleid:googleid:1.1.1"
    )
}
