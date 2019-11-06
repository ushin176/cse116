package Char
import Char.newCharClass
import Char.Knight
import Char.Slayer
import Char.newCharClass


class Knight extends newCharClass{

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

  // ----------------------- Battle Options ------------------------ \\

  val alis = List("Shield Defence", "Thunder Sword", "Knight strike", "Regen HP")
  val Shield= alis.indexOf("Shield Defence")
  val Thunder = alis.indexOf("Thunder Sword")
  val KnightStrike = alis.indexOf("Knight strike")
  val RegenHP = alis.indexOf("Regen HP")

  override def battleOptions(): List[String] = {
    println(Shield, alis(Shield))                 // Battle Option 1
    println(Thunder, alis(Thunder))                       // 2
    println(KnightStrike, alis(KnightStrike))             // 3
    println(RegenHP, alis(RegenHP))                       // 4
    alis
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
    if (Defense == Defense) {
      Defense = (Defense + IntStat)
      Defense
    }
  }

  def ThunderAttack(stat: Int): Unit = {
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
      val shield = (this.Defense)
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
        if (exp < 20) {
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