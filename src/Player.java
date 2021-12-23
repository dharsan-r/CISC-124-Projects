/**
 * Player; class which stores all the attributes of any given player
 *
 * @author Dharsan Ravindran
 * @since 2021-07-19
 * @version 1.0
 *          Student ID: 20219218
 *          instructor: Professor Paul Allison
 */
public class Player {
    private int chipNum;
    private int coin;
    private int points;
    private int[] dice = new int[3];
    private int playerName;
    private boolean computer = false;

    /**
     * Initializes a new player object nd sets a default chip for them
     *
     * @param chips the integer which contains the amount of chips a player will
     *              start with
     */
    public Player(int chips) {
        setChips(chips); // calls the setChips mutator
    }

    /**
     * Initializes a new player object nd sets a default chip, a coin face, and a
     * name
     *
     * @param chips the integer which contains the amount of chips a player will
     *              start with
     * @param face  the integer for the coin of the player starts with
     * @param name  the name of the player in numbers
     */
    public Player(int chips, int face, int name) {
        setChips(chips);
        setCoin(face);
        setName(name);
    }

    /**
     * Mutator that sets the computer boolean to true.
     *
     */
    public void setComputer() {
        computer = true;
    }

    /**
     * Accessor that sets returns the computer boolean.
     *
     * @return computer if the player is a computer.
     *
     */
    public boolean isComputer() {
        return computer;
    }

    /**
     * Mutator that sets the player name.
     *
     * @param num the Player number test
     */
    public void setName(int num) {
        playerName = num;
    }

    /**
     * Accessor that returns the player name.
     *
     * @return playerName integer with the player number
     *
     */
    public int getName() {
        return playerName;
    }

    /**
     * Mutator that sets the player points.
     *
     * @param point the integer for player points
     */
    public void setPoints(int point) {
        points = point;
    }

    /**
     * Accessor that returns the player points.
     *
     * @return points integer with the amount of points for a player.
     *
     */
    public int getPoints() {
        return points;
    }

    /**
     * Mutator that sets the player dice.
     *
     * @param roll integer array which sets a dice roll
     */
    public void setDice(int[] roll) {
        dice = roll;
    }

    /**
     * Accessor that returns the player dice.
     *
     * @return dice integer array with the dice the player rolled.
     *
     */
    public int[] getDice() {
        return dice;
    }

    /**
     * Mutator that sets the player coin.
     *
     * @param face the integer for teh coin face
     */
    public void setCoin(int face) {
        coin = face;
    }

    /**
     * Accessor that gets the coin toss.
     *
     * @return coin integer with the coin
     *
     */
    public int getCoin() {
        return coin;
    }

    /**
     * Mutator that sets the player chip.
     *
     * @param newNum the new number of chips
     */
    public void setChips(int newNum) {
        chipNum = newNum;
    }

    /**
     * Accessor that returns the player chips.
     *
     * @return chipNum integer with the amount of chips a player has
     *
     */
    public int getChips() {
        return chipNum;
    }

}
