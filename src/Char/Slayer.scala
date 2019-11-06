package Char
import Char.newCharClass
import Char.Knight
import Char.Slayer
import Char.newCharClass

class Slayer extends newCharClass {
  var Attack: Int = 1  // 1 + 5 = 6 for level 1
  var Defense: Int = 10
  var MagicAttack: Int = 3
  var MagicDefense: Int = 4
  var MaxHP: Int = 1 // 1 + 5 = 6
  var currectHP: Int = MaxHP
  var MaxMp: Int = 20
  var currectMp: Int = MaxMp

  // ------------------- Basic Starting Stats --------------------- \\

  var exp: Int = 0
  var level: Int = 0

  // ----------------------- Battle Options ------------------------

  val alis2 = List("Lion Strike", "Light Saga", "Roar", "Regen MP")  // Food for hp && Potion for MP and
  val LionStrike = alis2.indexOf("Lion Strike")
  val LightSaga = alis2.indexOf("Light Saga")
  val Roar = alis2.indexOf("Roar")
  val RegenMP = alis2.indexOf("Regen MP")

  // ----------------------- End Battle Options ---------------------

  override def battleOptions(): List[String] = {
    println(LionStrike, alis2(LionStrike))         // Battle Option 1
    println(LightSaga, alis2(LightSaga))                 // 2
    println(Roar, alis2(Roar))                           // 3
    println(RegenMP, alis2(RegenMP))                     // 4
    alis2
  }


  // ----------------------- End Battle Options --------------------- \\

  var alive = true

  def checkAlive(AnyPlayer1: Knight): Unit = {
    if (alive == true){
      alive
    }
  }

  // ----------------------- Checking Alive End  --------------------- \\

  def stat (IntStat: Int): Unit = {
    if (Attack == Attack) {
      Attack = (Attack + IntStat)
      Attack
    }
  }

  def LionStrike(stat: Int): Unit = {
    if (Attack == Attack) {
      Attack = Attack + stat
    }
    if (currectMp == currectMp) {
      currectMp = currectMp - Attack
      currectMp
    }
  }

  // ----------------------- Stat initial end --------------------- \\


  override def takeAction(): Unit = {

    def BO_Shield(AnyPlayer1: Knight): Unit = {
      val shield = (this.Attack)
      AnyPlayer1.stat(shield)
    }

    // ----------------------- First Battle End  --------------------- \\

    def BO_Thunder(AnyPlayer1: Knight): Unit = {
      val thunderAttack = this.Attack
      val loseMP = this.currectMp
      AnyPlayer1.ThunderAttack(thunderAttack)
      AnyPlayer1.ThunderAttack(loseMP)
    }

    // Battle Option 2
    // Battle Option 3
    // Battle Option 4

    def At_Level(AnyPlayer1: Knight): Unit = {
      if (exp < 10) {
        level = 0
        println("Nothing since char is level 0")
      }

      else {
        level = 5 // Max level is 5
        AnyPlayer1.currectHP += 30 // Max HP gain for level 5
        AnyPlayer1.Attack += 30 // Map Attack gain for level 5
      }

    }

  }



}
