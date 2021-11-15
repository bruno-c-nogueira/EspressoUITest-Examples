package com.codingwithmitch.espressouitestexamples.util

import androidx.test.espresso.IdlingRegistry
import com.codingwithmitch.espressotestsexamples.util.EspressoIdlingResource
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.lang.Exception

//Option one, more difficult

//class EspressoIdlingResourceRule : TestRule {
//    override fun apply(base: Statement?, description: Description?): Statement {
//        return IdlingResourceStatement(base)
//    }
//
//    class IdlingResourceStatement(private val base: Statement?) : Statement() {
//        private val idlingResource = EspressoIdlingResource.countingIdlingResource
//        override fun evaluate() {
//            IdlingRegistry.getInstance().register(idlingResource)
//
//            try {
//                //BEfore
//                base?.evaluate() ?: throw Exception("Error evaluationg test")
//            } finally {
//                //After
//                IdlingRegistry.getInstance().unregister(idlingResource)
//            }
//        }
//
//    }
//
//}

//Option 2 more easy to implement
class EspressoIdlingResourceRule : TestWatcher() {
    private val idlingResource = EspressoIdlingResource.countingIdlingResource

    override fun starting(description: Description?) {
        super.starting(description)
        IdlingRegistry.getInstance().register(idlingResource)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        IdlingRegistry.getInstance().unregister(idlingResource)
    }
}