package com.android.base.rxjava.auto

import com.uber.autodispose.*
import com.uber.autodispose.lifecycle.LifecycleScopeProvider
import io.reactivex.*

interface AutoDisposeLifecycleScopeProviderEx<T> : LifecycleScopeProvider<T> {

    fun <T> Flowable<T>.autoDispose(): FlowableSubscribeProxy<T> {
        return autoDispose(this@AutoDisposeLifecycleScopeProviderEx)
    }

    fun <T> Observable<T>.autoDispose(): ObservableSubscribeProxy<T> {
        return autoDispose(this@AutoDisposeLifecycleScopeProviderEx)
    }

    fun Completable.autoDispose(): CompletableSubscribeProxy {
        return autoDispose(this@AutoDisposeLifecycleScopeProviderEx)
    }

    fun <T> Maybe<T>.autoDispose(): MaybeSubscribeProxy<T> {
        return autoDispose(this@AutoDisposeLifecycleScopeProviderEx)
    }

    fun <T> Single<T>.autoDispose(): SingleSubscribeProxy<T> {
        return autoDispose(this@AutoDisposeLifecycleScopeProviderEx)
    }

}
