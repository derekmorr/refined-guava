package refined.guava.net

import eu.timepit.refined.auto._
import refined.guava.BaseTest

/**
  * Unit tests for [[net]] package
  */
class NetTest extends BaseTest {

  "Net package" must {
    "process IP addresses" which {
      "rejects inputs" when {
        "input is not an IP address" in {
          """ip("hello")""" mustNot compile
        }

        "input looks like an IP address, but isn't" in {
          """ip("999.999.999.999")""" mustNot compile
        }
      }

      "accepts inputs" when {
        "input is an IPv4 address" in {
          """ip("192.168.0.1")""" must compile
        }

        "input is an IPv6 address" in {
          """ip("2001:db8::1")""" must compile
        }
      }

    }

    "process IPv4 addresses" which {
      "rejects inputs" when {
        "input is not an IP address" in {
          """ipv4("hello")""" mustNot compile
        }

        "input is an IPv6 address" in {
          """ipv4("2001:db8::1")""" mustNot compile
        }
      }

      "accepts inputs" when {
        "input is an IPv4 address" in {
          """ipv4("192.168.0.1")""" must compile
        }
      }
    }

    "process IPv6 addresses" which {
      "rejects inputs" when {
        "input is not an IP address" in {
          """ipv6("hello")""" mustNot compile
        }

        "input is an IPv4 address" in {
          """ipv6("192.168.0.1")""" mustNot compile
        }
      }

      "accepts inputs" when {
        "input is an IPv6 address" in {
          """ipv6("2001:db8::1")""" must compile
        }
      }
    }

    "process Internet domain names" which {
      "accepts inputs" when {
        "input is valid" in {
          """dns("foo.org.co.uk")""" must compile
        }
      }

      "rejects input" when {
        "input contains illegal characters" in {
          """dns("jjjj.,<>")""" mustNot compile
        }

        "input is too long" in {
          """"dns("ThisDNSLabelIsTooLongPerRFC1035WhichSayssDNSLablesMayOnlyBe63CharactersLong")"""" mustNot compile
        }

        "input is empty" in {
          """dns("")""" mustNot compile
        }
      }

      "process media types" which {
        "rejects invalid inputs" in {
          """media("ljhlkjhlkjhlkjhlk")""" mustNot compile
        }

        "accepts valid inputs" in {
          """media("text/html")""" must compile
        }
      }
    }
  }
}
