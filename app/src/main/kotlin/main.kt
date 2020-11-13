import animal.Dog

fun main(args: Array<String>) {
    println("Hello World!\n")

    val dog = Dog()
    val responses = dog.bark(1)

    responses.forEach { response ->
        println(response)
    }

}