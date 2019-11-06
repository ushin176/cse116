package testing
package testing
import org.scalatest.FunSuite
import Char.CharacterClass
import Char.Party
import Char.newCharClass
import Char.Knight
import Char.Slayer


class test2 extends FunSuite {

  test("Testing Battle Options"){
    val Knight1 = new Knight
    val Slayer1 = new Slayer

    Knight1.ThunderAttack(1 )
    Slayer1.LionStrike(20)

    val K_alive = Knight1.alive
    val K_attackStat = Knight1.Attack
    val K_currentStat = Knight1.currectMp

    assert(K_alive == true)
    assert(K_attackStat == 2)
    assert(K_currentStat == 18)

    val S_alive = Slayer1.alive
    val S_attackStat = Slayer1.Attack
    val S_currentStat = Slayer1.currectMp

    assert(S_alive == true)
    assert(S_attackStat == 21)
    assert(S_currentStat == -1)

  }

}
