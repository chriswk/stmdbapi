package com.chriswk.stmdbapi.model

case class Movie(id: Long,
                 title: String,
                 status: Option[String],
                 runtime: Option[Long],
                 tagline: Option[String],
                 vote_average: Option[Double],
                 original_title: Option[String],
                 budget: Option[Long],
                 genres: Option[List[Genre]],
                 homepage: Option[String],
                 imdb_id: Option[String],
                 popularity: Option[Double],
                 poster_path: Option[String],
                 backdrop_path: Option[String],
                 production_companies: Option[List[ProductionCompany]],
                 production_countries: Option[List[Country]],
                 spoken_languages: Option[List[Language]])

case class Genre(id: Long, name: String)
case class ProductionCompany(id: Long, name: String)
case class Country(iso_3166_1: String, name: String)
case class Language(iso_639_1: String, name: String)