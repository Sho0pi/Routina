package com.shoopi.routina.actionsholders

import com.shoopi.routina.actions.ActionFactory

class BasicActionHolder() {
    private var actionFactories: List<ActionFactory<*>> = ArrayList()

    fun addActionFactory(actionFactory: ActionFactory<*>) {
        actionFactories += actionFactory
    }

    fun execute(): Any? {
        var previousResult: Any? = null
        actionFactories.forEach {
            val action = it.create(previousResult)
            previousResult = action.execute()
        }
        return previousResult
    }

}