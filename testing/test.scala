package testing
import org.scalatest.FunSuite
import Char.CharacterClass
import Char.Party


class test extends FunSuite {

  test("Testing Damage") {
      val player1 = new CharacterClass
      val player2 = new CharacterClass

      player1.takeDamage(1 )
      player2.takeDamage(20)

      val hp = player1.currectHP
      val alive = player1.alive
      val dead = player2.alive
      val hp2 = player2.currectHP

      assert(hp == 0)
      assert(alive == true)
      assert(hp2 == -19)
      assert(dead == true)
    }

  test("Attack!"){
    val player3 = new CharacterClass
    val player4 = new CharacterClass

    val player = new CharacterClass // testing for MP only

    val attackingOtherPlayer1 = player3.Attack - player4.currectHP
    val attackingOtherPlayer2 = player4.Attack - player3.currectHP

    val magicAttackP1 = player3.MagicAttack - player3.MagicDefense
    val magicAttackP2 = player4.MagicAttack - player3.MagicDefense

    assert(magicAttackP1 == -1)
    assert(magicAttackP2 == -1)

    assert(attackingOtherPlayer1 == 0)
    assert(attackingOtherPlayer2 == 0)

    val leftMp1 = player3.MagicAttack - player3.currectMp
    val leftMp2 = player4.MagicAttack - player4.currectMp

    assert(leftMp1 == -17)
    assert(leftMp2 == -17)

    val mpTank = player.mpLevel

    assert(mpTank == 0)
  }

  test("leveling"){
    val player5 = new CharacterClass
    val player6 = new CharacterClass
    val player7 = new CharacterClass
    val player8 = new CharacterClass
    val player9 = new CharacterClass
    val player10 = new CharacterClass

    val player11 = new CharacterClass // player gains enough experience at one time to increase to that level


    player5.exp = 19     // checking if 20 xp is going to be level 1 and +5 for hp and +5 for attack
    player5.experience(player5)
    assert(player5.level == 0)
    assert(player5.currectHP == 6)
    assert(player5.Attack == 6)

    player6.exp = 21
    player6.experience(player6)
    assert(player6.level == 1)
    assert(player6.currectHP == 11)
    assert(player6.Attack == 11)

    player7.exp = 41
    player7.experience(player7)
    assert(player7.level == 2)
    assert(player7.currectHP == 16)
    assert(player7.Attack == 16)

    player8.exp = 62
    player8.experience(player8)
    assert(player8.level == 3)
    assert(player8.currectHP == 21)
    assert(player8.Attack == 21)

    player9.exp = 81
    player9.experience(player9)
    assert(player9.level == 4)
    assert(player9.currectHP == 26)
    assert(player9.Attack == 26)

    player10.exp = 100
    player10.experience(player10)
    assert(player10.level == 5)
    assert(player10.currectHP == 31)
    assert(player10.Attack == 31)

    player11.exp = 98   // player gains enough experience at one time to increase to that level  // 98 exp at once
    player11.experience(player11)
    assert(player11.level == 4)    // Player get to level 4 right away
    assert(player11.currectHP == 26)  // This increase since hp was 1 then 26 gained HP for being level 4
  }

  test("Gained Experience"){
    val player11 = new CharacterClass
    player11.gainedExperience(player11)
    assert(player11.Defense == 10)

    val player12 = new CharacterClass
    player12.gainedExperience(player12)
    assert(player12.exp == 0)
  }

  test("Party Testing"){
    val player13 = new CharacterClass
    val player14 = new CharacterClass
    val player15 = new CharacterClass
    val player16 = new CharacterClass

    player15.alive = false // One player is dead + 10 defence/exp
    player16.alive = false // One player is dead + 10 defence/exp

    // 20 defence/exp total points

    val containGroup1 = List(player13, player14) // Winning team
    val containGroup2 = List(player15, player16) // Losing team

    val partyA = new Party(containGroup1)  // Winning

    partyA.lost(containGroup2) // Losing

    // Two players that is alive, there 20/2 is 10 per each alive player

    assert(player13.exp == 10)

  }

}