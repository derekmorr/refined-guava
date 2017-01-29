package refined.guava

import java.net.{Inet4Address, Inet6Address, InetAddress}

import com.google.common.net.{InetAddresses, InternetDomainName, MediaType}
import eu.timepit.refined.api.Refined
import refined.guava.net.net.{DNS, IP, IPv4, IPv6, Media}

/**
  * Helper functions for Guava network types
  */
package object net {
  def ip(s: String Refined IP): InetAddress =
    InetAddresses.forString(s.value)

  def ipv4(s: String Refined IPv4): Inet4Address =
    InetAddresses.forString(s.value).asInstanceOf[Inet4Address]

  def ipv6(s: String Refined IPv6): Inet6Address =
    InetAddresses.forString(s.value).asInstanceOf[Inet6Address]

  def dns(s: String Refined DNS): InternetDomainName =
    InternetDomainName.from(s.value)

  def media(s: String Refined Media): MediaType =
    MediaType.parse(s.value)

}
