package com.burgers1312.revanced.patches.splitwise

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

val enableFeaturesPatch = bytecodePatch(
    name = "Enable Features",
    description = "Enables features by skipping checks"
) {
    compatibleWith("com.Splitwise.SplitwiseMobile")

    execute {
        AdFeatureStatusGetEnabledFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
        AdFeatureStatusGetVisibleFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
    }
}