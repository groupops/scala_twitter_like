package models

import play.api.libs.json.Json

case class Message(author: User, text: String)

object Message {
  implicit val userFormat = Json.format[Message]
}
