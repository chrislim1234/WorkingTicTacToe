public class Test
{
    boolean status1=false;
    String winner1="";
    int num1=0;
    String player1="";
    int gridNumber1;
    int[] A = new int[9];

    public Test() {

    }

    public void gridChange(String player, int gridNumber) {
        player1=player;
        gridNumber1=gridNumber;
        if (player1.equals("X")) {
            A[gridNumber1]=10;
        }
        if (player1.equals("O")) {
            A[gridNumber1]=100;    
        }
    }

    public void win() { //removed status variable, status1 variable is directly modified
        int num=0;      //no need to return anything, changed to void method
        for (int i=0; i<3; i++) {
            if (A[i]==A[i+3] && A[i+3]==A[i+6]) { //3 in a column
                status1=true;
                num=A[i]+A[i+3]+A[i+6];
            }
        }
        for (int i=0; i<9; i=i+3) {
            if (A[i]==A[i+1]&&A[i+1]==A[i+2]) { //3 in a row
                status1=true;
                num=A[i]+A[i+1]+A[i+2];
            }
        }
        if (A[0]==A[4]&&A[4]==A[8]) { //3 sideways
            status1=true;
            num=A[0]+A[4]+A[8];
        }
        if (A[6]==A[4]&&A[4]==A[2]) { //3 sideways
            status1=true;
            num=A[6]+A[4]+A[2];
        }
        num1=num;
    } 

    public String winner() {
        String winner="";
        if (num1==300) {
            winner = "O wins";
        }
        else if (num1==30) {
            winner = "X wins";
        }
        else {
            winner = "tie";
        }
        winner1 = winner; //dont need to store it, but you can if u wanna use it for smthng else
        return winner;

    }

    public boolean getStatus() {
        return status1;
    }

    public int getNum() {
        return num1;
    } 

    public String getWinner() {
        return winner1;
    } 

    public  String[] Grid() {
        String[] b = new String[9];
        int x = 0;                  
        //deleted a loop here that changed A array into all 0
        while (x < A.length) {
            if (A[x] == 10) {
                b[x] = "X";
            }
            else if (A[x] == 100) {
                b[x] = "O";
            }
            else if (A[x] == 0) {
                b[x]=Integer.toString(x);
            }
            x++;
        }
        return b;
    }   

}
