plugins {
    alias(libs.plugins.astracrypt.android.library)
    alias(libs.plugins.astracrypt.android.library.compose)
}

android {
    namespace = "com.nevidimka655.compose_calculator"
}

dependencies {
    implementation(projects.features.calculator.domain)

    implementation(libs.lifecycle.viewmodel.compose)
}