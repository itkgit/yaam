package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

import org.joda.time.{LocalDate,LocalTime}

case class Event (
	id: Pk[Long],
	name:String,
	description:String,
	date:LocalDate,
	startAt:LocalTime,
	endAt:Option[LocalTime]
)

object Event {

	//もっくデータ
	val fixtures = List(
		new Event(
			Id(1),
			"テストイベント1",
			"テストのテストによるテストのためのデータ",
			new LocalDate(2004,4,1),
			new LocalTime(9,30),
			Some(new LocalTime(12,0))
		),
		new Event(
			Id(2),
			"テストイベント2",
			"テストのテストによるテストのためのデータ",
			new LocalDate(2004,4,1),
			new LocalTime(9,30),
			Some(new LocalTime(12,0))
		),
		new Event(
			Id(3),
			"テストイベント3",
			"テストのテストによるテストのためのデータ",
			new LocalDate(2004,4,1),
			new LocalTime(9,30),
			None
		)
	)

	def findAll():Seq[Event] = fixtures;


}