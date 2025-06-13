plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "treiner.bootcamp2_toast_avisos_snackbar_notificacao_com_opcoes_de_acao"
    compileSdk = 35

    defaultConfig {
        applicationId = "treiner.bootcamp2_toast_avisos_snackbar_notificacao_com_opcoes_de_acao"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

        // Necessario para usar LocalDate na api inferiro a 26
        isCoreLibraryDesugaringEnabled = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Dependencia para usar LocalDate ou LocalDateTime em API inferiro a 26
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    // Biblioteca Glide para Mostrar o gif
    implementation("com.github.bumptech.glide:glide:4.11.0")

}