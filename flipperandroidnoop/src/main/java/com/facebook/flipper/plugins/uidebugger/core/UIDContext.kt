package com.facebook.flipper.plugins.uidebugger.core

import android.app.Application
import com.facebook.flipper.plugins.uidebugger.descriptors.DescriptorRegister
import com.facebook.flipper.plugins.uidebugger.model.FrameworkEventMetadata
import com.facebook.flipper.plugins.uidebugger.observers.TreeObserverFactory

data class UIDContext(
    val applicationRef: ApplicationRef,
    val connectionRef: ConnectionRef,
    val descriptorRegister: DescriptorRegister,
    val observerFactory: TreeObserverFactory,
    val frameworkEventMetadata: MutableList<FrameworkEventMetadata>
) {
    companion object {
        fun create(application: Application): UIDContext {
            return UIDContext(
                ApplicationRef(application),
                ConnectionRef(null),
                descriptorRegister = DescriptorRegister.withDefaults(),
                observerFactory = TreeObserverFactory.withDefaults(),
                frameworkEventMetadata = mutableListOf())
        }
    }
}

data class ConnectionRef(var connection: FlipperConnection?)