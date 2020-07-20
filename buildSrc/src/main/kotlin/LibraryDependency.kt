
object ConfigurationName {
    const val IMPLEMENTATION = "implementation"
    const val TEST_IMPLEMENTATION = "testImplementation"
    const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
    const val KAPT = "kapt"
}

object LibraryVersion {
    const val KOTLIN = "1.3.72"
    const val CORE_KTX = "1.3.0"
    const val APP_COMPAT = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val NAV_VERSION = "2.3.0"
    const val MOSHI = "1.9.2"
    const val COROUTINES = "1.3.6"
    const val MATERIAL = "1.1.0"
    const val COIL = "0.9.5"

    object Hilt{
        const val ANDROID = "2.28-alpha"
        const val JETPACK = "1.0.0-alpha01"
    }

    object Network{
        const val RETROFIT = "2.9.0"
        const val OKHTTP = "4.7.2"
        const val RETROFIT_MOSHI_CONVERTER = "2.7.2"
    }

}

object LibraryDependency {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${LibraryVersion.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
    const val MATERIAL =  "com.google.android.material:material:${LibraryVersion.MATERIAL}"
    const val COIL = "io.coil-kt:coil:${LibraryVersion.COIL}"

    //Hilt
    object Hilt{
        const val ANDROID = "com.google.dagger:hilt-android:${LibraryVersion.Hilt.ANDROID}"
        const val ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${LibraryVersion.Hilt.ANDROID}"
        const val COMPILER = "androidx.hilt:hilt-compiler:${LibraryVersion.Hilt.JETPACK}"
        const val VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${LibraryVersion.Hilt.JETPACK}"
    }

    //Navigation
    object Navigation{
        //Java language implementation
        const val FRAGMENT = "androidx.navigation:navigation-fragment:${LibraryVersion.NAV_VERSION}"
        const val UI = "androidx.navigation:navigation-ui:${LibraryVersion.NAV_VERSION}"

        // Kotlin
        const val FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${LibraryVersion.NAV_VERSION}"
        const val UI_KTX = "androidx.navigation:navigation-ui-ktx:${LibraryVersion.NAV_VERSION}"

        // Testing Navigation
        const val TESTING = "androidx.navigation:navigation-testing:${LibraryVersion.NAV_VERSION}"
    }

    object Network{
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersion.Network.RETROFIT}"
        const val MOSHI_CONVERTER  = "com.squareup.retrofit2:converter-moshi:${LibraryVersion.Network.RETROFIT_MOSHI_CONVERTER}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${LibraryVersion.Network.OKHTTP}"
        const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.Network.OKHTTP}"
    }

    object Moshi{
        const val KOTLIN = "com.squareup.moshi:moshi-kotlin:${LibraryVersion.MOSHI}"
        const val KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${LibraryVersion.MOSHI}"
    }

    object Coroutines{
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersion.COROUTINES}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersion.COROUTINES}"
    }

}
