import javax.servlet.ServletContext
import org.scalatra.{ScalatraServlet, LifeCycle}

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new GreetingController, "/*")

    context.mount(new AbstractController, "/article/*")
  }
}

class GreetingController extends ScalatraServlet {
  get("/") {
    "Hello world"
  }
} 

class AbstractController extends ScalatraServlet {
  get("/(.*)".r) {
    "Abstract"
  }
  get("""\/(.*)\/fulltext.html""".r) {
    "Fulltext"
  }
}
