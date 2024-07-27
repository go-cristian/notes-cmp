package data

private val chars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
fun createRandomID(): String {
    return (0..5).joinToString("") { chars.random().toString() }
}