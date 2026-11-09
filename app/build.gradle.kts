plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.gizza_3tib"

    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.gizza_3tib"
        minSdk = 29
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.gridlayout:gridlayout:1.0.0") // Tahap 4: GridLayout
    implementation("androidx.viewpager2:viewpager2:1.1.0") // Tahap 5: ViewPager2
    implementation("com.tbuonomo:dotsindicator:5.1.0") // Tahap 6: DotsIndicator
    implementation("androidx.recyclerview:recyclerview:1.3.2") // Tahap 3 dan 4: RecyclerView
    implementation("com.github.bumptech.glide:glide:4.16.0") // Tahap 4: memuat gambar dari URL
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}