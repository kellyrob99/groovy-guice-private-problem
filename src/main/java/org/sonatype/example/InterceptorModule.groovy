package org.sonatype.example

import com.google.inject.AbstractModule
import com.google.inject.matcher.Matchers

class InterceptorModule
    extends AbstractModule
{
  final Class testerClass

  InterceptorModule(final Class testerClass) {
    this.testerClass = testerClass
  }

  @Override
  protected void configure() {
    bind(Tester).to(testerClass)
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(InterceptorAnnotation), new Interceptor())
  }
}
