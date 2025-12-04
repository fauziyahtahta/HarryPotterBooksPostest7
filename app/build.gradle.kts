plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.fauziyah252.harrypotterbooks"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.fauziyah252.harrypotterbooks"
        minSdk = 24
        targetSdk = 36
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // 1. Retrofit & Gson (Versi TERBARU sesuai SS lo)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
// 2. Logging Interceptor (Biar bisa liat log API kayak di SS lo)
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
// 3. RecyclerView (Sama)
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")
// --- BAGIAN INI JANGAN DIHAPUS BIAR GAMBAR MUNCUL & GAK LAG ---
// 4. Glide (Buat nampilin gambar cover buku)
    implementation("com.github.bumptech.glide:glide:4.16.0")
// 5. Coroutines (Buat proses background biar HP gak nge-freeze)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
}