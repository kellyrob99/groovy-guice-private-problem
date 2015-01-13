package org.sonatype.example

import com.google.inject.Guice
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

public class TesterCompileStaticImplTest
{

  /**
   * Fails on v 2.1.8-01 +
   */
  @Test
  void testClosurePrivateStaticWithInterceptor() {
    assertThat(interceptedSimple().testClosurePrivateStatic(), equalTo('hello'))
  }

  @Test
  void testClosurePrivateStaticWithoutInterceptor() {
    assertThat(nonInterceptedSimple().testClosurePrivateStatic(), equalTo('hello'))
  }

  @Test
  void testClosureStaticWithInterceptor() {
    assertThat(interceptedSimple().testClosureStatic(), equalTo('hello'))
  }

  @Test
  void testClosureStaticWithoutInterceptor() {
    assertThat(nonInterceptedSimple().testClosureStatic(), equalTo('hello'))
  }

  /**
   * Fails on v 2.1.5-03 +
   */
  @Test
  void testClosurePrivateWithInterceptor() {
    assertThat(interceptedSimple().testClosurePrivate(), equalTo('hello'))
  }

  @Test
  void testClosurePrivateWithoutInterceptor() {
    assertThat(nonInterceptedSimple().testClosurePrivate(), equalTo('hello'))
  }
  
  @Test
  void testNoGuice() {
    Tester tester = new TesterCompileStaticImpl()
    assertThat(tester.testClosurePrivateStatic(), equalTo('hello'))
    assertThat(tester.testClosurePrivate(), equalTo('hello'))
    assertThat(tester.testClosureStatic(), equalTo('hello'))
  }

  private Tester interceptedSimple() {
    Guice.createInjector(new InterceptorModule(TesterCompileStaticImpl)).getInstance(Tester)
  }

  private Tester nonInterceptedSimple() {
    Guice.createInjector(new NonInterceptorModule(TesterCompileStaticImpl)).getInstance(Tester)
  }
}
