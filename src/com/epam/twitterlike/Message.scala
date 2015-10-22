package com.epam.twitterlike

class Message(user: User, tittle: String, text: String) {

  def getUser = user
  def getTittle = tittle
  def getText = text
}
