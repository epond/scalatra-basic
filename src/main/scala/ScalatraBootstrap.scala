import javax.servlet.ServletContext
import org.scalatra._

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(Controllers, "/*")
  }
}

object Controllers extends ScalatraServlet with AbstractRoutes with FulltextRoutes with MyServiceImpl with ProdMyDependencies

trait AbstractRoutes {
  self: ScalatraServlet with MyService with MyDependencies =>

  get("/article/(.*)".r) {
    "Abstract. " + getSomething + ". " + squirrelCrusher.crush()
  }
}

trait FulltextRoutes {
  self: ScalatraServlet with MyService =>

  get("""\/(.*)\/fulltext.html""".r) {
    "Fulltext"
  }
}