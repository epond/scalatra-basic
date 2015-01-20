package sampleApi.controllers

import org.scalatra.ScalatraServlet

class GreetingController extends ScalatraServlet {

  get("/") {
    "Hello world"
  }
} 