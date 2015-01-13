package org.sonatype.example

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

@Aspect
class InterceptorAspect
{
  @Before("execution(* test*(..))")
  void report(JoinPoint jp) {
    println "Called ${jp.signature.name}"
  }
}
