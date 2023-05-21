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





    // [3] Add Marks
    public static String[][] addMarks(String[][] stDetail1){
        Scanner input = new Scanner(System.in);


        L1: while(true){
            // print title of "add marks"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%43s %36s","ADD MARKS","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.print("Enter Student ID : ");
            String stID = input.next();

            while(true){
                for(int b=0; b<stDetail1.length; b++){

                    if(stID.equals(stDetail1[b][0])){

                        System.out.println("Student Name  	 : "+stDetail1[b][1]);

                        // if the third element is empty, enter the mark
                        if(stDetail1[b][2]==null){

                            while(true){
                                // input PRF marks
                                System.out.print("Programming Fundamentals Marks   : ");
                                stDetail1[b][2] = input.next();

                                // whether the marks are between 0 to 100
                                if(Integer.parseInt(stDetail1[b][2])<0 || Integer.parseInt(stDetail1[b][2])>100){
                                    System.out.println("Invalid marks, please enter correct marks.\n");
                                    continue;
                                }

                                break;
                            }

                            while(true){
                                // input DBMS marks
                                System.out.print("Database Management System Marks : ");
                                stDetail1[b][3] = input.next();

                                if(Integer.parseInt(stDetail1[b][3])<0 || Integer.parseInt(stDetail1[b][3])>100){
                                    System.out.println("Invalid marks, please enter correct marks.\n");
                                    continue;
                                }

                                break;
                            }

                            // add marks or not
                            System.out.print("Marks have been added. Do you want to add marks for another student? (Y/n) > ");
                            char ch = input.next().charAt(0);
                            System.out.println();

                            if(ch=='Y' || ch=='y'){
                                clearConsole();
                                continue L1;
                            }else if(ch=='N' || ch=='n'){
                                clearConsole();
                                return stDetail1;
                            }else{
                                System.out.println("Invalid Input..!!");
                            }


                        }else{
                            // if the third element isn't empty,
                            System.out.println("This student's marks have been already added.");
                            System.out.println("If you want to update the marks, please use [4] Update Marks Option.");
                            System.out.print("\nDo you want to add marks for another student? (Y/n) > ");

                            char ab = input.next().charAt(0);
                            System.out.println();

                            if(ab=='Y' || ab=='y'){
                                clearConsole();
                                continue L1;
                            }else if(ab=='N' || ab=='n'){
                                clearConsole();
                                return stDetail1;
                            }else{
                                System.out.println("Invalid Input..!!");
                            }

                        }

                    }

                }
                // If the enter an incorrect Student ID number
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) > ");

                char c = input.next().charAt(0);
                System.out.println();

                if(c=='Y' || c=='y'){
                    clearConsole();
                    continue L1;
                }else if(c=='N' || c=='n'){
                    clearConsole();
                    return stDetail1;
                }else{
                    System.out.println("Invalid Input..!!");
                }

            }
        }

    }


    // subTitle[2]
    public static void sub2Title(){
        // print title of "Add new student with marks"
        for(int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.printf("\n|%52s %27s","ADD NEW STUDENT WITH MARKS","|\n");
        for(int i=0; i<80; i++){
            System.out.print("-");
        }
        System.out.println("\n");

    }


    //  [2] Add New Student With Marks
    public static String[][] addNewStudentWithMarks(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        int count = stDetail1.length; //1

        sub2Title();

        // I created the new array and added the values of the old array to the new array.
        String[][] stDetail = new String[stDetail1.length+1][4];
        for(int i=0; i<stDetail1.length; i++){
            for(int j=0; j<2; j++){
                stDetail[i][j] = stDetail1[i][j];
            }
        }


        for(int i = stDetail1.length; i<stDetail.length; i++){
            for(int j=0; j<4; j++){

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
                            if(stDetail[i][0].equals(stDetail[g][0])){
                                System.out.println("The student ID already exists\n");
                                continue L1;
                            }
                        }
                        break;
                    }

                }else if(j==1){
                    count++;  // to increase the array length
                    System.out.print("Enter Student Name : ");
                    stDetail[i][j] = input.next();

                }else if(j==2){
                    while(true){
                        // input PRF marks
                        System.out.print("Programming Fundamentals Marks   : ");
                        stDetail[i][j] = input.next();

                        if(Integer.parseInt(stDetail[i][j])<0 || Integer.parseInt(stDetail[i][j])>100){
                            System.out.println("Invalid marks, please enter correct marks.\n");
                            continue;
                        }

                        break;
                    }

                }else{
                    while(true){
                        // input DBMS marks
                        System.out.print("Database Management System Marks : ");
                        stDetail[i][j] = input.next();

                        if(Integer.parseInt(stDetail[i][j])<0 || Integer.parseInt(stDetail[i][j])>100){
                            System.out.println("Invalid marks, please enter correct marks.\n");
                            continue;
                        }

                        break;
                    }

                }

            }

            //print after the student has added
            System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/n) > ");
            char ch = input.next().charAt(0);

            if(ch=='Y' || ch=='y'){
                clearConsole();

                // increase an array
                if(count==stDetail.length){
                    String[][] array = new String[stDetail.length+1][4];

                    for(int p=0; p<stDetail.length; p++){
                        for(int q=0; q<4; q++){
                            array[p][q] = stDetail[p][q];
                        }
                    }
                    stDetail = array; // array's array address is copied to stDeail

                }
                sub2Title();
                continue;

            }else if(ch=='N' || ch=='n'){
                clearConsole();
                return stDetail;
                //printSubTitles();
                //break;

            }else{
                System.out.println("Invalid Input..!!");
            }

        }
        return stDetail;

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



