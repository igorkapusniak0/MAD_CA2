package ie.setu.mobileappdevassignment.models

import kotlinx.serialization.Serializable
import ie.setu.mobileappdevassignment.models.LegoSet

@Serializable
data class LegoCollection(
    var name : String = "",
    var description : String = "",
    var creationDate : String = "",
    var imagePath: String = "",
    var sets: MutableList<LegoSet> = mutableListOf(),
    var isPublic: Boolean = false
) {


    fun numberOfSets() : Int {
        val numberOfSets : Int = sets.size
        return numberOfSets
    }

    override fun toString(): String {
        return "Name: " + name +
                "Description: " + description +
                "Creation Date: " + creationDate +
                "Sets: " + sets
    }

}
