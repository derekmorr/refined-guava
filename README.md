# refined-guava

A set of [refinement types](https://github.com/fthomas/refined) for Google's [Guava library](https://github.com/google/guava).



# Quickstart

Checking values at compile-time using helper functions:

```scala
scala> import java.net.InetAddress
import java.net.InetAddress

scala> import com.google.common.net.InternetDomainName
import com.google.common.net.InternetDomainName

scala> import eu.timepit.refined.auto._
import eu.timepit.refined.auto._

scala> import refined.guava.net._
import refined.guava.net._

scala> val ipv4Loopback: InetAddress = ip("127.0.0.1")
ipv4Loopback: java.net.InetAddress = /127.0.0.1

scala> val hostname: InternetDomainName = dns("foo.org.co.uk")
hostname: com.google.common.net.InternetDomainName = foo.org.co.uk
```

Values can also be checked using refinement predicates:

```scala
scala> import eu.timepit.refined.api.Refined
import eu.timepit.refined.api.Refined

scala> import eu.timepit.refined.auto._
import eu.timepit.refined.auto._

scala> import refined.guava.net.net.IP
import refined.guava.net.net.IP

scala> val dns1: String Refined IP = "2001:db8::f00:123"
dns1: eu.timepit.refined.api.Refined[String,refined.guava.net.net.IP] = 2001:db8::f00:123
```

These examples won't compile because they fail validation:

```scala
scala> val notAnIp = ip("hello")
<console>:25: error: IP Address predicate failed: 'hello' is not an IP string literal.
       val notAnIp = ip("hello")
                        ^

scala> val notAHostname = dns("rm -rf /")
<console>:25: error: DNS name predicate failed: Not a valid domain name: 'rm -rf /'
       val notAHostname = dns("rm -rf /")
                              ^
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

