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

    // [10] best in database management system
    public static String[][] bestInDbms(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        while(true){
            // print the title of " best in database management system"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%56s %23s","BEST IN DATABASE MANAGEMENT SYSTEM","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.println("+-------+-----------------------+----------+---------+");
            System.out.println("|ID	|Name			|DBMS Marks|PRF Marks|");
            System.out.println("+-------+-----------------------+----------+---------+");

            int count = 0;
            int count1 = 0;
            int count2 = 0;

            int[] ar = new int[stDetail1.length];

            // to know the no of students who didn't enter marks for the subjects
            for(int i=0; i<stDetail1.length; i++){
                if(stDetail1[i][0]!=(null) && stDetail1[i][2]==null){
                    count++;
                    ar[i] = 0;
                }else{
                    ar[i] = 1;
                    count2++;
                }

                // delete student count
                if(stDetail1[i][0]==null){
                    count1++;
                    ar[i] = 2;
                }
            }


            //~ //  create an array to store prf marks of all students
            int[] dbms = new int[stDetail1.length];
            int[] dbms1 = new int[stDetail1.length];


            // store the dbms marks of all students
            for(int i=0; i<stDetail1.length; i++){
                if(ar[i]==1){
                    dbms[i] = Integer.parseInt(stDetail1[i][3]);
                }
            }

            // copy all the values of the old array to the new array
            for(int i=0; i<stDetail1.length; i++){
                dbms1[i] = dbms[i];
            }

            // sort an array asc.
            for(int i=0; i<stDetail1.length; i++){
                for(int j=0; j<dbms.length-1; j++){
                    if(dbms[j] > dbms[j+1]){
                        int temp = dbms[j];
                        dbms[j] = dbms[j+1];
                        dbms[j+1] = temp;
                    }
                }
            }

            for(int i=dbms.length-1; i>=(count1+count); i--){
                for(int j=0; j<dbms1.length; j++){
                    if(dbms[i]==dbms1[j]){

                        System.out.print("|"+stDetail1[j][0]+"	");
                        System.out.print("|"+stDetail1[j][1]+"			");
                        System.out.printf("|%10s",stDetail1[j][3]);
                        System.out.printf("|%9s%s%n",stDetail1[j][2],"|");
                        dbms1[j] = 0; // to prevent duplication of values
                        break;

                    }
                }
            }

            System.out.println("+-------+-----------------------+----------+---------+");

            System.out.print("\nDo you want to go back to main menu? (Y/n) > ");
            char ch = input.next().charAt(0);

            if(ch=='Y' || ch=='y'){
                clearConsole();
                return stDetail1;
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                continue;
            }else{
                System.out.println("Invalid Input..!!");
            }

        }

    }


    // [9] best in programming fundamentals
    public static String[][] bestInPrf(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        while(true){
            // print the title of "best in programming fundamentals"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%55s %24s","BEST IN PROGRAMMING FUNDAMENTALS","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.println("+-------+-----------------------+---------+----------+");
            System.out.println("|ID	|Name			|PRF Marks|DBMS Marks|");
            System.out.println("+-------+-----------------------+---------+----------+");

            int count = 0;
            int count1 = 0;
            int count2 = 0;

            int[] ar = new int[stDetail1.length];

            // to know the no of students who didn't enter marks for the subjects
            for(int i=0; i<stDetail1.length; i++){
                if(stDetail1[i][0]!=(null) && stDetail1[i][2]==null){
                    count++;
                    ar[i] = 0;
                }else{
                    ar[i] = 1;
                    count2++;
                }

                // delete student count
                if(stDetail1[i][0]==null){
                    count1++;
                    ar[i] = 2;
                }
            }


            //~ //  create an array to store prf marks of all students
            int[] prf = new int[stDetail1.length];
            int[] prf1 = new int[stDetail1.length];


            // store the prf marks of all students
            for(int i=0; i<stDetail1.length; i++){
                if(ar[i]==1){
                    prf[i] = Integer.parseInt(stDetail1[i][2]);
                }
            }

            // copy all the values of the old array to the new array
            for(int i=0; i<stDetail1.length; i++){
                prf1[i] = prf[i];
            }

            // sort an array asc.
            for(int i=0; i<stDetail1.length; i++){
                for(int j=0; j<prf.length-1; j++){
                    if(prf[j] > prf[j+1]){
                        int temp = prf[j];
                        prf[j] = prf[j+1];
                        prf[j+1] = temp;
                    }
                }
            }


            for(int i=prf.length-1; i>=(count1+count); i--){
                for(int j=0; j<prf1.length; j++){
                    if(prf[i]==prf1[j]){

                        System.out.print("|"+stDetail1[j][0]+"	");
                        System.out.print("|"+stDetail1[j][1]+"			");
                        System.out.printf("|%9s",stDetail1[j][2]);
                        System.out.printf("|%10s%s%n",stDetail1[j][3],"|");
                        prf1[j] = 0; // to prevent duplication of values
                        break;
                    }
                }
            }

            System.out.println("+-------+-----------------------+---------+----------+");

            System.out.print("\nDo you want to go back to main menu? (Y/n) > ");
            char ch = input.next().charAt(0);

            if(ch=='Y' || ch=='y'){
                clearConsole();
                return stDetail1;
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                continue;
            }else{
                System.out.println("Invalid Input..!!");
            }

        }

    }


    // [8] print students ranks
    public static void printStudentsRanks(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        while(true){

            // print the title of "print students ranks"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%49s %30s","PRINT STUDENT'S RANKS","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.println("+-------+-------+-----------------------+-----------+----------+");
            System.out.println("|Rank	|ID	|Name			|Total Marks|Avg. Marks|");
            System.out.println("+-------+-------+-----------------------+-----------+----------+");

            int count = 0;
            int count1 = 0;
            int count2 = 0;

            int[] ar = new int[stDetail1.length];
            // to know the no of students who didn't enter marks for the subjects
            for(int i=0; i<stDetail1.length; i++){
                if(stDetail1[i][0]!=(null) && stDetail1[i][2]==null){
                    count++;
                    ar[i] = 0;
                }else{
                    ar[i] = 1;
                    count2++;
                }

                // delete student count
                if(stDetail1[i][0]==null){
                    count1++;
                    ar[i] = 2;
                }
            }
            //System.out.println(Arrays.toString(ar));

            double[] avgOfStudents = new double[stDetail1.length];
            double[] avgOfStudents1 = new double[stDetail1.length];

            // store the average marks of all students
            for(int i=0; i<stDetail1.length; i++){
                if(ar[i]==1){
                    avgOfStudents[i] = ((Integer.parseInt(stDetail1[i][2])+Integer.parseInt(stDetail1[i][3])) / 2.0);
                }
            }
            //System.out.print(Arrays.toString(avgOfStudents));

            // copy all the values of the old array to the new array
            for(int i=0; i<stDetail1.length; i++){
                avgOfStudents1[i] = avgOfStudents[i];
            }

            // sort an array asc.
            for(int i=0; i<stDetail1.length; i++){
                for(int j=0; j<avgOfStudents.length-1; j++){
                    if(avgOfStudents[j] > avgOfStudents[j+1]){
                        double temp = avgOfStudents[j];
                        avgOfStudents[j] = avgOfStudents[j+1];
                        avgOfStudents[j+1] = temp;
                    }
                }
            }

            //~ //Arrays.sort(avgOfStudents);
            //~ System.out.println(Arrays.toString(avgOfStudents1));
            //~ System.out.println(Arrays.toString(avgOfStudents)); // sort one

            int rank = 1;
            for(int i=avgOfStudents.length-1; i>=(count1+count); i--){
                for(int j=0; j<avgOfStudents1.length; j++){
                    if(avgOfStudents[i]==avgOfStudents1[j]){

                        System.out.print("|"+rank+"	");
                        rank++;
                        System.out.print("|"+stDetail1[j][0]+"	");
                        System.out.print("|"+stDetail1[j][1]+"			");

                        int tot = (Integer.parseInt(stDetail1[j][2])+Integer.parseInt(stDetail1[j][3]));
                        System.out.printf("|%11d%s",tot,"|");

                        double avg = tot / 2.0;
                        System.out.printf("%10.2f%s%n",avg,"|");
                        avgOfStudents1[j] = 0; // to prevent duplication of values
                        break;
                    }
                }
            }

            System.out.println("+-------+-------+-----------------------+-----------+----------+");

            System.out.print("\nDo you want to go back to main menu? (Y/n) > ");
            char ch = input.next().charAt(0);

            if(ch=='Y' || ch=='y'){
                clearConsole();
                break;
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                continue;
            }else{
                System.out.println("Invalid Input..!!");
            }

        }
    }


    // [7] print student details
    public static String[][] printStudentDetails(String[][] stDetail1){
        Scanner input = new Scanner(System.in);


        L1:	while(true){
            // print the title of "print student details"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%49s %30s","PRINT STUDENT DETAILS","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.print("Enter student ID : ");
            String stID = input.next();


            for(int i=0; i<stDetail1.length; i++){
                //checking whether the student id is available or not
                if(stID.equals(stDetail1[i][0])){

                    if(stDetail1[i][2]==null){
                        System.out.println("Student Name     : "+stDetail1[i][1]);
                        System.out.println("\nMarks yet to be added.");

                        System.out.print("\nDo you want to search another student details? (Y/n) > ");
                        char ch = input.next().charAt(0);

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
                        System.out.println("Student Name     : "+stDetail1[i][1]);
                        System.out.printf("+----------------------------------+----------------+%n");
                        System.out.printf("|Programming Fundamentals Marks	   | %15d%s %n",Integer.parseInt(stDetail1[i][2]),"|");
                        System.out.printf("|Database Management System Marks  | %15d%s %n",Integer.parseInt(stDetail1[i][3]),"|");

                        int tot = Integer.parseInt(stDetail1[i][2])+Integer.parseInt(stDetail1[i][3]);
                        System.out.printf("|Total Mark		 	   | %15d%s %n",tot,"|");

                        double avg = tot/2.0;
                        System.out.printf("|Avg. Marks			   | %15.2f%s %n",avg,"|");

                        int count = 0; // declare the "count" variable to print the word "last"

                        //  create an array to store average marks of all students
                        double[] avgOfStudents = new double[stDetail1.length];

                        for(int g=0; g<stDetail1.length; g++){
                            if(stDetail1[g][2]!=null){
                                count++;
                                avgOfStudents[g] = ((Integer.parseInt(stDetail1[g][2])+Integer.parseInt(stDetail1[g][3])) / 2.0);
                            }
                        }

                        // sorting of an array descending order
                        for(int a=0; a<avgOfStudents.length; a++){
                            for(int j=0; j<avgOfStudents.length-1; j++){
                                if(avgOfStudents[j] < avgOfStudents[j+1]){
                                    double temp = avgOfStudents[j];
                                    avgOfStudents[j] = avgOfStudents[j+1];
                                    avgOfStudents[j+1] = temp;
                                }
                            }
                        }

                        // find the rank
                        int rank = 1;
                        for(int a=0; a<avgOfStudents.length; a++){
                            if(avg==avgOfStudents[a]){
                                rank = a+1;
                            }
                        }

                        String position = "";
                        if(rank==1){
                            position = "(first)";
                            System.out.printf("|Rank				   | %7d %s%s%n",rank,position,"|");
                        }else if(rank==2){
                            position = "(second)";
                            System.out.printf("|Rank				   | %7d%s%s%n",rank,position,"|");
                        }else if(rank==3){
                            position = "(third)";
                            System.out.printf("|Rank				   | %7d %s%s%n",rank,position,"|");
                        }else if(rank==count){
                            position = "(last)";
                            System.out.printf("|Rank				   | %8d %s%s%n",rank,position,"|");
                        }else{
                            System.out.printf("|Rank				   | %15d%s%s%n",rank,position,"|");
                        }


                        System.out.printf("+----------------------------------+----------------+%n");

                        System.out.print("\nDo you want to search another student details? (Y/n) > ");
                        char ch = input.next().charAt(0);

                        if(ch=='Y' || ch=='y'){
                            clearConsole();
                            continue L1;
                        }else if(ch=='N' || ch=='n'){
                            clearConsole();
                            return stDetail1;
                        }else{
                            System.out.println("Invalid Input..!!");
                        }

                    }

                }

            }
            // If the enter an incorrect Student ID number
            System.out.print("Invalid Studunt ID. Do you want to search again? (Y/n) > ");
            char c = input.next().charAt(0);

            if(c=='Y' || c=='y'){
                clearConsole();
                continue;
            }else if(c=='N' || c=='n'){
                clearConsole();
                return stDetail1;
            }else{
                System.out.println("Invalid Input..!!");
            }

        }

    }



    // [6] Delete Student
    public static String[][] deleteStudent(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        int y = 0;
        String[][] del = new String[stDetail1.length][4];

        L1:	while(true){
            // print title of "delete student"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%46s %33s","DELETE STUDENT","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.print("Enter student ID : ");
            String stID = input.next();

            for(int i=0; i<stDetail1.length; i++){
                if(stID.equals(stDetail1[i][0])){	//checking whether the student id is available or not

                    // pass the id you want to delete to the last element
                    for(int a=i; a<stDetail1.length-1; a++){
                        for(int b=0; b<4; b++){
                            String temp = stDetail1[a][b];
                            stDetail1[a][b] = stDetail1[a+1][b];
                            stDetail1[a+1][b] = temp;
                        }
                    }

                    System.out.println("Student has been deleted successfully.");
                    System.out.print("Do you want to delete another student? (Y/n) > ");
                    char dl = input.next().charAt(0);

                    if(dl=='Y' || dl=='y'){
                        clearConsole();
                        y++;
                        continue L1;

                    }else if(dl=='N' || dl=='n'){
                        clearConsole();
                        for(int p=0; p<stDetail1.length-(y+1); p++){
                            for(int q=0; q<4; q++){
                                del[p][q] = stDetail1[p][q];	// assign values to the new array
                            }
                        }
                        stDetail1 = del;	// assign the array address of del into the stDetail array
                        return stDetail1;

                    }else{
                        System.out.println("Invalid Input..!!");
                    }

                }

            }
            // If the enter an incorrect Student ID number
            System.out.print("Invalid Studunt ID. Do you want to search again? (Y/n) > ");
            char ch = input.next().charAt(0);

            if(ch=='Y' || ch=='y'){
                clearConsole();
                continue;
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                for(int p=0; p<stDetail1.length-y; p++){
                    for(int q=0; q<4; q++){
                        del[p][q] = stDetail1[p][q];
                    }
                }
                stDetail1 = del;
                return stDetail1;

            }else{
                System.out.println("Invalid Input..!!");
            }

        }
    }



    // [5] Update Marks
    public static String[][] updateMarks(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        L1:	while(true){

            // print title of "update marks"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%45s %34s","UPDATE MARKS","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");

            System.out.print("Enter Student ID : ");
            String stID = input.next();

            while(true){
                for(int j=0; j<stDetail1.length; j++){

                    if(stID.equals(stDetail1[j][0])){   // the entered ID is also checked as valid
                        System.out.println("Student Name     : "+stDetail1[j][1]);

                        if(stDetail1[j][2]==null){
                            System.out.println("\nThis student's marks yet to be added.");
                            System.out.print("Do you want to update the marks of another student? (Y/n) > ");

                            char A = input.next().charAt(0);
                            if(A=='Y' || A=='y'){
                                clearConsole();
                                continue L1;
                            }else if(A=='N' || A=='n'){
                                clearConsole();
                                return stDetail1;
                            }else{
                                System.out.println("Invalid Input..!!");
                            }

                        }else{

                            System.out.println("Programming Fundamentals Marks    : "+stDetail1[j][2]);
                            System.out.println("Database Management System Marks  : "+stDetail1[j][3]);

                            while(true){  // updata prf marks
                                System.out.print("\nEnter new Programming Fundamentals Marks   : ");
                                stDetail1[j][2] = input.next();
                                if(Integer.parseInt(stDetail1[j][2])<0 || Integer.parseInt(stDetail1[j][2])>100){
                                    System.out.println("Invalid marks, please enter correct marks.\n");
                                    continue;
                                }
                                break;
                            }

                            while(true){  // update dbms marks
                                System.out.print("Enter new Database Management System Marks : ");
                                stDetail1[j][3] = input.next();
                                if(Integer.parseInt(stDetail1[j][3])<0 || Integer.parseInt(stDetail1[j][3])>100){
                                    System.out.println("Invalid marks, please enter correct marks.\n");
                                    continue;
                                }
                                break;
                            }

                            System.out.println("Marks have been updated successfully.");
                            System.out.print("Do you want to update marks for another student? (Y/n) > ");

                            char b = input.next().charAt(0);
                            if(b=='Y' || b=='y'){
                                clearConsole();
                                continue L1;
                            }else if(b=='N' || b=='n'){
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
                char ch = input.next().charAt(0);

                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    continue L1;
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    break L1;
                }else{
                    System.out.println("Invalid Input..!!");
                }
            }
        }
        return stDetail1;

    }



    // [4] Update Student Details
    public static String[][] updateStudentDetails(String[][] stDetail1){
        Scanner input = new Scanner(System.in);

        L1:	while(true){

            // print title of "update student detail"
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.printf("\n|%50s %29s","UPDATE STUDENT DETAILS","|\n");
            for(int i=0; i<80; i++){
                System.out.print("-");
            }
            System.out.println("\n");


            System.out.print("Enter Student ID : ");
            String stID = input.next();

            while(true){
                for(int j=0; j<stDetail1.length; j++){

                    if(stID.equals(stDetail1[j][0])){
                        System.out.println("Student Name     : "+stDetail1[j][1]);

                        System.out.print("\nEnter the new student name : ");
                        stDetail1[j][1] = input.next();

                        System.out.println("\nStudent detail has been updated successfully.");
                        System.out.print("Do you want to update another student details? (Y/n) > ");

                        char A = input.next().charAt(0);
                        if(A=='Y' || A=='y'){
                            clearConsole();
                            continue L1;
                        }else if(A=='N' || A=='n'){
                            clearConsole();
                            return stDetail1;
                        }else{
                            System.out.println("Invalid Input..!!");
                        }
                    }
                }
                // If the enter an incorrect Student ID number
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) > ");
                char ch = input.next().charAt(0);

                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    continue L1;
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    return stDetail1;
                }else{
                    System.out.println("Invalid Input..!!");
                }
            }
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



