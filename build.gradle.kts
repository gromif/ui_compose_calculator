plugins {
    alias(libs.plugins.astracrypt.android.library)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.nevidimka655.compose_calculator"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")

        buildFeatures.compose = true
    }
}

dependencies {
    api(project(mapOf("path" to ":ui:compose-core")))
}