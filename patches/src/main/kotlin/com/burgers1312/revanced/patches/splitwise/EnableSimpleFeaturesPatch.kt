package com.burgers1312.revanced.patches.splitwise

import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions

val enableSimpleFeaturesPatch = bytecodePatch(
    name = "Enable Simple Features",
    description = "Modifies the FeatureAvailability.isSimpleFeatureEnabled() method to always return true."
) {
    compatibleWith("com.Splitwise.SplitwiseMobile")

    execute {
        isSimpleFeatureEnabledFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
    }
}