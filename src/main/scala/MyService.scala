trait MyService {
  val getSomething: String
}

trait MyServiceImpl extends MyService {
  override val getSomething: String = "Here's Something"
}