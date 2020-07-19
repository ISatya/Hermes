private object TestVersions {
    const val JUNIT = "4.12"
    const val EXT_JUNIT = "1.1.1"
    const val ESPRESSO_CORE = "3.2.0"
}

object TestingDependency {
    const val JUNIT = "junit:junit:${TestVersions.JUNIT}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${TestVersions.EXT_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${TestVersions.ESPRESSO_CORE}"
}
