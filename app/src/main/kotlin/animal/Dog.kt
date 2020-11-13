package animal

class Dog {

    fun bark(numberOfTreats: Int): List<String> {
        val response = mutableListOf<String>()
        if (numberOfTreats != 0) {
            response.add("Woof")
        }
        return response
    }
}