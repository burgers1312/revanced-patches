package com.burgers1312.revanced.patches.splitwise

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

val adFeatureStatusGetEnabledFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC)
    returns("Z")
    parameters()
    custom { method, classDef ->
        classDef.type.contains("AdFeatureStatus") &&
        method.name == "getEnabled"
    }
}