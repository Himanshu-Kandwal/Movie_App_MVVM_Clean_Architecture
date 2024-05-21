plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp") version ("1.9.0-1.0.13") //latest version as per kotlin version mentioned in libs.versions.toml file

}

android {
    namespace = "com.movieappmvvmcleanarchitecture"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.movieappmvvmcleanarchitecture"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"bd723a47381a52936a4fa42448409fa1\"")
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
    buildFeatures {
        dataBinding = true
        buildConfig = true
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


    /*
    older style

    val lifecycleVersion = "2.6.2"
     val roomVersion = "2.6.1"
     val daggerVersion = "2.42"
     val retrofitVersion = "2.9.0"
     val glideVersion = "4.13.2"

    implementation("androidx.room:room-runtime:$roomVersion")
     ksp("androidx.room:room-compiler:$roomVersion")
     implementation("androidx.room:room-ktx:$roomVersion")

     implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
     implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
     implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion")
     // kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
     implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

     //Coroutines
     implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

     //Dagger
     implementation("com.google.dagger:dagger:$daggerVersion")
     ksp("com.google.dagger:dagger-compiler:$daggerVersion")

     //Retrofit
     implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
     implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
     implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")

     //Glide
     implementation("com.github.bumptech.glide:glide:$glideVersion")
     annotationProcessor("com.github.bumptech.glide:compiler:$glideVersion")

     implementation("androidx.core:core-ktx:1.12.0")
     implementation("androidx.appcompat:appcompat:1.6.1")
     implementation("com.google.android.material:material:1.11.0")
     implementation("androidx.constraintlayout:constraintlayout:2.1.4")
     testImplementation("junit:junit:4.13.2")
     androidTestImplementation("androidx.test.ext:junit:1.1.5")
     androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")*/


    //migrated kapt to ksp and groovy to dsl
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.room.ktx)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    // kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
    implementation(libs.androidx.lifecycle.common.java8)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)

    //Dagger
    implementation(libs.dagger)
    ksp(libs.google.dagger.compiler)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    //Glide
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)


}