package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

import org.joda.time.{LocalDate,LocalTime}

case class Attendance ( 
	id:Pk[Long],
	comment:String,
	event:Long,
	user:Long,
	attendAt:Option[LocalTime]
)

object Attendance {
	var fixture = List()
	def findAll():Seq[Attendance] = fixure
}