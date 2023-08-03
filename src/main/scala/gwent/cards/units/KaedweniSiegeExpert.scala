package cl.uchile.dcc
package gwent.cards.units

import gwent.cards.SiegeCombatUnit

import gwent.cards.abilities.{Ability, MoraleBoost}

/** A class that represent the Kaedweni Siege Expert Unit Card.
 * Ability: Morale Boost.
 */
class KaedweniSiegeExpert extends SiegeCombatUnit("Kaedweni Siege Expert", 1) {

  override val ability: Ability = new MoraleBoost
  
  //Equals, hashCode y toString -------------------------------------------

  /** A function that compares the types of two values.
   *
   * @param that The other value to compare.
   * @return True if the two values have the same type.
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[KaedweniSiegeExpert]

  /** A function that compares the structure of two objects.
   *
   * @param that The object to compare.
   * @return True if the two objects have the same structure.
   */
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      super.equals(that)
    }
    else {
      false
    }
  }

  /** A function that generates a hash value to an object.
   *
   * @return The hash value.
   */
  override def hashCode(): Int = {
    val primo = 31
    var total = 1
    total = primo * total + classOf[KaedweniSiegeExpert].##
    total = primo * total + name.##
    total = primo * total + basePower
    total
  }

  override def toString: String = s"KaedweniSiegeExpert(basePower=$getBasePower, currentPower=$currentPower, ability=MoraleBoost)"
  //----------------------------------------------------------
  
}
