package ie.setu.mobileappdevassignment.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var name: String = "",
    var password: String = "",
    var collections: MutableList<LegoCollection> = mutableListOf(),
) {

    fun numberOfCollections(): Int = collections.size

    override fun toString(): String {
        return "Name: $name, Password: $password, Collections: $collections"
    }
}