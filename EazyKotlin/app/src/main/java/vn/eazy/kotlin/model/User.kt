package vn.eazy.kotlin.model

/**
 * Created by Harry on 1/5/17.
 */
class User {
    val name: String
    val email: String
    val company: String

    constructor(name: String, email: String, company: String) {
        this.name = name
        this.email = email
        this.company = company
    }
}