package com.equation.EquationAnalyzer.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationAnalyzer {

    public static String analyzeEquation(String equation) {
        String response = "";

        // Verificar orden (máxima derivada)
        int order = findOrder(equation);
        response += "El orden de la ecuación es: " + order + "\n";

        // Verificar si es lineal
        boolean isLinear = checkLinearity(equation);
        response += "La ecuación es " + (isLinear ? "lineal." : "no lineal.");

        return response;
    }

    // Método para encontrar el orden de la ecuación
    private static int findOrder(String equation) {
        // Buscar las derivadas y'', y''', etc.
        Pattern pattern = Pattern.compile("y(\\'|\\'\\'|\\'\\'\\')+");
        Matcher matcher = pattern.matcher(equation);
        int maxOrder = 0;

        while (matcher.find()) {
            String derivative = matcher.group();
            int currentOrder = derivative.length() - 1; // Contar los apóstrofes
            maxOrder = Math.max(maxOrder, currentOrder);
        }

        return maxOrder;
    }

    // Método para verificar si la ecuación es lineal
    private static boolean checkLinearity(String equation) {
        // Verificar si hay términos no lineales como sen, cos, log, etc.
        Pattern nonLinearPattern = Pattern.compile("(y\\^|sen|cos|log|exp)");
        Matcher matcher = nonLinearPattern.matcher(equation);
        return !matcher.find(); // Si no encuentra, es lineal
    }
}