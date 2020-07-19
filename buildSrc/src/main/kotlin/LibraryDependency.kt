
//object ConfigurationName {
//    const val IMPLEMENTATION = "implementation"
//    const val TEST_IMPLEMENTATION = "testImplementation"
//    const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
//}

object LibraryVersion {
    const val KOTLIN = "1.3.72"
    const val CORE_KTX = "1.3.0"
    const val APP_COMPAT = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"
}

object LibraryDependency {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${LibraryVersion.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"
}
