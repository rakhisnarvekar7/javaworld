package com.hsbc.java.main;

import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;

public class FileHandlingApplication {
    public static void main(String[] args) {
        String inputFilePath = "D:\\HSBCAssignment\\input.txt"; // Replace with your input file path
        String outputFilePath = "D:\\HSBCAssignment\\output.txt"; // Replace with your output file path

        try {
            // Read the content of the input file
            String fileContent = readFile(inputFilePath);

            // Reverse the content
            String reversedContent = reverseString(fileContent);

            // Write the reversed content to the output file
            writeFile(outputFilePath, reversedContent);

            System.out.println("File content reversed and written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    private static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
