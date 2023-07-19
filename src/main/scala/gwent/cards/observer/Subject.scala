package cl.uchile.dcc
package gwent.cards.observer

trait Subject {

  def addObserver(observer: Observer): Unit
  def notifyObservers(value: Any): Unit

}
