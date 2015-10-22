package com.epam.twitterlike

class Message(user: User, tittle: String, message: String) {

  def getUser = user
  def getTittle = tittle
  def getMessage = message
}
