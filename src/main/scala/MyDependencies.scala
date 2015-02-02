trait MyDependencies {
  val squirrelCrusher: SquirrelCrusher
}

trait ProdMyDependencies extends MyDependencies {
  override val squirrelCrusher: SquirrelCrusher = new SquirrelCrusher
}

class SquirrelCrusher {
  def crush(): String = {
    "Eek!"
  }
}