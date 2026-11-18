
package com.commerzo.app.core

import com.commerzo.app.BuildConfig

object AppVersion {

    val name: String
        get() = BuildConfig.VERSION_NAME

    val label: String
        get() = "Version $name"
}
