plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
    id ("kotlin-kapt")
}

android {
    namespace = "com.tripplanner"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.tripplanner"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding {
        enable=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    kapt (libs.androidx.room.compiler)
    implementation (libs.play.services.maps)
    //implementation (libs.firebase.auth)
    implementation (libs.firebase.firestore)
    implementation (libs.firebase.database)
    implementation (libs.firebase.messaging)
    implementation (libs.material.v190)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // Room Database
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.ktx)


    // WorkManager (for background tasks and syncing offline data)
    implementation (libs.androidx.work.runtime.ktx)

    // Material Design Components
    implementation (libs.material.v161)

    // Gson (for data serialization)
    implementation (libs.gson)

    // Unit testing dependencies
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit.v115)
    androidTestImplementation (libs.androidx.espresso.core.v350)
    implementation(libs.firebase.messaging)
    implementation(platform(libs.firebase.bom))
    implementation(libs.google.firebase.auth)

    /*implementation ("android.arch.persistence.room:runtime:1.1.1")*/
    /*annotationProcessor ("android.arch.persistence.room:compiler:1.0.0")*/

}