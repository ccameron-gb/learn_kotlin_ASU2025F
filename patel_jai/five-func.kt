// five-func.kt — Jai Patel (Developer)

// ===== Top-level functions =====

fun main() {
    val squad = bootstrapSquad()
    squad.printRiskPulse()

    val avg = meanRisk(squad)
    println("Mean risk score: ${"%.2f".format(avg)}")

    val owner = findOwner("Compose Playground", squad)
    println("Owner of 'Compose Playground': $owner")

    val hotlist = highest(2, squad)
    println("Hotlist: " + hotlist.joinToString { "${it.title} [${it.severity}]" })
}

// 1) Create and seed a squad (demonstrates operator overload and null-safety via Job.owner)
fun bootstrapSquad(): Squad {
    val s = Squad("SunDev Innovators 2025")
    s += Engineer("Jai", "Patel", Duty.DEV)
    s += Engineer("Thalia", "Wood", Duty.QA)
    s += Engineer("Chris", "Cameron", Duty.PM)

    s.enqueue(Job("Compose Playground", Severity.MAJOR))
    s.enqueue(Job("Static Analysis Wiring", Severity.NORMAL))
    s.enqueue(Job("CI Matrix Cache", Severity.CRITICAL))
    return s
}

// 2) Functional average via map/average (closures + collections)
fun meanRisk(squad: Squad): Double =
    squad.backlog.map { it.severity.weight }.average()

// 3) Null-safety demo: safe read of nullable owner with elvis
fun findOwner(taskName: String, squad: Squad): String =
    squad.backlog.firstOrNull { it.title == taskName }
        ?.owner?.name ?: "No owner"

// 4) Get top-N jobs by severity
fun highest(n: Int, squad: Squad): List<Job> =
    squad.backlog.sortedByDescending { it.severity.weight }.take(n)

// ===== Core domain types =====

class Squad(val name: String) {
    val members: MutableList<Engineer> = mutableListOf()
    val backlog: MutableList<Job> = mutableListOf()

    // operator overload (+=) to add engineers
    operator fun plusAssign(engineer: Engineer) {
        members.add(engineer)
    }

    // add job and set nullable owner backlink
    fun enqueue(job: Job) {
        job.owner = this
        backlog.add(job)
    }

    // prints an average risk “pulse” for visibility
    fun printRiskPulse() {
        val pulse = backlog.map { it.severity.weight }.average()
        println("$name — risk pulse: $pulse")
    }
}

// concise data classes
data class Engineer(val first: String, val last: String, val duty: Duty)

// nullable backlink to Squad
data class Job(val title: String, val severity: Severity) {
    var owner: Squad? = null
}

// simple enums
enum class Duty { DEV, QA, PM }

enum class Severity(val weight: Int) {
    CRITICAL(10),
    MAJOR(5),
    NORMAL(3),
    MINOR(1)
}
