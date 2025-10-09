plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "devatomicfull.bootcamp8_stream_online_video_or_play_video_from_the_device"
    compileSdk = 36

    defaultConfig {
        applicationId = "devatomicfull.bootcamp8_stream_online_video_or_play_video_from_the_device"
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

    //exoplayer google
    implementation("androidx.media3:media3-exoplayer:1.5.1") // player
    implementation("androidx.media3:media3-ui:1.5.1") // PlayerView (opcional)
}