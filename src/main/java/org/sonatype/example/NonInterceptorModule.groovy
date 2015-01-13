package org.sonatype.example

import com.google.inject.AbstractModule

/**
 * Created by krobinson on 2015-01-11.
 */
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
