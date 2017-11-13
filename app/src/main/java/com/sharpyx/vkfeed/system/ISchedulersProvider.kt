package com.sharpyx.vkfeed.system

import io.reactivex.Scheduler

/**
 * @author Artem Sckopincev (aka sharpyx)
 */
interface ISchedulersProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}