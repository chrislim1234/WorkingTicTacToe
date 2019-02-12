import java.util.*; 
import java.util.Scanner;
public class TicTacToe {

    static String b[] = new String[9]; //put outside main to be referenced
    
    public static void main(String[] args) {
        Test user= new Test();
        int Number;
        Scanner input = new Scanner(System.in);
        System.out.println("1 player or 2 Player (hehe only 2 player option available)"); 
        int playernumber = input.nextInt();
        System.out.println("Player 1 is X and player 2 is O");
        int random = (int )(Math.random() * 100 + 1);
        String playerone="";
        String playertwo="";

        if (random<50) {
            System.out.println("X goes first");
            String player1 = "X";
            String player2 = "O";
            playertwo= player2;
            playerone = player1;
        }
        else if (random>=50) {
            System.out.println("O goes first");
            String player1 = "O";
            String player2 = "X";
            playertwo= player2;
            playerone = player1;
        }

        for (int i=0; i<9; i++) {
            b[i]=Integer.toString(i); 
        }
            
        printGrid();
        if (playernumber==1) 
        {
            System.out.println("You are player" + playerone + "and the computer will be player" + playertwo);
             
            while (user.getStatus()==false) {
                turn1(playerone, playertwo, user);
            }
            findWinner(user);
         }
        if (playernumber==2) 
        {
            while (user.getStatus()==false) {
                turn(playerone, playertwo, user);
            }
            findWinner(user);
        }
  }
 

    public static void updateGrid(Test user) { //method is statis so i can use it in main
        for (int i=0; i<9; i++) {  //updates array b with user grid
            b[i]=user.Grid()[i];
        }
  }
  
  public static void findWinner(Test user) {
      System.out.println(user.winner());  //print user.winner(), which returns the winner
      System.out.println(user.getNum());
      System.out.println(user.getStatus());
    }

    public static void printGrid() { //method is static so i can use it in main
        System.out.println("+---+---+---+"); //prints board
        System.out.println("| " + b[0] + " | " + b[1] + " | " + b[2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + b[3] + " | " + b[4] + " | " + b[5] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + b[6] + " | " + b[7] + " | " + b[8] + " |");
        System.out.println("+---+---+---+");
  }
    
    public static void turn(String playerone,String playertwo, Test user) {
        Scanner input = new Scanner(System.in);
        for (int i=1; i<10; i++) {
                if (i%2==1) {
                System.out.println(playerone +  "Turn" + i + ": Type in gridnumber you would like to place ur mark.");
                int Number=input.nextInt();
                user.gridChange(playerone, Number);
                user.win();
                updateGrid(user); //update and printGrid called after every turn
                printGrid();
            }
            if (i%2==0) {
                System.out.println(playertwo +  "Turn" + i + ": Type in gridnumber you would like to place ur mark.");
                int Number=input.nextInt();
                user.gridChange(playertwo, Number);
                user.win();
                updateGrid(user); //update and printGrid called after every turn
                printGrid();
            }
        }
    }
    public static void turn1(String playerone, String playertwo, Test user) {
        int number1=0;
        Scanner input = new Scanner(System.in);
        for (int i=1; i<10; i++) {
                if (i%2==1) {
                System.out.println(playerone +  "Turn" + i + ": Type in gridnumber you would like to place ur mark.");
                int Number=input.nextInt();
                number1=Number;
                user.gridChange(playerone, Number);
                user.win();
                updateGrid(user); //update and printGrid called after every turn
                printGrid();
           }
            if (i%2==0) {
             int NUMber=(int )(Math.random() * 8 );
             boolean yeet = false;
             while (yeet=false) {
              int number = (int)(Math.random() * 8);
                if (Integer.valueOf(b[number])>8) {
                yeet=true;
                NUMber=number;
               }
            }
            System.out.println(playertwo +  "Turn" + i + ": Type in gridnumber you would like to place ur mark.");
            user.gridChange(playertwo,NUMber);
            user.win();
            updateGrid(user); //update and printGrid called after every turn
            printGrid();
           }
       }
    }
  }
