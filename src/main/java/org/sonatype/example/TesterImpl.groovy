package org.sonatype.example

import javax.inject.Named

/**
 * Created by krobinson on 2015-01-11.
 */
@Named
class TesterImpl
    implements Tester
{

  @Override
  @InterceptorAnnotation
  String testPrivateStatic() {
    testInternalPrivateStatic('hello')
  }

  @Override
  @InterceptorAnnotation
  String testClosurePrivateStatic() {
    return ['hello'].collect { testInternalPrivateStatic('hello') }[0]
  }

  @Override
  @InterceptorAnnotation
  String testClosurePrivate() {
    return { testInternalPrivate('hello') }.call()
  }

  @Override
  @InterceptorAnnotation
  String testClosure() {
    return { testInternalStatic('hello') }.call()
  }

  @Override
  String testParentPrivate() {
    ['hello'].collect{parentPrivate(it)}[0]
  }

  private static String testInternalPrivateStatic(String msg) {
    return msg
  }

  static String testInternalStatic(String msg) {
    return msg
  }

  private String testInternalPrivate(String msg) {
    return msg
  }
}
