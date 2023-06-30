package com.example.demobestpracticies.controller.convertion;

import com.example.demobestpracticies.controller.convertion.impl.RutConverter;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@JacksonAnnotationsInside
@JsonSerialize(converter = RutConverter.class)
@JsonDeserialize(converter = RutConverter.class)
public @interface RutTranformation {
}
