plugins {
    `kotlin-dsl`
}

// The kotlin-dsl plugin requires a repository to be declared
repositories {
    jcenter()
    google()
}

gradlePlugin {
    plugins {
        register("com.plugin.hermes") {
            id = "com.plugin.hermes"
            implementationClass = "DependencyPlugin"
        }
    }
}

object CoreVersions{
    const val GRADLE = "4.0.0"
    const val KOTLIN = "1.3.72"
    const val HILT = "2.28-alpha"
}

object Dependencies{
    const val GRADLE = "com.android.tools.build:gradle:${CoreVersions.GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${CoreVersions.KOTLIN}"
    const val HILT_ANDROID_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${CoreVersions.HILT}"
}

dependencies {
    /* Depend on the default Gradle API's since we want to build a custom plugin */
    implementation(gradleApi())
    /* Depend on the android gradle plugin, since we want to access it in our plugin */
    implementation(Dependencies.GRADLE)

    /* Example Dependency */
    /* Depend on the kotlin plugin, since we want to access it in our plugin */
    implementation(Dependencies.KOTLIN_GRADLE_PLUGIN)

    implementation(Dependencies.HILT_ANDROID_GRADLE_PLUGIN)

}