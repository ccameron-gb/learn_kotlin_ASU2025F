fun main() 
{
    // meet the toaster and its emotional state
    val toaster = Toaster("T-800 Toastinator", 40)
    println("Initializing ${toaster.model}... confidence level ${toaster.confidence}%")


    // demonstrate null safety - jam dilemma
    val jamFlavor: String? = null
    val jamMessage = jamFlavor?.let {"Spreading $it jam."} ?: "No jam detected. Existential crisis intensifies."
    println("Toaster: $jamMessage")


    // demonstrate data class - emotion
    val dread = Emotion("existential dread", 87)
    println("Toaster is currently experiencing ${dread.name} at intensity ${dread.intensity}.")


    // demonstrate enum class - toast mood
    val mood = ToastMood.HOPEFUL
    println("Setting toast mood to ${mood.name.lowercase()} at ${mood.temperature}°F.")


    // demonstrate collections + lambdas
    val feelings = listOf("confused", "warm", "lonely", "toasted", "burnt")
    val deepThoughts = feelings.filter {it.length > 5}.map {it.uppercase()}
    println("Toaster's reflective log: $deepThoughts")


    // demonstrate class interaction - toaster therapy
    val therapist = Therapist("Dr. Crumb")
    therapist.console(toaster)


    // demonstrate operator overload 
    val slice1 = BreadSlice(4)
    val slice2 = BreadSlice(6)
    val merged = slice1 + slice2
    println("Combined crispiness after emotional support: ${merged.crispiness}")
}

    // demonstrate class + member function 
    class Toaster(val model: String, var confidence: Int) 
    {
        fun gainConfidence() 
        {
            confidence += 20
            println("Toaster: I feel slightly better. Confidence now at $confidence%.")
        }
    }


    // demonstrate companion class interaction
    class Therapist(val name: String) 
    {
        fun console(toaster: Toaster)
        {
            println("$name: It's okay, ${toaster.model}, you're more than just a kitchen appliance.")
            toaster.gainConfidence()

        }
    }


    // demonstrate data class
    data class Emotion(val name: String, val intensity: Int)


    // demonstrate enum with value
    enum class ToastMood(val temperature: Int) 
    {
        MOPEY(120),
        HOPEFUL(160),
        OVERCONFIDENT(220)
    }


    // demonstrate data class + operator overload
    data class BreadSlice(val crispiness: Int)
    operator fun BreadSlice.plus(other: BreadSlice): BreadSlice
    {
        return BreadSlice(this.crispiness + other.crispiness)
    }
    

