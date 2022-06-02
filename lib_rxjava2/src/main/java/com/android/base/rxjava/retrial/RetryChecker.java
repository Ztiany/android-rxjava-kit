package com.android.base.rxjava.retrial;

public interface RetryChecker {

    /**
     * return true to do retrial.
     */
    boolean doRetry(Throwable throwable);

}