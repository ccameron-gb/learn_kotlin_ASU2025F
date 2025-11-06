//create a simple Character class
class Character(val name: String, var hp: Int, var atk: Int) {

    //simple damage function
    fun takeDamage(amount: Int) {
        hp -= amount
        if (hp <= 0) {
            println("${name} has been defeated!")
        }
        else {
            println("${name} takes ${amount} damage. HP left: ${hp}")
        }
    }

    //simple attack function
    fun attack(target: Character) {
        if (target.hp <= 0) {
            println("${target.name} has already been defeated!")
        }
        else {
            println("${this.name} attacks ${target.name} for ${this.atk} damage!")
            target.takeDamage(atk)
        }
    }

}

//create a list of Character classes
val characters = mutableListOf<Character>()

//main function
fun main() {
    var input = 0
    //loop to simulate gameplay
    while (input != -1) {

        println("""1: Create a character
        2: Attack
        -1: Quit""".trimIndent())

        var line = readLine()
        input = line?.toIntOrNull() ?: 0

        //options to create, attack or quit program
        when (input) {
        1 -> {
            print("Enter the name of the character: ")
            val name = readLine() ?: "Unknown"

            print("Enter the hp of ${name}: ")
            val hpInput = readLine()
            val hp = hpInput?.toIntOrNull() ?: 0

            print("Enter the attack power of ${name}: ")
            val atkInput = readLine()
            val atk = atkInput?.toIntOrNull() ?: 0

            val cha = Character(name, hp, atk)
            characters.add(cha)

            println("Created ${name} with ${hp} hp and ${atk} attack!")
            }
        
            //attacking option
        2 -> {
            if (characters.size < 2) {
                println("Need at least two characters to attack!")
            } else {
                println("Choose attacker index (0-${characters.lastIndex}):")
                characters.forEachIndexed { index, c ->
                    println("$index: ${c.name} (HP: ${c.hp}, ATK: ${c.atk})")
                }
                val attackerIndex = readLine()?.toIntOrNull() ?: -1

                println("Choose target index (0..${characters.lastIndex}):")
                val targetIndex = readLine()?.toIntOrNull() ?: -1

                if (attackerIndex in characters.indices && targetIndex in characters.indices && attackerIndex != targetIndex) {
                    val attacker = characters[attackerIndex]
                    val target = characters[targetIndex]
                    attacker.attack(target)
                } else {
                    println("Invalid indices.")
                }
            }
        }

        -1 -> println("Goodbye!")
        else -> println("Invalid option.")
        }
    }
}
