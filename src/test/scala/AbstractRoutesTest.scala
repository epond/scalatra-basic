import org.scalatest.{BeforeAndAfterEach, FunSuiteLike}
import org.scalatra.ScalatraServlet
import org.scalatra.test.scalatest._
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar.mock

class AbstractRoutesTest extends ScalatraSuite with FunSuiteLike with BeforeAndAfterEach{

  val mockSquirrelCrusher = mock[SquirrelCrusher]

  trait TestMyDependencies extends MyDependencies {
    override val squirrelCrusher: SquirrelCrusher = mockSquirrelCrusher
  }

  object TestAbstractRoutes extends ScalatraServlet with AbstractRoutes with TestMyService with TestMyDependencies

  override protected def beforeEach() {
    when(mockSquirrelCrusher.crush()).thenReturn("Squeak!")
  }

  addServlet(TestAbstractRoutes, "/*")

  test("article abstract") {
     get("/article/abc") {
       status should equal (200)
       body should be ("Abstract. something. Squeak!")
     }
  }
}

trait TestMyService extends MyService {
  override val getSomething: String = "something"
}
