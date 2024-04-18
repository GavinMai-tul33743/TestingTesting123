package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

//    @Test
//    fun clearAllItems() {
//        collection.addItem(Item("item1"))
//        collection.addItem(Item("Item2"))
//
//        val originalSize = collection.size()
//        collection.clear()
//        val newSize = collection.size();
//
//        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
//    }

    @Test
    fun getItem(){
        collection.addItem(Item("1"))
        collection.addItem(Item("2"))

        val item1 = collection.get(0)
        val item2 = collection.get(1)

        assert(item1.name == "1" && item2.name == "2"){"Get does not work properly"}
    }

    @Test
    fun removeItemSize(){
        repeat(10){
            collection.addItem(Item(it.toString()))
        }

        val oldSize = collection.size()
        collection.remove(Item("1"))
        val newSize = collection.size()
        assert(newSize == oldSize-1){"Remove did not change collection size"}
    }

    @Test
    fun removeItemIndex0(){
        repeat(10){
            collection.addItem(Item(it.toString()))
        }

        collection.remove(Item("1"))
        val item0 = collection.get(1)
        assert(item0.name == "2"){"Remove did not remove item0:"}
    }

    @Test
    fun removeItemEmptyCollection(){
        collection.remove(Item("1"))
        assert(true){"Remove on an empty list"}
    }

    @Test
    fun removeItemIndexMiddle(){
        repeat(10){
            collection.addItem(Item(it.toString()))
        }
        collection.remove(Item("5"))
        val item0 = collection.get(5)
        assert(item0.name == "6"){"Remove did not remove item at middle"}
    }

    @Test
    fun removeItemIndexLast(){
        repeat(10){
            collection.addItem(Item(it.toString()))
        }

        collection.remove(Item("10"))
        val item0 = collection.get(collection.size()-1)
        assert(item0.name == "9"){"Remove did not remove item at end"}
    }

}