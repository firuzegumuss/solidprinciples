package com.firuze.solid.single_responsibility

// Bad Sample
class PersonClass {
    fun setName(){}
    fun setAddress(){}
    fun setPhoneNumber(){}
    fun save(){}
    fun load(){}
}

// Single Responsibility Principle
class Person {
    fun setName(){}
    fun setAddress(){}
    fun setPhoneNumber(){}
}

class PersonRepository{
    fun save(){}
    fun load(){}
}
