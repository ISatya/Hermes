plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.HERMES_PLUGIN)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(LibraryDependency.CORE_KTX)
    implementation(LibraryDependency.APP_COMPAT)
    implementation(LibraryDependency.CONSTRAINT_LAYOUT)

    implementation(LibraryDependency.Navigation.FRAGMENT)
    implementation(LibraryDependency.Navigation.UI)
    implementation(LibraryDependency.Navigation.FRAGMENT_KTX)
    implementation(LibraryDependency.Navigation.UI_KTX)

    //Network
    //Retrofit
    implementation(LibraryDependency.Network.RETROFIT)
    implementation(LibraryDependency.Network.MOSHI_CONVERTER)
    //okhttp
    implementation(LibraryDependency.Network.OKHTTP)
    implementation(LibraryDependency.Network.LOGGING_INTERCEPTOR)
    //Moshi
    implementation(LibraryDependency.Moshi.KOTLIN)
    implementation(LibraryDependency.Moshi.KOTLIN_CODEGEN)
    //Coroutines
    implementation(LibraryDependency.Coroutines.CORE)
    implementation(LibraryDependency.Coroutines.ANDROID)

    implementation(LibraryDependency.MATERIAL)

    androidTestImplementation(TestingDependency.ESPRESSO_CORE)
    androidTestImplementation(LibraryDependency.Navigation.TESTING)
}