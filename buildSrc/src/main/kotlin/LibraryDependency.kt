
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
    const val HILT_VERSION = "2.28-alpha"
    const val NAV_VERSION = "2.3.0"
    const val MOSHI = "1.9.2"

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

    //Hilt
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${LibraryVersion.HILT_VERSION}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:2.28-alpha"

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

}
