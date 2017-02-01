package refined.guava.net

import java.net.{Inet4Address, Inet6Address}

import com.google.common.net.{InetAddresses, InternetDomainName, MediaType}
import eu.timepit.refined.api.Validate
import refined.guava.net.net.{DNS, IP, IPv4, IPv6, Media}

object net extends NetValidate {
  case class IP()
  case class IPv4()
  case class IPv6()
  case class DNS()
  case class Media()
}

private[net] trait NetValidate {
  implicit def ipValidate: Validate.Plain[String, IP] =
    Validate.fromPartial(InetAddresses.forString, "IP Address", IP())

  implicit def ipv4Validate: Validate.Plain[String, IPv4] =
    Validate.fromPredicate(
      str => InetAddresses.forString(str).isInstanceOf[Inet4Address],
      str => s"$str is not an IPv4 Address",
      IPv4())

  implicit def ipv6Validate: Validate.Plain[String, IPv6] =
    Validate.fromPredicate(
      str => InetAddresses.forString(str).isInstanceOf[Inet6Address],
      str => s"$str is not an IPv6 Address",
      IPv6())


  implicit def dnsValidate: Validate.Plain[String, DNS] =
    Validate.fromPartial(InternetDomainName.from, "DNS name", DNS())

  implicit def mediaValidate: Validate.Plain[String, Media] =
    Validate.fromPartial(MediaType.parse, "MediaType", Media())

}
