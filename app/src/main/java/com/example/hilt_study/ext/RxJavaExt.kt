package com.example.hilt_study.ext

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

fun Completable.applyCompletableScheduler(): Completable =
    this.subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.single())

fun <T> Single<T>.applySingleScheduler(): Single<T> =
    this.subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.single())