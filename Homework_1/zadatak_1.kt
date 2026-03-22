val name = "Emanuel"
val surname = "Florijan"
val email: String? = null
val age: Int? = 22

fun main() {
    println("Duljina emaila: ${email?.length ?: "email nije unesen"}")
    email = "emanuel.florijan@example.com"
    println("Duljina emaila: ${email?.length ?: "email nije unesen"}")
}