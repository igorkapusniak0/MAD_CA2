package ie.setu.mobileappdevassignment.controllers

import android.content.Context
import android.util.Log
import ie.setu.mobileappdevassignment.models.LegoCollection
import ie.setu.mobileappdevassignment.models.LegoSet
import ie.setu.mobileappdevassignment.utilities.GlobalData
import ie.setu.mobileappdevassignment.utilities.Utils


class AddController(context: Context) {
    var globalData = GlobalData
    private val utils = Utils(context)

    fun addCollection(collection: LegoCollection){
        globalData.loggedUserData.collections.add(collection)
        utils.saveUsersToFile()
        Log.d("userData", globalData.loggedUserData.toString())
        Log.d("userData", globalData.usersData.toString())
    }

    fun addSet(set: LegoSet, collection: LegoCollection){
        collection.sets.add(set)
        utils.saveUsersToFile()
        Log.d("user sets", collection.sets.toString())

    }

    fun getCollectionFromName(name: String): LegoCollection{
        var collection = LegoCollection()
        for(col in globalData.loggedUserData.collections){
            if(col.name == name){
                collection = col
                break
            }
        }
        return collection
    }

    fun getSetsFromCollectionName(collectionName: String): LegoCollection{
        var legoCollection = LegoCollection()
        var publicCollection = true
        for (collection in globalData.loggedUserData.collections){
            if (collection.name == collectionName){
                legoCollection = collection
                publicCollection = false
                break
            }

        }
        if (publicCollection){
            for (user in globalData.usersData){
                for (collection in user.collections){
                    if (collection.name == collectionName){
                        legoCollection = collection
                        break
                    }
                }
            }
        }
        return legoCollection
    }
    fun findCollectionFromSet(legoSet: LegoSet): LegoCollection{
        var legoCollection = LegoCollection()
        for (collection in globalData.loggedUserData.collections){
            for (set in collection.sets){
                if (set == legoSet){
                    legoCollection = collection
                    break
                }
            }
        }
        return legoCollection
    }
    fun removeSet(set: LegoSet){
        val collection = findCollectionFromSet(set)
        collection.sets.remove(set)
        utils.saveUsersToFile()
    }

    fun removeCollection(collection: LegoCollection){
        globalData.loggedUserData.collections.remove(collection)
        utils.saveUsersToFile()
    }

    fun listCollectionNames(): List<String>{
        val collectionNames = mutableListOf<String>()
        for (collection in globalData.loggedUserData.collections) {
            collectionNames.add(collection.name)
        }
        return collectionNames
    }


}