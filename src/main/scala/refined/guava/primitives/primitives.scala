package refined.guava.primitives

import com.google.common.primitives.{UnsignedInteger, UnsignedLong}
import eu.timepit.refined.W
import eu.timepit.refined.api.Validate
import eu.timepit.refined.numeric.Interval
import refined.guava.primitives.primitives.{UInt, ULong}


object primitives extends PrimitivesValidate {
  case class UInt()
  case class ULong()

  type RadixInterval = Interval.Closed[W.`2`.T, W.`36`.T]
}

private[primitives] trait PrimitivesValidate {
  implicit def unsignedIntValidate: Validate.Plain[String, UInt] =
    Validate.fromPartial(UnsignedInteger.valueOf, "UnsignedInteger", UInt())

  implicit def unsignedLongValidate: Validate.Plain[String, ULong] =
    Validate.fromPartial(UnsignedLong.valueOf, "UnsignedInteger", ULong())
}
