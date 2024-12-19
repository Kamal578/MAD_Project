plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt) // Add KAPT plugin for Room
}

android {
    namespace = "com.example.musicalquizproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.musicalquizproject"
        minSdk = 29
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Retrofit for network requests
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    // Glide for image loading
    implementation(libs.glide)

    // Room for local database
    implementation(libs.room.runtime)
    kapt(libs.room.compiler)

    // RecyclerView for lists
    implementation(libs.recyclerview)

    // ViewModel and LiveData
    implementation(libs.lifecycle.viewmodel)

    // Media support
    implementation(libs.media)

    // Test Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
