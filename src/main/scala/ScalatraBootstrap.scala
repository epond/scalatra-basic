import javax.servlet.ServletContext
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(Controllers, "/*")
  }
}

object Controllers extends ScalatraServlet with AbstractRoutes with FulltextRoutes with MyServiceImpl

trait AbstractRoutes {
  self: ScalatraServlet with MyService =>

  get("/article/(.*)".r) {
    "Abstract. " + getSomething
  }
}

trait FulltextRoutes {
  self: ScalatraServlet with MyService =>

  get("""\/(.*)\/fulltext.html""".r) {
    "Fulltext"
  }
}