package com.shoopi.routina.actionsholders

import com.shoopi.routina.actions.ActionFactory

class BasicActionHolder() {
    private var actionFactories: MutableList<ActionFactory<*>> = ArrayList()

    fun execute(): Any? {
        var previousResult: Any? = null
        actionFactories.forEach {
            val action = it.create(previousResult)
            previousResult = action.execute()
        }
        return previousResult
    }

    fun add(actionFactory: ActionFactory<*>): Boolean {
        return actionFactories.add(actionFactory)
    }

    fun add(position: Int, actionFactory: ActionFactory<*>) {
        return actionFactories.add(position, actionFactory)
    }

    fun remove(actionFactory: ActionFactory<*>): Boolean {
        return actionFactories.remove(actionFactory)
    }

    fun removeAt(index: Int): ActionFactory<*> {
        return actionFactories.removeAt(index)
    }

    fun size() = actionFactories.size

}