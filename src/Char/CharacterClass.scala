package Char

class CharacterClass {

  var Attack: Int = 1  // 1 + 5 = 6 for level 1
  var Defense: Int = 10
  var MagicAttack: Int = 3
  var MagicDefense: Int = 4
  var MaxHP: Int = 1 // 1 + 5 = 6
  var currectHP: Int = MaxHP
  var MaxMp: Int = 20
  var currectMp: Int = MaxMp

  // ----------------------- Leveling ------------------------
  var exp: Int = 0
  var level = 0
  // ----------------------- End Leveling ---------------------

  var mpLevel = 0
  var alive = true

  def takeDamage(takeDamage: Int): Unit = {
    if (MaxHP <= 0) {
      alive = false
    }
    currectHP = (currectHP - takeDamage)
  }

    def physicalAttack(AnyPlayer: CharacterClass): Unit ={
      val physicalA = (this.Attack - AnyPlayer.Defense)
      AnyPlayer.takeDamage(physicalA)
    }

    def magicAttack(AnyPlayer: CharacterClass): Unit = {
      if (currectMp > 0) {
        currectMp = this.currectMp - AnyPlayer.MagicAttack
        val MagicDamage = this.currectMp - AnyPlayer.MagicDefense
        AnyPlayer.takeDamage(MagicDamage)
    }
   }

    def experience(AnyPlayer: CharacterClass): Unit = {
      if (exp < 20){
        level = 0
        AnyPlayer.currectHP += 5 // 20 + 5 = 25
        AnyPlayer.Attack += 5
      }
      else if (exp >= 20 && exp < 39){
        level = 1
        AnyPlayer.currectHP += 10
        AnyPlayer.Attack += 10
      }
      else if (exp >= 40 && exp < 59){
        level = 2
        AnyPlayer.currectHP += 15
        AnyPlayer.Attack += 15
      }
      else if (exp >= 60 && exp < 79){
        level = 3
        AnyPlayer.currectHP += 20
        AnyPlayer.Attack += 20
      }
      else if (exp >= 80 && exp < 99){
        level = 4
        AnyPlayer.currectHP += 25
        AnyPlayer.Attack += 25
      }
      else{
        level = 5                       // Max level is 5
        AnyPlayer.currectHP += 30      // Max HP gain for level 5
        AnyPlayer.Attack += 30        // Map Attack gain for level 5
      }

    }

    def gainedExperience(AnyPlayer: CharacterClass): Int = {
      val dead = AnyPlayer
      if (!dead.alive){        // the amount of experience gained from defeating a Character
        dead.exp += Defense    // This will increase their Defense
      }
      dead.exp
    }

}


