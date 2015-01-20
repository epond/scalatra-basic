package sampleApi.controllers

import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class GreetingControllerTests extends ScalatraSuite with FunSuiteLike {
  // `GreetingController` is your app which extends ScalatraServlet
  addServlet(classOf[GreetingController], "/*")

  test("simple get") {
    get("/") {
      status should equal (200)
      body should include ("Hello world")
    }
  }
}
