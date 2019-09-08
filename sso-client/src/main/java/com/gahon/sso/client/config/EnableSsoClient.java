package com.gahon.sso.client.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Gahon
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(WebConfigure.class)
public @interface EnableSsoClient {
}
