package org.sonatype.example

import com.google.inject.Guice
import com.google.inject.Injector
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

public class TesterImplTest
{

  @Test
  void testPrivateStaticWithInterceptor() {
    assertThat(interceptedSimple().testPrivateStatic(), equalTo('hello'))
  }

  @Test
  void testPrivateStaticWithoutInterceptor() {
    assertThat(nonInterceptedSimple().testPrivateStatic(), equalTo('hello'))
  }

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
    assertThat(interceptedSimple().testClosure(), equalTo('hello'))
  }

  @Test
  void testClosureStaticWithoutInterceptor() {
    assertThat(nonInterceptedSimple().testClosure(), equalTo('hello'))
  }

  @Test
  void testClosureWithInterceptor() {
    assertThat(interceptedSimple().testClosure(), equalTo('hello'))
  }

  @Test
  void testClosureWithoutInterceptor() {
    assertThat(nonInterceptedSimple().testClosure(), equalTo('hello'))
  }

  @Test
  void testParentPrivate() {
    assertThat(nonInterceptedSimple().testParentPrivate(), equalTo('hello'))
  }
  
  @Test
  void testNoGuice() {
    assertThat(new TesterImpl().testClosurePrivateStatic(), equalTo('hello'))
    assertThat(new TesterImpl().testClosurePrivate(), equalTo('hello'))
    assertThat(new TesterImpl().testPrivateStatic(), equalTo('hello'))
    assertThat(new TesterImpl().testClosure(), equalTo('hello'))
  }

  private Tester interceptedSimple() {
    Injector injector = Guice.createInjector(new InterceptorModule());
    injector.getInstance(Tester)
  }

  private Tester nonInterceptedSimple() {
    Injector injector = Guice.createInjector(new NonInterceptorModule());
    def simple = injector.getInstance(Tester)
    simple
  }
}
