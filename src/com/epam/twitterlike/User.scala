package com.epam.twitterlike

class User(id: Int, name: String, followers: List[User]) {

  def getId = id
  def getName = name
  def getFollowers = followers
}
