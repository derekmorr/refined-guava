package refined.guava

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.{DoNotDiscover, EitherValues, MustMatchers, WordSpec}


/**
  * Base class for tests.
  */
@DoNotDiscover
class BaseTest
  extends WordSpec
  with MustMatchers
  with EitherValues
  with TypeCheckedTripleEquals {

}
