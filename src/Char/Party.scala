package Char

class Party(ListWinner: List[CharacterClass]) extends CharacterClass {  // Winning Team
  def lost(ListLosing: List[CharacterClass]): Unit = {
    var expDead = 0
    var expAlive = 0 // Not using this?

    for (lost <- ListLosing) {
      expDead += gainedExperience(lost) // Dead players and their xp for the winning team that are alive
    }

    for (win <- ListWinner) { //  Going through winning team that's alive
      if (win.alive == true) {
        expAlive += 1 // How many alive player check
      }
      expAlive
    }

    var result = (expDead / expAlive) // Total xp from the dead players / How many alive player there are

    for (aliveWinner <- ListWinner) {
      aliveWinner.exp += result      // Give the xp to the alive players that are on the winning team

    }

  }


}
