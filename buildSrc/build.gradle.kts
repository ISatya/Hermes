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

dependencies {
    /* Depend on the android gradle plugin, since we want to access it in our plugin */
    implementation("com.android.tools.build:gradle:4.0.0")

    /* Example Dependency */
    /* Depend on the kotlin plugin, since we want to access it in our plugin */
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")

    /* Depend on the default Gradle API's since we want to build a custom plugin */
    implementation(gradleApi())
}