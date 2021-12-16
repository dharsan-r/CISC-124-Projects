import java.util.Scanner; // imports the scanner class
import java.util.Random; // imports the random class
import java.util.Arrays; //imports the array class

/**
 * Zanzibar; code for game where players are selected from coin tosses and points are calculated using
 * dice rolls. The winner is the person who runs out of chips first. A randomized computer player is also implemented.
 *
 * @author Dharsan Ravindran
 * @since 2021-07-19
 * @version 1.0
 * Student ID: 20219218
 * instructor: Professor Paul Allison
 */
public class Main {
    static Scanner in = new Scanner(System.in); // initializes a new scanner
    static Random rand = new Random(); // initializes a new random

    /**
     * Uses the random object to select a random yes or no answer for the computer player.
     *
     * @return answer a string 'Y' or 'N' randomly from the string array
     */
    public static String computerAnswer(){
        String [] answer = {"Y", "N"};
        int select = rand.nextInt(answer.length);
        return answer[select];
    }

    /**
     * Randomly returns either the number 1 or 2 representing heads or tails respectively
     *
     * @return number 1 or 2 using the random
     */
    public static int coinToss() {
        return rand.nextInt(2) + 1;
    }

    /**
     * Randomly generates an integer array of length 3 with elements ranging from the numbers 1 through 6.
     * To simulate a single dice roll with the 3 dice combination.
     *
     * @return dice an array with 3 integers representing a 3 dice roll
     */
    public static int[] diceRoll() {
        int[] dice = new int[3];
        for (int x = 0; x < dice.length; x++) {
            dice[x] = rand.nextInt(6) + 1;
        }
        return dice;
    }

    /**
     * Calculates the amount of points for a single 3 dice roll.
     *
     * @param roll an array that contains a single 3 dice roll
     * @return totalPoints an integer that is the total points for a roll
     */
    public static int pointCal(int[] roll) {
        int totalPoints = 0;
        for (int i : roll) {
            if (i == 1) {
                totalPoints += 100;
            } else if (i == 6) {
                totalPoints += 60;
            } else if (i == 2) {
                totalPoints += 2;
            } else if (i == 3) {
                totalPoints += 3;
            } else if (i == 4) {
                totalPoints += 4;
            } else {
                totalPoints += 5;
            }
        }
        return totalPoints;
    }

    /**
     *Finds the largest amount of points and the index of that player among an array of points.
     *
     * @param points the integer array that contains the points of all the players
     * @return max an integer array with the index of the player with highest points and the highest points
     */
    public static int[] mostPoints(int[] points) {
        int max = points[0];
        int maxIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (max < points[i]) {
                max = points[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, max};

    }

    /**
     *Finds the smallest amount of points and the index of that player among an array of points.
     *
     * @param points the integer array that contains the points of all the players
     * @return low an integer array with the index of the player with lowest points and the lowest points
     */
    public static int[] lowPoints(int[] points) {
        int low = points[0];
        int lowIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (low > points[i]) {
                low = points[i];
                lowIndex = i;
            }
        }
        return new int[]{lowIndex, low};
    }

    /**
     *Checks how much chips must be given to the lowest player depending on the max players dice roll.
     *
     * @param dice the integer array that contains a single 3 dice roll
     * @return chipLoss an integer ranging from 1-4 depending on the specific dice roll
     */
    public static int chipLoss(int[] dice) {
        int chipLoss = 1;
        int[] sequence = {1, 2, 3};
        int[] zanzibar = {4, 5, 6};
        Arrays.sort(dice); // sorts the dice roll as the order of sequences do not matter
        if (Arrays.equals(dice, sequence)) {
            chipLoss = 2;
        } else if (threeOfKind(dice)) { //calls the 3 of a kind method to see if any dice is 3 of a kind
            chipLoss = 3;
        } else if (Arrays.equals(dice, zanzibar)) {
            chipLoss = 4;
        }
        return chipLoss;
    }

    /**
     *Checks if a dice roll satisfies the 3 of a kind condition where all 3 dice are.
     *
     * @param dice the integer array that contains a single 3 dice roll
     * @return boolean depending on if the dice roll was a three of a kind
     */
    public static boolean threeOfKind(int[] dice) {
        int[][] threeOfKind = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}, {5, 5, 5}, {6, 6, 6}};
        if (Arrays.equals(dice, threeOfKind[0])) {
            return true;
        } else if (Arrays.equals(dice, threeOfKind[1])) {
            return true;
        } else if (Arrays.equals(dice, threeOfKind[2])) {
            return true;
        } else if (Arrays.equals(dice, threeOfKind[3])) {
            return true;
        } else if (Arrays.equals(dice, threeOfKind[4])) {
            return true;
        } else {
            return Arrays.equals(dice, threeOfKind[5]);
        }
    }

    /**
     *Conducts one turn of the game calculating the total points and conducting a dice roll for a player.
     *
     * @param playerNum the integer that contains the amount of players in a game
     * @param x the index in which the players dice roll will be stored
     * @return dice roll an array that contains a dice roll of a specific player
     */
    public static int[] turn1(int playerNum, int x) {
        int totalPoint;
        int[][] diceRolls = new int[playerNum][3];
        diceRolls[x] = diceRoll(); // calls the dice roll method to get an array for a single roll
        System.out.println(Arrays.toString(diceRolls[x]));
        totalPoint = pointCal(diceRolls[x]); // calculates the points for that specific array
        System.out.println("Your points total is: " + totalPoint);
        return diceRolls[x];
    }

    /**
     *Asks user how many payers will be playing and how many default chips they would like, storing both in an integer
     * array,
     *
     * @return playerEntry and array that contains the amount of default starting chips and the number of players
     */
    public static int[] playerEntry(){
        int defaultChip = 15;
        int[] playerEntry = new int[2];
        System.out.println("Please enter the number of Players:");
        int playerNum = in.nextInt();
        in.nextLine();
        playerEntry[0] = playerNum+1; // adds one player for the computer player
        System.out.println("\nWould you like to enter your own # of chips?(Enter 'Y' or 'N'):");
        String answer = in.nextLine();

        if (answer.equals("Y")) {
            System.out.println("Please enter the number of chips you would like:");
            defaultChip = in.nextInt();
            in.nextLine();
        } else {
            if (playerNum > 2) {
                defaultChip = 20;
            }
        }
        playerEntry[1] = defaultChip;
        return playerEntry;
    }

    /**
     *Creates an array to store all of the player objects that would be playing the game.
     *
     * @param playerEnt the integer array that contains the amount of players in a game and teh default chips
     * @return players an object array which stores multiple Player objects
     */
    public static Player[] createPlayers(int [] playerEnt){
        Player[] players = new Player[playerEnt[0]];
        for (int i = 0; i < playerEnt[0]; i += 1) {
            players[i] = new Player(playerEnt[1], coinToss(), i+1);
        }
        players[playerEnt[0]-1].setComputer(); // sets the last player to a computer
        return players;
    }

    /**
     *Converts the coin toss integer array to a string array for user ease of use.
     *
     * @param coinArray the integer that contains the coin toss values in a game
     * @return coinNames the string array which contains if the coin toss is heads or tails.
     */
    public static String[] coinNames(int[] coinArray){
        String[] coinNames = new String[coinArray.length];
        for(int x = 0; x<coinArray.length; x++){
            if(coinArray[x]==1){
                coinNames[x] = "Heads";
            }else{
                coinNames[x] = "Tails";
            }
        }
        return coinNames;
    }

    /**
     *Contains the coin portion of the game which randomly flips a coin for all players to see who is first.
     *
     * @param playerNum the integer that contains the amount of players in a game
     * @param players the Players object array which stores all the players
     * @return coinArray an array which contains the coin toss results for each player
     */
    public static int[] coinGame(int playerNum, Player[] players) {
        System.out.println("\nIn the coin toss will be represented in an array");
        int[] coinArray = new int[playerNum];
        for (int i = 0; i < playerNum; i += 1) {
            coinArray[i] = players[i].getCoin();
        }
        System.out.println("\n" + Arrays.toString(coinNames(coinArray)));
        int headCounter = 0;
        for (int i : coinArray) {
            if (i == 1) {
                headCounter += 1;
            }
        }

        // keeps going until only on heads remains
        while (headCounter != 1) {
            while (headCounter == 0) {
                for (int i = 0; i < playerNum; i += 1) {
                    coinArray[i] = coinToss();
                    if (coinArray[i] == 1) {
                        headCounter += 1;
                    }
                }
            }
            headCounter = 0;
            for (int i = 0; i < playerNum; i += 1) {
                if (coinArray[i] == 1) {
                    coinArray[i] = coinToss();
                }
                if (coinArray[i] == 1) {
                    headCounter += 1;
                }
            }
            System.out.println(Arrays.toString(coinNames(coinArray)));
        }
        return coinArray;
    }

    /**
     *Goes through the coinArray to find teh only player as heads and returns the index of this player
     *
     * @param playerNum the integer that contains the amount of players in a game
     * @param coinArray array which stores all the coin tosses
     * @return firstPlayer the index of the player with the only heads
     */
    public static int player1(int playerNum, int[] coinArray){
        int firstPlayer = 0;
        for (int i = 0; i < playerNum; i++) {
            if (coinArray[i] == 1) {
                firstPlayer = i;
            }
        }
        return firstPlayer;
    }

    /**
     *Swaps the first player found in the first player method and swaps them with current first player
     *
     * @param player1 the integer that contains the index of the first player
     * @param players the Players object array which stores all the players
     */
    public static void swap(int player1, Player[] players){
        if(players[player1].isComputer()){
            System.out.println("Computer player won the coin toss they will go first.\n"); // if the winning player is computer
        }else {
            System.out.println("Player " + (player1 + 1) + " won the coin toss they will go first.\n");
        }
        if (player1 == 0){
            System.out.println("The order will remain since Player 1 won the coin toss.");
        }else{
            System.out.println("Player " + (player1+1) + " will now swap places with Player 1 and become new Player 1.");
            Player temp;
            temp = players[0];
            players[0] = players[player1];
            players[player1] = temp;
        }
    }

    /**
     *Checks if the player would ike to conduct a re roll with the max re rolls being defined by the first player.
     * The computers answer will be randomly generated from compAnswer method
     *
     * @param diceRolls the entire dice rolls array which stores all players rolls
     * @param playerNum the integer that contains the amount of players in a game
     * @param players the Players object array which stores all the players
     * @param reRolls the integer which sets the max amount of re rolls
     * @param pointArr the array of all the points of the player
     * @param x the index of the player being asked for a re roll
     * @return newRolls an integer which returns teh amount of re rolls conducted by a user
     */
    public static int reRoll(int[][] diceRolls, int playerNum, Player[] players, int reRolls, int[] pointArr, int x){
        int totalPoint;
        String reRoll;
        int newReRolls = 0;

        // if the amount of re rolls is 0 defined by first player only 1 rolls executes
        if(reRolls==0){
            totalPoint = pointCal(diceRolls[x]);
            players[x].setDice(diceRolls[x]);
            players[x].setPoints(totalPoint);
            pointArr[x] = players[x].getPoints();

        }else {
            for (int i = 0; i < reRolls; i++) {
                System.out.println("Would you like to roll again? ('Y' or 'N'): ");

                // If the player choosing is the computer it informs the user of the computers decision.
                if(players[x].isComputer()){
                    reRoll = computerAnswer();
                    if (reRoll.equals("Y")){
                        System.out.println("The computer chose to re-roll.");
                    }else{
                        System.out.println("The computer chose not to re-roll.");
                    }
                    System.out.println();
                }else {
                    reRoll = in.nextLine();
                }

                // if a player chooses to re roll another dice roll occurs
                if (reRoll.equals("Y")) {
                    diceRolls[x] = turn1(playerNum, x);
                    totalPoint = pointCal(diceRolls[x]);
                    players[x].setDice(diceRolls[x]);
                    players[x].setPoints(totalPoint);
                    pointArr[x] = players[x].getPoints();
                    System.out.println();
                    newReRolls++;
                } else {
                    i=reRolls;
                    totalPoint = pointCal(diceRolls[x]);
                    players[x].setDice(diceRolls[x]);
                    players[x].setPoints(totalPoint);
                    pointArr[x] = players[x].getPoints();
                }
            }
        }
        return newReRolls;
    }

    /**
     *Contains the dice of the game which calculates points rolls dice and conducts teh randomized computer plays.
     *
     * @param playerNum the integer that contains the amount of players in a game
     * @param players the Players object array which stores all the players
     * @return pointArr the integer array which contains all the points of a player
     */
    public static int[] rollGame(int playerNum, Player[] players){
        int[] pointArr = new int[playerNum];
        int[][] diceRolls = new int[playerNum][3];
        int maxReRolls;
        // Player one sets the max re rolls for all other players
        System.out.println("Player 1 turn:" );
        diceRolls[0] = turn1(playerNum, 0);
        maxReRolls = reRoll(diceRolls, playerNum, players, 2, pointArr,0);
        // every other player can only re roll a maximum of player 1s re rolls
        for (int x = 1; x <playerNum; x++) {
            System.out.println("\nPlayer " + (x+1) + " turn:" );
            diceRolls[x] = turn1(playerNum, x);
            reRoll(diceRolls, playerNum, players, maxReRolls, pointArr, x);
        }
        return pointArr;
    }

    /**
     *Informs user of lowest and highest point players and distributes chips accordingly.
     *
     * @param pointArr the integer array storing all the points
     * @param playerNum the integer that contains the amount of players in a game
     * @param players the Players object array which stores all the players
     */
    public static void pointsGame(int[] pointArr, Player[] players, int playerNum){
        int lowPlayer = lowPoints(pointArr)[0];
        int highPlayer = mostPoints(pointArr)[0];
        int lowPoints = lowPoints(pointArr)[1];
        int highPoints = mostPoints(pointArr)[1];
        System.out.println("\nPlayer " + (highPlayer+1) + " has the most points: " + highPoints + " points.");
        System.out.println("Player " + (lowPlayer+1)  + " has the least points: " + lowPoints + " points.\n");
        int chipLoss = chipLoss(players[highPlayer].getDice());

        //delete this line after tests its just test
        System.out.println("Player " + (lowPlayer+1) + " will gain " + chipLoss + " chip(s) from each player, as they lost this round.");

        System.out.println("New Chip Totals: ");

        for (int x = 0; x < playerNum; x++) {
            if (x == lowPlayer) {
                players[x].setChips(players[x].getChips() + (chipLoss * (playerNum - 1)));
            } else {
                players[x].setChips(players[x].getChips() - chipLoss);
            }
            System.out.println("Player " + (x+1) + ": " + players[x].getChips());
        }
        System.out.println();
    }

    /**
     *Looks through the player object array to see if win conditions have been satisfied.
     *
     * @param playerNum the integer that contains the amount of players in a game
     * @param players the Players object array which stores all the players
     * @return boolean based on if a player has won or not
     */
    public static boolean checkWin(int playerNum, Player[] players){
        for(int x = 0; x<playerNum; x++){
            if(players[x].getChips() <= 0){
                System.out.println("\nCongratulations!!!! You win Player " + (x+1) +".");
                return true;
            }
        }
        return false;
    }

    /**
     *Asks the user if they would like to play again if t win condition has been satisfied, and if
     * not proceeds to the next round.
     *
     * @param playerNum the integer that contains the amount of players in a game
     * @param players the Players object array which stores all the players
     * @param playerEnt the array which contains default chips and the amount of players
     * @return playAgain string after asking player for a replay
     */
    public static String playAgain(int playerNum, Player[] players, int[] playerEnt){
        int i=1;
        while (!checkWin(playerNum, players)){
            System.out.println("\nRound " + i + " :\n");
            int[] pointArr = rollGame(playerEnt[0], players);
            pointsGame(pointArr, players, playerEnt[0]);
            i++;
        }
        System.out.println("\nWould you like to play again? (Enter 'Y' or 'N'): ");
        String playAgain = in.nextLine();
        System.out.println();
        return playAgain;
    }

    /**
     *Portion where all elements of the game is executed and the game keeps looping until a player no longer wishes for
     * a replay.
     *
     */
    public static void finalGame(){
        int [] playerEnt = playerEntry();
        Player[] players = createPlayers(playerEnt);

        int[] coinArray = coinGame(playerEnt[0], players);
        int firstPlayer = player1(playerEnt[0], coinArray);
        swap(firstPlayer, players);
        if (playAgain(playerEnt[0], players, playerEnt).equals("Y")){
            System.out.println("Starting Next Game:\n");
            finalGame();
        }else{
            System.out.println("Thanks for playing!!!");
        }
    }

    public static void main(String[] args) {
        finalGame(); // executes the final game method
        in.close(); //closes the scanner
    }
}