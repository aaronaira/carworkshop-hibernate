package org.carworkshop.controllers;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class RegistroController {

    public static void getClientFields(HttpServletRequest request) throws IOException {

        String body = request.getReader().lines().collect(Collectors.joining());
        System.out.println(Arrays.toString(body.split("&")));
    }
}
