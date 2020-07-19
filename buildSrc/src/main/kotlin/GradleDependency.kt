object GradlePluginVersion {
    const val ANDROID_GRADLE = "4.0.0"
}

object GradlePlugin {
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${GradlePluginVersion.ANDROID_GRADLE}"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibraryVersion.KOTLIN}"
}

object GradlePluginId {
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val HERMES_PLUGIN = "com.plugin.hermes"
}
