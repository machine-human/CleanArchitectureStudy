object ConfigVersions {
    const val GRADLE_VERSION = "4.2.0-beta05"
    const val KOTLIN_VERSION = "1.5.10"
}

object LibraryVersions {
    const val RXKOTLIN_VERSION = "3.0.1"
    const val RETROFIT_VERSION = "2.9.0"
    const val OKHTTP_VERSION = "5.0.0-alpha.2"
    const val GSON_VERSION = "2.8.7"
    const val LIFECYCLE_VERSION = "2.3.1"
    const val CORE_KTX_VERSION = "1.5.0"
    const val APPCOMPAT_VERSION = "1.3.0"
    const val MATERIAL_VERSION = "1.3.0"
    const val CONSTRAINTLAYOUT_VERSION = "2.0.4"
    const val ACTIVITY_KTX_VERSION = "1.3.0-beta01"
    const val GOOGLE_HILT_VERSION = "2.36"
    const val ANDROID_HILT_VERSION = "1.0.0-alpha03"
}

object ProjectConfig {
    const val GRADLE = "com.android.tools.build:gradle:${ConfigVersions.GRADLE_VERSION}"
    const val HILT_ANDROID_GRADLE_PLUGIN =
        "com.google.dagger:hilt-android-gradle-plugin:${LibraryVersions.GOOGLE_HILT_VERSION}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${ConfigVersions.KOTLIN_VERSION}"
}

object Libraries {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${ConfigVersions.KOTLIN_VERSION}"
    const val CORE_KTX = "androidx.core:core-ktx:${LibraryVersions.CORE_KTX_VERSION}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${LibraryVersions.APPCOMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${LibraryVersions.MATERIAL_VERSION}"
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:${LibraryVersions.CONSTRAINTLAYOUT_VERSION}"

    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${LibraryVersions.ACTIVITY_KTX_VERSION}"
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${LibraryVersions.GOOGLE_HILT_VERSION}"
    const val HILT_GOOGLE_COMPILER = "com.google.dagger:hilt-android-compiler:${LibraryVersions.GOOGLE_HILT_VERSION}"
    const val HILT_LIFECYCLE_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${LibraryVersions.ANDROID_HILT_VERSION}"
    const val HILT_ANDROID_COMPILER = "androidx.hilt:hilt-compiler:${LibraryVersions.ANDROID_HILT_VERSION}"
    const val GSON = "com.google.code.gson:gson:${LibraryVersions.GSON_VERSION}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersions.RETROFIT_VERSION}"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${LibraryVersions.RETROFIT_VERSION}"
    const val ADAPTER_RXJAVA3 = "com.squareup.retrofit2:adapter-rxjava3:${LibraryVersions.RETROFIT_VERSION}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibraryVersions.OKHTTP_VERSION}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${LibraryVersions.OKHTTP_VERSION}"
    const val RXKOTLIN = "io.reactivex.rxjava3:rxkotlin:${LibraryVersions.RXKOTLIN_VERSION}"
    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${LibraryVersions.LIFECYCLE_VERSION}"

}