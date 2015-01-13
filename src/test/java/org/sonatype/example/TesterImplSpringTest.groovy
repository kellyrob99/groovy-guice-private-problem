package org.sonatype.example

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.hamcrest.CoreMatchers.equalTo
import static org.junit.Assert.assertThat

@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TesterImplSpringTest
{

  @Autowired @Qualifier("tester")
  private Tester tester

  @Autowired @Qualifier("testerCompileStatic")
  private Tester testerCompileStatic
  
  @Test
  void testClosurePrivateStatic() {
    assertThat(tester.testClosurePrivateStatic(), equalTo('hello'))
  }

  @Test
  void testClosureStatic() {
    assertThat(tester.testClosureStatic(), equalTo('hello'))
  }
  
  @Test
  void testClosurePrivate() {
    assertThat(tester.testClosurePrivate(), equalTo('hello'))
  }

  @Test
  void testCompileStaticClosurePrivateStatic() {
    assertThat(testerCompileStatic.testClosurePrivateStatic(), equalTo('hello'))
  }

  @Test
  void testCompileStaticClosureStatic() {
    assertThat(testerCompileStatic.testClosureStatic(), equalTo('hello'))
  }

  @Test
  void testCompileStaticClosurePrivate() {
    assertThat(testerCompileStatic.testClosurePrivate(), equalTo('hello'))
  }
}
