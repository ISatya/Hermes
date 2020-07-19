
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
    //Java language implementation
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment:${LibraryVersion.NAV_VERSION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui:${LibraryVersion.NAV_VERSION}"

    // Kotlin
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${LibraryVersion.NAV_VERSION}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${LibraryVersion.NAV_VERSION}"

    // Testing Navigation
    const val NAVIGATION_TESTING = "androidx.navigation:navigation-testing:${LibraryVersion.NAV_VERSION}"
}
