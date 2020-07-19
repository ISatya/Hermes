plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.HERMES_PLUGIN)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(LibraryDependency.KOTLIN_STDLIB)
    implementation(LibraryDependency.CORE_KTX)
    implementation(LibraryDependency.APP_COMPAT)
    implementation(LibraryDependency.CONSTRAINT_LAYOUT)
    testImplementation(TestingDependency.JUNIT)
    androidTestImplementation(TestingDependency.EXT_JUNIT)
    androidTestImplementation(TestingDependency.ESPRESSO_CORE)
}