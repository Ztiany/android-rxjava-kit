package com.android.base.rxjava.vm

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.android.base.rxjava.auto.AutoDisposeLifecycleScopeProviderEx
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction
import com.uber.autodispose.lifecycle.LifecycleEndedException
import com.uber.autodispose.lifecycle.LifecycleScopes
import io.reactivex.CompletableSource
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * ArchViewModel  work with RxJava.
 *
 * @author Ztiany
 */
abstract class RxViewModel : ViewModel(), AutoDisposeLifecycleScopeProviderEx<RxViewModel.ViewModelEvent> {

    private val archLifecycleSubject = BehaviorSubject.createDefault(ViewModelEvent.CREATED)

    enum class ViewModelEvent {
        CREATED, CLEARED
    }

    @CallSuper
    override fun onCleared() {
        archLifecycleSubject.onNext(ViewModelEvent.CLEARED)
        super.onCleared()
    }

    final override fun correspondingEvents(): CorrespondingEventsFunction<ViewModelEvent> {
        return CORRESPONDING_EVENTS
    }

    final override fun lifecycle(): Observable<ViewModelEvent> {
        return archLifecycleSubject.hide()
    }

    final override fun peekLifecycle(): ViewModelEvent? {
        return archLifecycleSubject.value
    }

    final override fun requestScope(): CompletableSource {
        return LifecycleScopes.resolveScopeFromLifecycle(this)
    }

    companion object {
        private val CORRESPONDING_EVENTS = CorrespondingEventsFunction<ViewModelEvent> { event ->
            when (event) {
                ViewModelEvent.CREATED -> ViewModelEvent.CLEARED
                else -> throw LifecycleEndedException(
                    "Cannot bind to ViewModel lifecycle after onCleared."
                )
            }
        }
    }

}