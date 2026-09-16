import java.util.Scanner;
import java.util.Random;

class RockPaperScissorsGame
{

    static String moveName(int move)
    {
        switch(move)
        {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Unknown";
        }
    }

    static boolean playerWins(int playerMove, int computer)
    {
        return (playerMove == 1 && computer == 3) ||
                (playerMove == 2 && computer == 1) ||
                (playerMove == 3 && computer == 2);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How many rounds of Rock, Paper, Scissors do you want to play? ");
        int rounds = sc.nextInt();
        int playerScore = 0;
        int computerScore = 0;

        if(rounds <= 0)
        {
            System.out.println("Invalid rounds!");
            System.exit(0);
        }

        for (int i = 1; i <= rounds; i++)
        {
            System.out.print("Enter Rock (1), Paper (2), or Scissors (3): ");
            int user = sc.nextInt();

            if (user < 1 || user > 3)
            {
                System.out.println("Invalid input!");
                i--;
            }
            
            int computer = 1 + random.nextInt(3);

            System.out.println("You chose: " + moveName(user) + ", Computer chose: " + moveName(computer));

            if (playerWins(user, computer))
            {
                System.out.println("You won!");
                playerScore++;
            }
            else if (playerWins(computer, user))
            {
                System.out.println("Computer won!");
                computerScore++;
            }
            else
            {
                System.out.println("Draw!");
            }
        }

        System.out.println("Game Over!");
        System.out.println("Score - " + "You: " + playerScore + ", Computer: " + computerScore);

        if(playerScore > computerScore)
        {
            System.out.println("Congratulations you win!");
        }
        else if(playerScore < computerScore)
        {
            System.out.println("The computer wins!");
        }
        else
        {
            System.out.println("Tie!");
        }
        sc.close();
    }
}