plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.client_dsa"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.client_dsa"
        minSdk = 24
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.squareup.okhttp3:okhttp:3.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.11.0")
    implementation ("com.github.bumptech.glide:glide:4.7.1")
    implementation("com.squareup.retrofit2:retrofit:2.1.0")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")
    implementation ("com.squareup.picasso:picasso:2.71828")// Per fer servir Picasso per les imatges de la Botiga
// Junit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.0.0")
    //testRuntime("org.junit.jupiter:junit-jupiter-engine:5.0.0")
// to run JUnit 3/4 tests:
    testImplementation("junit:junit:4.12")
    //testRuntime("org.junit.vintage:junit-vintage-engine:4.12.0")
}