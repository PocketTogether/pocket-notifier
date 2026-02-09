plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {

    namespace = "com.pocket.notifier"
    compileSdk = 34

    defaultConfig {
        // 应用 ID，应修改
        applicationId = "top.sakiko.pocket_notifier"

        // 版本数字，可修改
        versionCode = 100
        // 版本号，可修改
        versionName = "0.1.0"
        // 版本格式：主版本号.次版本号.修订号 https://semver.org/lang/zh-CN/
        // 三段式编码（把 versionName 编码进 versionCode）
        // 主版本号*10000 + 次版本号*100 + 修订号

        minSdk = 24
        targetSdk = 34
        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true      // 启用 R8 压缩
            isShrinkResources = true    // 移除未使用资源
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isDebuggable = false        // 显式关闭 debuggable 让 debug 也能压缩
            isMinifyEnabled = true      // 启用 R8 压缩
            isShrinkResources = true    // 移除未使用资源
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // 使用 ViewBinding
    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Kotlin JVM 目标
    kotlinOptions {
        jvmTarget = "17"
    }

    // 兼容旧设备
    packaging {
        resources.excludes += "META-INF/*"
    }
}

dependencies {

    // Kotlin 标准库
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")

    // 协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // AndroidX 基础库
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    // ViewBinding 不需要额外依赖

    // 通知需要的依赖
    implementation("com.google.android.material:material:1.11.0")
}