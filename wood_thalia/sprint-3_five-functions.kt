fun main() {
    // establish the team, populate it with team members, and assign tasks
    val asu_2025f = Team("ASU 2025 Fall")
    asu_2025f + Personnel("Thalia", "Wood", Role.DEVELOPER)
    asu_2025f + Personnel("Chris", "Cameron", Role.SCRUM_MASTER)
    asu_2025f.assign(Task("Kotlin Koans", Priority.HIGH))
    asu_2025f.assign(Task("Kotlin Code Samples", Priority.HIGH))
    asu_2025f.assign(Task("Integrate Linting", Priority.MEDIUM_RARE))
    // return an average of the priority of the team's tasks
    asu_2025f.estimate_team_urgency()
}

// demonstrate class with init, additional values, and member functions
class Team(var teamName: String) {
    // demonstrate use of collections
    val team_members: MutableList<Personnel> = mutableListOf<Personnel>()
    val tasks: MutableList<Task> = mutableListOf<Task>()

    // demonstrates operator overload
    // add new team members
    operator fun plus(teamMember: Personnel) {
        team_members.add(teamMember)
    }

    // adds task to team tasks and assigns team on task object
    fun assign(task: Task) {
        task.assignee = this
        tasks.add(task)
    }

    // quantifies average priority of team tasks
    // demonstrates closures, collection functions, map
    fun estimate_team_urgency() { 
        println(teamName + "average priority: " + (tasks.map { it.priority.code }.average())) // do closure bs to average priority
    }
}

// demonstrate class oneliner with init values
data class Personnel(val firstName: String, val lastName: String, val role: Role)

// demonstrate nullable var
data class Task(val name: String, val priority: Priority) {
    var assignee: Team? = null
}

// demonstrate classic enum
enum class Role {
    DEVELOPER,
    SCRUM_MASTER,
    PRODUCT_OWNER
}

// demonstrate valued enum
enum class Priority(val code: Int) {
    URGENT(8),
    HIGH(4),
    MEDIUM_RARE(2),
    LOW(1)
}