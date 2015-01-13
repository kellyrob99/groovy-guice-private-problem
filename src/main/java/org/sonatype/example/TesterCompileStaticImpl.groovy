package org.sonatype.example

import groovy.transform.CompileStatic

import javax.inject.Named

/**
 * Created by krobinson on 2015-01-11.
 */
@Named
@CompileStatic
class TesterCompileStaticImpl
    implements Tester
{
  @Override
  @InterceptorAnnotation
  String testClosurePrivateStatic() {
    return { testInternalPrivateStatic('hello') }.call()
  }

  @Override
  @InterceptorAnnotation
  String testClosurePrivate() {
    return { testInternalPrivate('hello') }.call()
  }

  @Override
  @InterceptorAnnotation
  String testClosureStatic() {
    return { testInternalStatic('hello') }.call()
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
