/**
 * @author : Gihan Madhusankha
 * 2023-05-21 4:00 PM
 **/


import java.util.*;

class Example{
    // clear console after input the option
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }




    // subTitle[1]
    public static void sub1Title(){

        for(int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.printf("\n|%46s %33s","ADD NEW STUDENT","|\n");
        for(int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.println("\n");

    }


    // [1] Add New Student
    public static String[][] addNewStudent(String[][] stDetail){
        Scanner input = new Scanner(System.in);

        int count=0;

        sub1Title();


        for(int i=0; i<stDetail.length; i++){
            for(int j=0; j<2; j++){

                if(j==0){
                    L1:	while(true){
                        System.out.print("Enter Student ID   : ");
                        stDetail[i][j] = input.next();

                        // whether the first letter is 'S'
                        char first = stDetail[i][j].charAt(0);

                        if(first!='S'){
                            System.out.println("Invalid ID Type..!\n");
                            continue L1;
                        }

                        // split the student Id
                        String str = stDetail[i][0];
                        String[] arrOfStr = str.split("S");

                        String b = "";
                        for(String a : arrOfStr){
                            b=a;
                        }

                        // convvert String --> Integer
                        if(Integer.parseInt(b)<0){
                            System.out.println("Invalid Id Type..!\n");
                            continue L1;
                        }

                        // check duplicate student ID
                        for(int g=0; g<i; g++){
                            if(i>0 && stDetail[i][0].equals(stDetail[g][0])){
                                System.out.println("The student ID already exists\n");
                                continue L1;
                            }
                        }
                        break;
                    }

                }else{
                    count++;  // to increase the array length
                    System.out.print("Enter Student Name : ");
                    stDetail[i][j] = input.next();
                    break;
                }

            }
            //print after the student has added
            System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/n) > ");
            char ch = input.next().charAt(0);

            if(ch=='Y' || ch=='y'){
                clearConsole();

                // increase an array
                if(count==stDetail.length){
                    String[][] array = new String[stDetail.length+1][2];

                    for(int p=0; p<stDetail.length; p++){
                        for(int q=0; q<2; q++){
                            array[p][q] = stDetail[p][q];
                        }
                    }
                    stDetail = array; // array's array address is copied to stDeail

                }
                sub1Title();
                continue;

            }else if(ch=='N' || ch=='n'){
                clearConsole();
                return stDetail;

            }else{
                System.out.println("Invalid Input..!!");
            }

        }
        return stDetail;
    }



    //main method
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);


        int x = 1;

        String[][] stDetail1 = new String[x][2];
        A1:	while(true){

            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%59s %20s","WELCOME TO GDSE MARKS MANAGEMENT SYSTEM","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");

            System.out.print("[1] Add New Student\t\t\t");
            System.out.println("[2] Add New Student With Marks");
            System.out.print("[3] Add Marks\t\t\t\t");
            System.out.println("[4] Update Student Details");
            System.out.print("[5] Update Marks\t\t\t");
            System.out.println("[6] Delete Student");
            System.out.print("[7] Print Student Details\t\t");
            System.out.println("[8] Print Student Ranks");
            System.out.print("[9] Best In Programming Fundamentals\t");
            System.out.println("[10] Best In Database Managment System");


            //try{
            System.out.print("\nEnter an option to continue > ");
            int option = input.nextInt();

            switch(option){
                case 1:
                    clearConsole();
                    String[][] stDetail = addNewStudent(stDetail1);	// line --> 993
                    stDetail1 = stDetail;
                    continue A1;

                case 2:
                    clearConsole();
                    String[][] stDetail2 = addNewStudentWithMarks(stDetail1);	// line --> 844
                    stDetail1 = stDetail2;
                    continue A1;

                case 3:
                    clearConsole();
                    String[][] stDetail3 = addMarks(stDetail1);	// line --> 710
                    stDetail1 = stDetail3;
                    continue A1;

                case 4:
                    clearConsole();
                    String[][] stDetail4 = updateStudentDetails(stDetail1);	// line --> 646
                    stDetail1 = stDetail4;
                    continue A1;

                case 5:
                    clearConsole();
                    String[][] stDetail5 = updateMarks(stDetail1);	// line --> 541
                    stDetail1 = stDetail5;
                    continue A1;

                case 6:
                    clearConsole();
                    String[][] stDetail6 = deleteStudent(stDetail1);	// line --> 455
                    stDetail1 = stDetail6;
                    continue A1;

                case 7:
                    clearConsole();
                    String[][] stDetail7 = printStudentDetails(stDetail1);	// line --> 313
                    stDetail1 = stDetail7;
                    continue A1;

                case 8:
                    clearConsole();
                    printStudentsRanks(stDetail1);	// line --> 210
                    //	stDetail1 = stDetail8;
                    continue A1;

                case 9:
                    clearConsole();
                    bestInPrf(stDetail1);	// line --> 115
                    // stDetail1 = stDetail9;
                    continue A1;

                case 10:
                    clearConsole();
                    bestInDbms(stDetail1);	// line --> 20
                    //	stDetail1 = stDetail10;
                    continue A1;

                default:
                    System.out.println("[Invalid Input...!!]");

            }

            //	}catch (Exception e){
            System.out.println("[Invalid Input...!!..1]");

            //	}

            break;
        }



    }
}



