package ru.job4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean workProgramm = true;
        boolean notPause = true;
        List<String> inputDialog = new ArrayList<>();
        List<String> answers = readPhrases();
        Random random = new Random();
        while (workProgramm) {
            Scanner scanner = new Scanner(System.in);
            String inputStr = scanner.nextLine();
            inputDialog.add(inputStr);
            if (OUT.equals(inputStr)) {
                workProgramm = false;
                continue;
            }
            if (STOP.equals(inputStr)) {
                notPause = false;
            }
            if (notPause) {
                String answer = answers.get(random.nextInt(answers.size()));
                System.out.println(answer);
                inputDialog.add(answer);
            } else if (CONTINUE.equals(inputStr)) {
                notPause = true;
            }
        }
        saveLog(inputDialog);
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("./data/botDialog.txt", "./data/botAnswers.txt");
        consoleChat.run();
    }
}
