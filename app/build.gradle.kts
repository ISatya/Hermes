plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.HERMES_PLUGIN)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(LibraryDependency.CORE_KTX)
    implementation(LibraryDependency.APP_COMPAT)
    implementation(LibraryDependency.CONSTRAINT_LAYOUT)

    implementation(LibraryDependency.NAVIGATION_FRAGMENT)
    implementation(LibraryDependency.NAVIGATION_UI)

    implementation(LibraryDependency.NAVIGATION_FRAGMENT_KTX)
    implementation(LibraryDependency.NAVIGATION_UI_KTX)

    // Testing Navigation
    androidTestImplementation(LibraryDependency.NAVIGATION_TESTING)

    androidTestImplementation(TestingDependency.ESPRESSO_CORE)
}