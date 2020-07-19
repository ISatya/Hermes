import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created on 18/07/20.
 */
class DependencyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.applyPlugins()
        project.configureAndroid()
        project.addDependencies()
    }

}

internal fun Project.applyPlugins(){
    plugins.apply(GradlePluginId.KOTLIN_ANDROID)
    plugins.apply(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    plugins.apply(GradlePluginId.KOTLIN_KAPT)
    plugins.apply(GradlePluginId.HILT_ANDROID_PLUGIN)
}

internal fun Project.configureAndroid() = this.extensions.getByType<BaseExtension>().apply{
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId = AndroidConfig.APPLICATION_ID
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {

        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles( getDefaultProguardFile(Proguard.ANDROID_OPTIMIZE),
                Proguard.ANDROID_DEFAULT)
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            applicationIdSuffix  = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
        }

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    project.tasks.withType(KotlinCompile::class.java).configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

    buildFeatures.viewBinding = true

}

//Add dependencies common across modules
internal fun Project.addDependencies() = dependencies.apply {
    add(ConfigurationName.IMPLEMENTATION, LibraryDependency.Hilt.ANDROID)
    add(ConfigurationName.IMPLEMENTATION, LibraryDependency.Hilt.VIEWMODEL)
    add(ConfigurationName.KAPT, LibraryDependency.Hilt.ANDROID_COMPILER)
    add(ConfigurationName.KAPT, LibraryDependency.Hilt.COMPILER)

    add(ConfigurationName.IMPLEMENTATION, LibraryDependency.KOTLIN_STDLIB)
    add(ConfigurationName.TEST_IMPLEMENTATION, TestingDependency.JUNIT)
    add(ConfigurationName.ANDROID_TEST_IMPLEMENTATION, TestingDependency.EXT_JUNIT)
}