package com.example.demobestpracticies.controller.convertion.impl;

import com.fasterxml.jackson.databind.util.StdConverter;

public class RutConverter extends StdConverter<String, String> {
    @Override
    public String convert(String value) {
        if (value == null) {
            return null;
        }
        return value.replace(".", "");
    }
}