package com.facebook.flipper.plugins.network

import okhttp3.Interceptor
import okhttp3.Response

class FlipperOkhttpInterceptor(
    private val plugin: NetworkFlipperPlugin,
    private val long maxBodyBytes,
    private val boolean isMockResponseSupported
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}
