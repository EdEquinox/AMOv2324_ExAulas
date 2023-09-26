package pt.edequinox.aula2

object MyObject {
    private var _value = 1234
    val value : Int
        get() = _value++

}