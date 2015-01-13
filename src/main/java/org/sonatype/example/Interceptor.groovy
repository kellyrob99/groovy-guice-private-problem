package org.sonatype.example

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation

class Interceptor implements MethodInterceptor
{
  @Override
  Object invoke(final MethodInvocation invocation) throws Throwable {
    return invocation.proceed()
  }
}
