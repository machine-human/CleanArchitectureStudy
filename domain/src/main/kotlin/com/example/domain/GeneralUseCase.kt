package com.example.domain

import io.reactivex.rxjava3.disposables.Disposable

interface GeneralUseCase<ResponseType, in Params> {

    operator fun invoke(
        params: Params,
        success: (ResponseType) -> Unit,
        failed: (Throwable) -> Unit
    ): Disposable
}