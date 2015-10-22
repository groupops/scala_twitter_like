package models

import play.api.libs.json.Json

case class User(name: String/*, followers: List[User]*/)

object User {
  implicit val userFormat = Json.format[User]
}
