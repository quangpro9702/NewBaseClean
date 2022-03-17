package com.gapo.gapoproject.domain.base

abstract class BaseUseCase<in Params, out T> where T : Any {
    abstract suspend fun execute(params: Params? = null): T
    open class Params
}
