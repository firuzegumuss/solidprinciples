package com.firuze.solid.single_responsibility


/**
 *
 * Single Responsibility Principle (SRP): A class should have only one reason to change.
 *
 * */


// Bad Sample
class Game {
    fun login(){}
    fun signup(){}
    fun move(){}
    fun fire(){}
    fun rest(){}
    fun getHighScore(){}
    fun getName(){}
}



// Single Responsibility Principle
class GameSession{
    fun login(){}
    fun signup(){}
}

class Player{
    fun getHighScore(){}
    fun getName(){}
}

class PlayerActions{
    fun move(){}
    fun fire(){}
    fun rest(){}
}