package com.chriswk.stmdbapi

import com.typesafe.config.ConfigFactory
import net.liftweb.json.DefaultFormats
import dispatch._
import Defaults._
import com.chriswk.stmdbapi.model._


class TmdbApi {
  implicit val formats = DefaultFormats
  val config = ConfigFactory.load()
  val apiRoot = host(config.getString("tmdb.api.root")) / config.getString("tmdb.api.version")
  val withHeader = apiRoot.addHeader("Accept", "application/json")
  val apiKey = config.getString("tmdb.api.key")
  val withApiKey = withHeader.addQueryParameter("api_key", apiKey)
  val personUrl = withApiKey / "person"
  val movieUrl = withApiKey / "movie"
  def personCreditsUrl(id: Long) = personUrl / id / "movie_credits"




  def findPersonWithCredits(id: Long) = {
    println(personUrl.toString)
    val p = personCreditsUrl(id)
    println(p.toString)
    for (person <- Http(p OK as.lift.Json))
      yield person.extract[Credits]
  }

  def findPerson(id: Long) = {
    val p = personUrl / id
    for (person <- Http(p OK as.lift.Json))
      yield person.extract[Person]
  }

  def findMovie(id: Long) = {
    val p = movieUrl / id
    for (movie <- Http(p OK as.lift.Json))
    yield movie.extract[Movie]

  }
}
