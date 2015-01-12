package org.sonatype.example

import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation

/**
 * Created by krobinson on 2015-01-11.
 */
class Interceptor implements MethodInterceptor
{
  @Override
  Object invoke(final MethodInvocation invocation) throws Throwable {
    return invocation.proceed()
  }
}
