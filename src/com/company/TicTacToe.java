package com.company;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> PlayerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> CPUPositions = new ArrayList<Integer>();
    static ArrayList<Integer> Player2Positions = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println("");
        for (int i = 0; i < 35; i++) {

            System.out.print("*");

        }
        System.out.println("");
        System.out.print("Welcome to TIC-TAC-TOE 2021!");
        System.out.println("");

        for (int i = 0; i < 35; i++) {

            System.out.print("*");

        }
        System.out.println("");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a Number To Select a Difficulty or Game Mode");

        System.out.println("");
        System.out.println("Easy = 1");

        System.out.println("");

        System.out.println("Medium = 2");

        System.out.println("");

        System.out.println("Expert = 3");

        System.out.println("");

        System.out.println("Multiplayer = 4");

        System.out.println("");


        int diff = scan.nextInt();

        if (diff == 1) {
            diff1();
        }
        if (diff == 2) {
            diff2();
        }
        if (diff == 3) {
            System.out.println("c");
        }
        if (diff == 4) {
            multi();
        }

    }

    public static void diff1() {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);
        System.out.println("");
        System.out.println("Enter placement 1-9");
        while (true) {

            Scanner scan = new Scanner(System.in);


            System.out.println("Players Turn");
            int Playerpos = scan.nextInt();
            if (Playerpos > 9) {

                System.out.println("Enter a valid location");
                Playerpos = scan.nextInt();

            }
            int CPUpos = 0;
            while (PlayerPositions.contains(Playerpos) || CPUPositions.contains(Playerpos)) {
                System.out.println("Spot Taken!");
                Playerpos = scan.nextInt();
            }

            placeMove(gameBoard, Playerpos, "Player");


            Random rand = new Random();

            CPUpos = rand.nextInt(9) + 1;

            while (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = rand.nextInt(9) + 1;
            }
            placeMove(gameBoard, CPUpos, "CPU");

            printGameBoard(gameBoard);

            String result = checkWinner();
            if (result.length() > 0) {

                System.out.println(result);
                break;
            }


        }

    }

    public static void diff2() {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);
        System.out.println("");
        System.out.println("Enter placement 1-9");
        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Player Turn");
            int Playerpos = scan.nextInt();

            if (Playerpos > 9) {

                System.out.println("Enter a valid location");
                Playerpos = scan.nextInt();

            }

            while (PlayerPositions.contains(Playerpos) || CPUPositions.contains(Playerpos)) {
                System.out.println("Spot Taken!");
                Playerpos = scan.nextInt();
            }
            placeMove(gameBoard, Playerpos, "Player");


            Random rand = new Random();

            int CPUpos = 5;

            if (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = 1;
            }
            if (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = 7;
            }
            if (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = 3;
            }
            if (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = 9;
            }
            if (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = 1;
            }
            if (PlayerPositions.contains(CPUpos) || CPUPositions.contains(CPUpos)) {
                CPUpos = rand.nextInt(9) + 1;
            }

            placeMove(gameBoard, CPUpos, "CPU");

            printGameBoard(gameBoard);

            String result = checkWinner();
            if (result.length() > 0) {

                System.out.println(result);
                break;
            }


        }

    }


    public static void multi() {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);
        System.out.println("");
        System.out.println("Enter placement 1-9");
        while (true) {

            Scanner scan = new Scanner(System.in);


            System.out.println("Player 1's Turn");
            int Playerpos = scan.nextInt();

            if (Playerpos > 9) {

                System.out.println("Enter a valid location");
                Playerpos = scan.nextInt();

            }
            while (PlayerPositions.contains(Playerpos) || Player2Positions.contains(Playerpos)) {
                System.out.println("Spot Taken!");
                Playerpos = scan.nextInt();
            }
            System.out.println("Player 2's Turn");
            placeMoveMultiplayer(gameBoard, Playerpos, "Player");

            printGameBoard(gameBoard);

            String result = checkWinnerMultiplayer();
            if (result.length() > 0) {

                System.out.println(result);
                break;
            }

            int Player2pos = scan.nextInt();

            if (Player2pos > 9) {

                System.out.println("Enter a valid location");
                Player2pos = scan.nextInt();

            }

            while (Player2Positions.contains(Player2pos) || PlayerPositions.contains(Player2pos)) {
                System.out.println("Spot Taken!");
                Player2pos = scan.nextInt();
            }
            placeMoveMultiplayer(gameBoard, Player2pos, "Player 2");

            printGameBoard(gameBoard);

            result = checkWinnerMultiplayer();
            if (result.length() > 0) {

                System.out.println(result);
                break;
            }
        }

    }

    public static void placeMove(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        if (user.equals("Player")) {
            symbol = 'X';
            PlayerPositions.add(pos);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            CPUPositions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static void placeMoveMultiplayer(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        if (user.equals("Player")) {
            symbol = 'X';
            PlayerPositions.add(pos);
        } else if (user.equals("Player 2")) {
            symbol = 'O';
            Player2Positions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftcol = Arrays.asList(1, 4, 7);
        List midcol = Arrays.asList(2, 5, 8);
        List rightcol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftcol);
        winning.add(midcol);
        winning.add(rightcol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (PlayerPositions.containsAll(l)) {
                return "Player Won";

            } else if (CPUPositions.containsAll(l)) {
                return "CPU Won";

            } else if (PlayerPositions.size() + CPUPositions.size() == 9) {
                return "CAT";
            }
        }

        return "";

    }

    public static String checkWinnerMultiplayer() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftcol = Arrays.asList(1, 4, 7);
        List midcol = Arrays.asList(2, 5, 8);
        List rightcol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftcol);
        winning.add(midcol);
        winning.add(rightcol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (PlayerPositions.containsAll(l)) {
                return "Player 1 Won";

            } else if (Player2Positions.containsAll(l)) {
                return "Player 2 Won";

            } else if (PlayerPositions.size() + Player2Positions.size() == 9) {
                return "CAT";
            }
        }

        return "";

    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {

            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void getStreamOfRandomIntsWithRange(int num, int min, int max) {
        Random random = new Random();
        random.ints(num, min, max).sorted().forEach(System.out::println);

    }

}



