package org.sonatype.example

import com.google.inject.AbstractModule
import com.google.inject.matcher.Matchers

/**
 * Created by krobinson on 2015-01-11.
 */
class InterceptorModule
    extends AbstractModule
{
  @Override
  protected void configure() {
    bind(Tester).to(TesterImpl)
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(InterceptorAnnotation), new Interceptor())
  }
}
