package com.android.base.rxjava.auto

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.uber.autodispose.*
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.*

interface AutoDisposeLifecycleOwnerEx : LifecycleOwner {

    fun <T> Flowable<T>.autoDispose(): FlowableSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx)
    }

    fun <T> Observable<T>.autoDispose(): ObservableSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx)
    }

    fun Completable.autoDispose(): CompletableSubscribeProxy {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx)
    }

    fun <T> Maybe<T>.autoDispose(): MaybeSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx)
    }

    fun <T> Single<T>.autoDisposeOn(): SingleSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx)
    }

    fun <T> Flowable<T>.autoDisposeOn(event: Lifecycle.Event): FlowableSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx, event)
    }

    fun <T> Observable<T>.autoDisposeOn(event: Lifecycle.Event): ObservableSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx, event)
    }

    fun Completable.autoDisposeOn(event: Lifecycle.Event): CompletableSubscribeProxy {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx, event)
    }

    fun <T> Maybe<T>.autoDisposeOn(event: Lifecycle.Event): MaybeSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx, event)
    }

    fun <T> Single<T>.autoDisposeOn(event: Lifecycle.Event): SingleSubscribeProxy<T> {
        return this.bindLifecycle(this@AutoDisposeLifecycleOwnerEx, event)
    }

}

fun <T> Flowable<T>.bindLifecycle(lifecycleOwner: LifecycleOwner): FlowableSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner))
}

fun <T> Flowable<T>.bindLifecycle(lifecycleOwner: LifecycleOwner, event: Lifecycle.Event): FlowableSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner, event))
}

fun <T> Observable<T>.bindLifecycle(lifecycleOwner: LifecycleOwner): ObservableSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner))
}

fun <T> Observable<T>.bindLifecycle(lifecycleOwner: LifecycleOwner, event: Lifecycle.Event): ObservableSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner, event))
}

fun Completable.bindLifecycle(lifecycleOwner: LifecycleOwner): CompletableSubscribeProxy {
    return this.`as`(AutoDispose.autoDisposable<Any>(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
}

fun Completable.bindLifecycle(lifecycleOwner: LifecycleOwner, event: Lifecycle.Event): CompletableSubscribeProxy {
    return this.`as`(AutoDispose.autoDisposable<Any>(AndroidLifecycleScopeProvider.from(lifecycleOwner, event)))
}

fun <T> Maybe<T>.bindLifecycle(lifecycleOwner: LifecycleOwner): MaybeSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner))
}

fun <T> Maybe<T>.bindLifecycle(lifecycleOwner: LifecycleOwner, event: Lifecycle.Event): MaybeSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner, event))
}

fun <T> Single<T>.bindLifecycle(lifecycleOwner: LifecycleOwner): SingleSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner))
}

fun <T> Single<T>.bindLifecycle(lifecycleOwner: LifecycleOwner, event: Lifecycle.Event): SingleSubscribeProxy<T> {
    return autoDispose(AndroidLifecycleScopeProvider.from(lifecycleOwner, event))
}