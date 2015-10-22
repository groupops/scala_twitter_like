package controllers

import models.{DB, User}
import play.api.data.{Forms, Form}
import play.api.data.Forms._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Hi Play!"))
  }

  val userForm: Form[User] = Form(
    mapping("name" -> text/*, "followers" -> Forms.ignored()*/)(User.apply)(User.unapply)
  )

  def login() = Action { implicit request =>
    val user = userForm.bindFromRequest.get
    DB.save(user)
    Redirect(routes.Application.index())
  }

}
