package org.sonatype.example

import com.google.inject.AbstractModule

class NonInterceptorModule
    extends AbstractModule
{
  final Class testerClass

  NonInterceptorModule(final Class testerClass) {
    this.testerClass = testerClass
  }

  @Override
  protected void configure() {
    bind(Tester).to(testerClass)
  }
}
