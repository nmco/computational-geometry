package computational.geometry.operators

/**
 * @author Nuno Oliveira
 */
object RichSet {

  implicit class SetCartesianProductWithMap[T1](val setA: Set[T1]) extends AnyVal {
    def cartesianProduct[T2](setB: Set[T2], f: (T1, T2) => _ = (e1:T1, e2:T2) => (e1, e2)) = for (e1 <- setA; e2 <- setB) yield f(e1, e2)
  }
}
