package com.chriswk.stmdbapi.model

case class Person(id: Long,
                  name: String,
                  birthday: String,
                  also_known_as: Option[List[String]],
                  profile_path: Option[String],
                  biography: Option[String],
                  homepage: Option[String]
                  )

case class Credits(cast: List[Credit])

case class Credit(id: Long,
                  title: String,
                  character: String,
                  original_title: String,
                  poster_path: String,
                  release_date: String,
                  adult: Boolean)
