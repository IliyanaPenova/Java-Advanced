package Exams;

import java.util.Scanner;

public class MouseInTheKitchenSecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                // Read the dimensions of the cupboard
                String[] dimensions = scanner.nextLine().split(",");
                int numRows = Integer.parseInt(dimensions[0]);
                int numCols = Integer.parseInt(dimensions[1]);

                // Read the initial state of the cupboard
                char[][] cupboard = new char[numRows][numCols];
                for (int i = 0; i < numRows; i++) {
                    String row = scanner.nextLine();
                    for (int j = 0; j < numCols; j++) {
                        cupboard[i][j] = row.charAt(j);
                    }
                }

                // Find the initial position of the mouse
                int mouseRow = -1, mouseCol = -1;
                for (int i = 0; i < numRows; i++) {
                    for (int j = 0; j < numCols; j++) {
                        if (cupboard[i][j] == 'M') {
                            mouseRow = i;
                            mouseCol = j;
                            break;
                        }
                    }
                }

                // Process the directions until "danger" command is encountered
                String direction = scanner.nextLine();
                while (!direction.equals("danger")) {
                    // Move the mouse based on the given direction
                    int newRow = mouseRow, newCol = mouseCol;
                    if (direction.equals("up")) {
                        newRow--;
                    } else if (direction.equals("down")) {
                        newRow++;
                    } else if (direction.equals("left")) {
                        newCol--;
                    } else if (direction.equals("right")) {
                        newCol++;
                    }

                    // Check if the new position is valid
                    if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                        System.out.println("No more cheese for tonight!");
                        break;
                    }

                    // Check the character at the new position
                    char newPos = cupboard[newRow][newCol];
                    if (newPos == '@') {
                        // Hit a wall, skip the command
                        direction = scanner.nextLine();
                        continue;
                    } else if (newPos == 'C') {
                        // Found cheese, eat it
                        cupboard[newRow][newCol] = '*';
                        boolean cheeseLeft = false;
                        for (int i = 0; i < numRows; i++) {
                            for (int j = 0; j < numCols; j++) {
                                if (cupboard[i][j] == 'C') {
                                    cheeseLeft = true;
                                    break;
                                }
                            }
                        }
                        if (!cheeseLeft) {
                            System.out.println("Happy mouse! All the cheese is eaten, good night!");
                            cupboard[mouseRow][mouseCol] = '*';
                            cupboard[newRow][newCol] = 'M';
                            break;
                        }
                    } else if (newPos == 'T') {
                        // Caught in a trap
                        cupboard[mouseRow][mouseCol] = '*';
                        System.out.println("Mouse is trapped!");
                        cupboard[mouseRow][mouseCol] = '*';
                        cupboard[newRow][newCol] = 'M';
                        break;
                    }

                    // Update the mouse position
                   cupboard[mouseRow][mouseCol] = '*';
                    cupboard[newRow][newCol] = 'M';
                    mouseRow = newRow;
                    mouseCol = newCol;
                    // Read the next direction
                    direction = scanner.nextLine();
                }

                if (direction.equals("danger")) {
                    System.out.println("Mouse will come back later!");

                }

                // Print the final state of the cupboard
                for (int i = 0; i < numRows; i++) {
                    for (int j = 0; j < numCols; j++) {
                        System.out.print(cupboard[i][j]);
                    }
                    System.out.println();
                }
            }
        }
