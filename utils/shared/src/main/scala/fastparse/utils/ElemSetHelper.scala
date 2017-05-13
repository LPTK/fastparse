package fastparse.utils
import acyclic.file

trait ElemSetHelper[Elem] {
  def toInt(a: Elem): Int
  def ordering: Ordering[Elem]
  def toLowerCase(in: Elem): Elem
  def generateValues(f: Elem => Unit)

}
object ElemSetHelper {

  implicit object CharBitSetHelper extends ElemSetHelper[Char] {
    def toInt(a: Char): Int = a
    def ordering = implicitly[Ordering[Char]]
    def toLowerCase(in: Char) = in.toLower
    def generateValues(f: Char => Unit) = {
      var i = Char.MinValue.toInt

      while(i <= Char.MaxValue){
        f(i.toChar)
        i = i + 1
      }
    }
  }

}