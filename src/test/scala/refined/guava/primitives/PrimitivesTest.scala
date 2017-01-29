package refined.guava.primitives

import eu.timepit.refined.auto._
import eu.timepit.refined.{refineV, refineMV}
import refined.guava.BaseTest
import refined.guava.primitives.primitives.RadixInterval

/**
  * Unit tests for [[primitives]]
  */
class PrimitivesTest extends BaseTest {

  "Primitives package" must {
    "process unsigned integers" which {
      "rejects invalid inputs" when {
        "input is non-numeric" in {
          """uint("hello")""" mustNot compile
        }

        "input is negative" in {
          """uint("-4")""" mustNot compile
        }
      }

      "accepts valid inputs" when {
        "using the default radix" in {
          // maxint + 1
          uint("2147483648").longValue() must === (2147483648L)
        }

        "using a custom radix" in {
          uint("100", 2).longValue must === (4L)
        }
      }
    }

    "process unsigned longs" which {
      "rejects invalid inputs" when {
        "input is non-numeric" in {
          """ulong("hello")""" mustNot compile
        }

        "input is negative" in {
          """ulong("-4")""" mustNot compile
        }

        "the radix is out of range" in {
          """ulong(100L, 40)""" mustNot compile
        }
      }

      "accepts valid inputs" when {
        "using the default radix" in {
          // maxlong + 1
          """ulong("9223372036854775808")""" must compile
        }

        "using a custom radix" in {
          ulong("100", 2).longValue must === (4L)
        }
      }

    }

    "process radix values" which {
      "reject invalid values" when {
        "input is negative" in {
          refineV[RadixInterval](-1) mustBe 'left
        }

        "input is above supported radix" in {
          refineV[RadixInterval](37) mustBe 'left
        }

        "input is below supported radix" in {
          refineV[RadixInterval](1) mustBe 'left
        }
      }

      "accept valid inputs" in {
        refineMV[RadixInterval](2).value must === (2)
      }
    }
  }

}
