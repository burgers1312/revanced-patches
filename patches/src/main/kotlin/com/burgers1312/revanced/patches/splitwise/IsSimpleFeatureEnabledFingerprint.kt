package com.burgers1312.revanced.patches.splitwise

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

val isSimpleFeatureEnabledFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC)
    returns("Z")
    parameters("Ljava/lang/String;")
    custom { method, classDef ->
        classDef.type.contains("FeatureAvailability") &&
        method.name == "isSimpleFeatureEnabled"
    }
}