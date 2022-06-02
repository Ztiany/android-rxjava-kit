package me.ztiany.rxjava.kit.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.base.rxjava.auto.AutoDisposeLifecycleOwnerEx
import com.android.base.rxjava.auto.subscribeIgnoreError
import io.reactivex.Flowable
import timber.log.Timber
import timber.log.Timber.DebugTree

class MainActivity : AppCompatActivity(), AutoDisposeLifecycleOwnerEx {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(DebugTree())

        Flowable.fromCallable {
            "Alien"
        }
            .autoDispose()
            .subscribeIgnoreError {

            }
    }

}