package com.shoopi.routina.actionsholders

import android.content.Context
import com.shoopi.routina.actions.ActionGenerator
import com.shoopi.routina.actions.EditableActionGenerator
import com.shoopi.routina.actions.utils.EmptyActionGenerator

class BasicActionHolder(private val context: Context) {
    private var actionGenerators: MutableList<ActionGenerator<*>> = ArrayList()

    init {
        actionGenerators.add(EmptyActionGenerator())
    }

    fun execute(): Any {
        var previousResult: Any = Unit
        actionGenerators.forEach {
            val action = it.generate(previousResult)
            previousResult = action.execute()
        }
        return previousResult
    }

    fun add(actionGenerator: ActionGenerator<*>): Boolean {
        if (actionGenerator is EditableActionGenerator) {
            if (actionGenerator.isReceiver) {
                if (!actionGenerators.last().isSupplier) {
                    actionGenerator.edit(context)
                }
            } else {
                actionGenerator.edit(context)
            }
        }
        return actionGenerators.add(actionGenerator)
    }

    fun add(position: Int, actionGenerator: ActionGenerator<*>) {
        if (actionGenerator is EditableActionGenerator) {
            if (actionGenerator.isReceiver) {
                if (!actionGenerators.last().isSupplier) {
                    actionGenerator.edit(context)
                }
            } else {
                actionGenerator.edit(context)
            }
        }
        return actionGenerators.add(position, actionGenerator)
    }

    fun remove(actionGenerator: ActionGenerator<*>): Boolean {
        return actionGenerators.remove(actionGenerator)
    }

    fun removeAt(index: Int): ActionGenerator<*> {
        return actionGenerators.removeAt(index)
    }

    fun size() = actionGenerators.size

}