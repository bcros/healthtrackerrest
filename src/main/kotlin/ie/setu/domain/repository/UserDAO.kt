package ie.setu.domain.repository

import ie.setu.domain.User

class UserDAO {

    private val users = arrayListOf<User>(
        User(name = "Geddy Lee", email = "geddy.lee@rush.com", id = 0),
        User(name = "Alex Lifeson", email = "alex.lifeson@rush.com", id = 1),
        User(name = "Neil Peart", email = "Neil.Peart@rush.com", id = 2),
        User(name = "Eddie Van Halen", email = "Eddie@vanhalen.com", id = 3)
    )

    fun getAll() : ArrayList<User>{
        return users
    }
    fun findById(id: Int): User?{
        return users.find {it.id == id}
    }
    fun save(user: User){
        users.add(user)
    }
    fun delete(id: Int) {
        val user = findById(id)
        users.remove(user)
    }
    fun findByEmail(email: String) :User?{
        return users.find {it.email == email}
    }


    fun update(id: Int, user: User){
        val foundUser = findById(id)
        foundUser?.email = user.email
        foundUser?.name = user.name
        foundUser?.id = user.id
    }
}
