import org.scalatest.FunSuiteLike
import org.scalatra.ScalatraServlet
import org.scalatra.test.scalatest._

class AbstractRoutesTest extends ScalatraSuite with FunSuiteLike {

   addServlet(TestAbstractRoutes, "/*")

   test("article abstract") {
     get("/article/abc") {
       status should equal (200)
       body should include ("Abstract. something")
     }
   }
 }

object TestAbstractRoutes extends ScalatraServlet with AbstractRoutes with TestMyService

trait TestMyService extends MyService {
  override val getSomething: String = "something"
}
