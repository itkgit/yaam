package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Event(id: Pk[Long],name:String,description:String,date:Date,startAt:Int,endAt:Int);

object Event {

	//もっくデータ
	var fixtures = [
		new Event(
			1,
			"テストイベント1",
			"テストのテストによるテストのためのデータ",
			java.text.SimpleDateFormat("yyyy/MM/dd").parse("2013/04/01"),
			60*8,
			60*10),
		new Event(
			2,
			"テストイベント1",
			"テストのテストによるテストのためのデータ",
			java.text.SimpleDateFormat("yyyy/MM/dd").parse("2013/04/01"),
			60*8,
			60*10)

	]

	def findAll():Seq[Event] = fixtures;


}