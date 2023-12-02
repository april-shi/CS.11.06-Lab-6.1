import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        int challengeOneAnswer = challengeOne("inputOneTwo.txt");
        int challengeTwoAnswer = challengeTwo("inputOneTwo.txt");
        int challengeThreeAnswer = challengeThree("inputThreeFour.txt");
        int challengeFourAnswer = challengeFour("inputThreeFour.txt");

        System.out.println(challengeOneAnswer);
        System.out.println(challengeTwoAnswer);
        System.out.println(challengeThreeAnswer);
        System.out.println(challengeFourAnswer);

        writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer,
                challengeTwoAnswer, challengeThreeAnswer, challengeFourAnswer);

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {

        int[] data = readFile(fileName);

        return countIncreases(data);

    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {

        int[] data = readFile(fileName);

        int[] result = new int[data.length - 2];

        for (int i = 0; i < data.length - 2; i++) {

            result[i] = data[i] + data[i+1] + data[i+2];

        }

        return countIncreases(result);

    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {

        String[] data = readFileTwo(fileName);

        int depth = 0;

        int horizontal = 0;

        for (int i = 0; i < data.length; i++) {

            String[] command = data[i].split(" ");

            String direction = command[0];

            int distance = Integer.parseInt(command[1]);

            if (direction.equals("forward")) {

                horizontal += distance;

            } else if (direction.equals("down")) {

                depth += distance;

            } else if (direction.equals("up")) {

                depth -= distance;

            } else {

                System.out.println("error: I don't know what " + direction + " is.");

            }


        }

        return horizontal*depth;

    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {

        String[] data = readFileTwo(filename);

        int depth = 0;

        int horizontal = 0;

        int aim = 0;

        for (int i = 0; i < data.length; i++) {

            String[] command = data[i].split(" ");

            String direction = command[0];

            int distance = Integer.parseInt(command[1]);

            if (direction.equals("forward")) {

                horizontal += distance;
                depth += aim*distance;

            } else if (direction.equals("down")) {

                aim += distance;

            } else if (direction.equals("up")) {

                aim -= distance;

            } else {

                System.out.println("error: I don't know what " + direction + " is.");

            }

        }

        return horizontal*depth;

    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {

        File file = new File(inputFilename);

        Scanner scanner = new Scanner(file);

        int numberOfLinesInFile = countLinesInFile(inputFilename);

        int[] data = new int[numberOfLinesInFile];

        int index = 0;

        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }

        scanner.close();

        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {

        File file = new File(inputFilename);

        Scanner scanner = new Scanner(file);

        int lineCount = 0;

        while (scanner.hasNextLine()) {

            lineCount++;
            scanner.nextLine();

        }

        scanner.close();

        return lineCount;
    }

    private static String[] readFileTwo(String inputFilename) throws FileNotFoundException {

        File file = new File(inputFilename);

        Scanner scanner = new Scanner(file);

        int numberOfLinesInFile = countLinesInFile(inputFilename);

        String[] data = new String[numberOfLinesInFile];

        int index = 0;

        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }

        scanner.close();

        return data;
    }

    private static int countIncreases(int[] data) {

        int count = 0;

        for (int i = 0; i < data.length - 1; i++) {

            if (data[i+1] > data[i]) {

                count += 1;

            }

        }

        return count;

    }

}