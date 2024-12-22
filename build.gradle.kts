plugins {
    alias(libs.plugins.astracrypt.android.library)
    alias(libs.plugins.astracrypt.android.library.compose)
}

android {
    namespace = "com.nevidimka655.compose_calculator"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}