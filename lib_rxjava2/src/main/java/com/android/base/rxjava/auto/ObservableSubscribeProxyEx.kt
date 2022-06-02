package com.android.base.rxjava.auto

import com.android.base.rxjava.rxkit.RxKit
import com.uber.autodispose.*
import io.reactivex.disposables.Disposable
import timber.log.Timber

fun <T> ObservableSubscribeProxy<T>.subscribed(): Disposable =
    this.subscribe(RxKit.logResultHandler(), RxKit.logErrorHandler())

fun <T> FlowableSubscribeProxy<T>.subscribed(): Disposable =
    this.subscribe(RxKit.logResultHandler(), RxKit.logErrorHandler())

fun <T> SingleSubscribeProxy<T>.subscribed(): Disposable =
    this.subscribe(RxKit.logResultHandler(), RxKit.logErrorHandler())

fun <T> MaybeSubscribeProxy<T>.subscribed(): Disposable =
    this.subscribe(RxKit.logResultHandler(), RxKit.logErrorHandler())

fun CompletableSubscribeProxy.subscribed(): Disposable =
    this.subscribe(RxKit.logCompletedHandler(), RxKit.logErrorHandler())

fun <T> ObservableSubscribeProxy<T>.subscribeIgnoreError(action: (T) -> Unit): Disposable = this.subscribe(
    {
        action(it)
    },
    {
        Timber.e(it, "Kotlin Extends ignoreError: ")
    }
)

fun <T> FlowableSubscribeProxy<T>.subscribeIgnoreError(action: (T) -> Unit): Disposable = this.subscribe(
    {
        action(it)
    },
    {
        Timber.e(it, "Kotlin Extends ignoreError: ")
    }
)

fun <T> SingleSubscribeProxy<T>.subscribeIgnoreError(action: (T) -> Unit): Disposable = this.subscribe(
    {
        action(it)
    },
    {
        Timber.e(it, "Kotlin Extends ignoreError: ")
    }
)

fun <T> MaybeSubscribeProxy<T>.subscribeIgnoreError(action: (T) -> Unit): Disposable = this.subscribe(
    {
        action(it)
    },
    {
        Timber.e(it, "Kotlin Extends ignoreError: ")
    }
)

fun CompletableSubscribeProxy.subscribeIgnoreError(action: () -> Unit): Disposable = this.subscribe(
    {
        action()
    },
    {
        Timber.e(it, "Kotlin Extends ignoreError: ")
    }
)