package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models._
import views._

object Application extends Controller {

  val loginForm = Form(
    tuple(
      "email" -> text,
      "password" -> text
    ) verifying ("ログインに失敗しました。", result => result match {
      case (email, password) => User.authenticate(email, password).isDefined
    })
  )

  def authenticate = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.login(formWithErrors)),
      user => Redirect(routes.Application.index).withSession("email" -> user._1)
    )
  }


  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  
  def logout = TODO

}