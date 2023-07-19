package cl.uchile.dcc
package gwent.cards.observer

trait Observer {

  def update(observable: Subject, value: Any): Unit

}
