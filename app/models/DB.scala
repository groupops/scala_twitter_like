package models

import sorm._

object DB extends  Instance(entities = Seq(Entity[User](), Entity[Message]()), url = "jdbc:m2:test"){

}
