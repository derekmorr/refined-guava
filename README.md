# refined-guava

A set of [refinement types](https://github.com/fthomas/refined) for Google's [Guava library](https://github.com/google/guava).



# Quickstart

```scala
import java.net.InetAddress
import com.google.common.net.InternetDomainName
import eu.timepit.refined.auto._
import refined.guava.net._

// these values are checked at compile-time to be valid
val ipv4Loopback: InetAddress = ip("127.0.0.1")
val hostname: InternetDomainName = dns("foo.org.co.uk")
  
// this examples won't compile because they fail validation
// val notAnIp = ip("hello")
// val notAHostname = dns("rm -rf /")
  
// using refinement predicates
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import refined.guava.net.net.IP

val dns1: String Refined IP = "2001:db8::f00:123"
```



# Testing the app

To run unit tests, run

    sbt test


# Code coverage report

To generate a code coverage report run,

    sbt clean coverage test coverageReport

The HTML report will be written to `target/scala-2.11/scoverage-report/index.html`.



# Code quality analysis

The project uses the [scapegoat tool](https://github.com/sksamuel/scapegoat) for code quality analysis.
Run run a scapegoat report, run

    sbt scapegoat

The HTML report will be written to `target/scala-2.11/scapegoat-report/scapegoat.html`

