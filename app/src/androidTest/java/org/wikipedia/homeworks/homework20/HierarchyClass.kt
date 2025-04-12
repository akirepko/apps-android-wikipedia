package org.wikipedia.homeworks.homework20

class HierarchyClass(val name: String, parent: HierarchyClass? = null) {

    fun withParent(currentElemntName: String) {
        HierarchyClass(currentElemntName, this)
    }
}