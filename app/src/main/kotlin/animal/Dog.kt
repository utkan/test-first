package animal

class Dog {

    fun bark(numberOfTreats: Int): List<String> {
        val response = mutableListOf<String>()
        (0..numberOfTreats).forEach { _ ->
            response.add("Woof")
        }

        return response
    }
}