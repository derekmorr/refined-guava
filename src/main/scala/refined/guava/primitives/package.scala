package refined.guava

import com.google.common.primitives.{UnsignedInteger, UnsignedLong}
import eu.timepit.refined.api.Refined
import refined.guava.primitives.primitives.{RadixInterval, UInt, ULong}

/**
  * Helper functions for Guava primitives.
  */
package object primitives {
  def uint(s: String Refined UInt): UnsignedInteger =
    UnsignedInteger.valueOf(s.value)

  def uint(s: String Refined UInt, radix: Int Refined RadixInterval): UnsignedInteger =
    UnsignedInteger.valueOf(s.value, radix.value)

  def ulong(s: String Refined ULong): UnsignedLong =
    UnsignedLong.valueOf(s.value)

  def ulong(s: String Refined ULong, radix: Int Refined RadixInterval): UnsignedLong =
    UnsignedLong.valueOf(s.value, radix.value)
}
