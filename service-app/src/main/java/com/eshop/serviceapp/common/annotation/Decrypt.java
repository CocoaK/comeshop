package com.eshop.serviceapp.common.annotation;

import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Component
@Documented
public @interface Decrypt {
}
