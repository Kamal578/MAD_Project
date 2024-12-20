plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures{
        buildConfig=true
        viewBinding=true
    }

    testOptions {
        targetSdk = 34
    }
    lint {
        targetSdk = 34
    }


}

dependencies {
    implementation(Deps.appCompat)
    implementation(Deps.core)
    implementation(Deps.androidMaterial)
    api(AndroidLibraries.lifecycleRuntime)
    api(Glide.glide)
    implementation(Glide.annotationProcessor)
    implementation(CircularProgressBar.swipeRefresh)
}