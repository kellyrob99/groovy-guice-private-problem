package org.sonatype.example

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Created by krobinson on 2015-01-11.
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
@interface InterceptorAnnotation{ }
