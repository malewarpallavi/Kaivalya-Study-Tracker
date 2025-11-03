/*
-------------------------------------------------------------------------------------------------------------------
    Project Title   : Kaivalya Study Tracker
    Author          : Pallavi Malewar
    Description     : A console-based Java application to track study logs with features to insert, 
                      view, summarize, and export study sessions.
    Language        : Java
    Created On      : November 2025
    Version         : 1.0
-------------------------------------------------------------------------------------------------------------------
*/


import java.util.*;
import java.io.*;
import java.time.LocalDate;

class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate A, String B, double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    @Override
    public String toString()
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description;
    }

    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescription()
    {
        return Description;
    }
}

class StudyTracker
{
    // Data Structure to hold the data about Study
    private ArrayList <StudyLog> Database = new ArrayList <StudyLog> ();

    public void InsertLog()
    {
        Scanner scannerObj = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------Please Enter Valid Details of Your Study----------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        LocalDate lobj = LocalDate.now();

        System.out.print("Please provide the name of Subject : ");
        String sub = scannerObj.nextLine();

        System.out.print("Enter the time period if your study (in hours) : ");
        double dur = scannerObj.nextDouble();
        scannerObj.nextLine();

        System.out.println("Please Provide the description about the study for future reference");
        String desc = scannerObj.nextLine();

        StudyLog SLObj = new StudyLog(lobj, sub, dur, desc);

        Database.add(SLObj);

        System.out.println("Study Log gets stored successfully");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void DisplayLog()
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        
        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
            return;
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------Log Report From Kaivalya Study Tracker----------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("------------------------------------------------Nothing to export as database is empty--------------------------------------------------------------");
            return;
        }

        String FileName = "KaivalyaStudy.csv";

        // Create new CSV File
        try(FileWriter fwobj = new FileWriter(FileName))
        {
            // Write CSV Name
            fwobj.write("Date, Subject, Duration, Description\n");

            for(StudyLog sobj : Database)
            {
                fwobj.write(sobj.getDate() + " , " +
                            sobj.getSubject().replace(" , ", " ") + " , " +
                            sobj.getDuration() + " , " + 
                            sobj.getDescription().replace(" , "," ") + "\n"
                            );
            }

            System.out.println("Log Created Successfully.");
        }
        catch(Exception eobj)
        {
            System.out.println("Exception occured while creating csv file");
            System.out.println("Report this issue to Kaivalya Infosystems");
        }
    }

    public void SummaryByDate()
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
            
            return;
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------Summary By Date from Kaivalya Study Tracker App-----------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        TreeMap <LocalDate, Double> tobj = new TreeMap <LocalDate, Double> ();

        LocalDate lobj = null;
        double d, old;
        
        for(StudyLog sobj : Database)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {  
                old = tobj.get(lobj);
                tobj.put(lobj , d + old);
            }
            else
            {
                tobj.put(lobj , d);
            }
        }

        for(LocalDate ldobj : tobj.keySet())
        {
            System.out.println("Date : "+ldobj+" Total Study "+tobj.get(ldobj));
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void SummaryBySubject()
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Nothing to display as database is empty");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

            return;
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------Summary By Subject From Kaivalya Study Tracker-------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        TreeMap <String, Double> tobj = new TreeMap <String, Double> ();

        double d, old;
        String s;

        for(StudyLog sobj : Database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s, d + old);
            }
            else
            {
                tobj.put(s , d);
            }
        }

        for(String str : tobj.keySet())
        {
            System.out.println("Subject : " + str + " | Total Study : " + tobj.get(str));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

    }
}

class Kaivalya_Study_Tracker
{
    public static void main(String A[])
    {
        StudyTracker stobj = new StudyTracker();
        Scanner sobj = new Scanner(System.in);

        int iChoice = 0;

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------Welcome to Marvellous Study Tracker Application-----------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

        do
        {
            System.out.println("Please Select the Appropriate Option : ");
            System.out.println("1. Insert new Study Log into Database");
            System.out.println("2. View All Study Logs");
            System.out.println("3. Summary of Study Log by Date");
            System.out.println("4. Summary of Study Log by Subject");
            System.out.println("5. Export Study Log to CSV File");
            System.out.println("6. Exit the Application");
        

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1: // Insert new study log into database
                    stobj.InsertLog();
                    break;

                case 2: // view all study logs
                    stobj.DisplayLog();
                    break;
                
                case 3: // summary of study log by date
                    stobj.SummaryByDate();
                    break;

                case 4: // summary of study log by subject
                    stobj.SummaryBySubject();
                    break;

                case 5: // export study log to csv file
                    stobj.ExportCSV();
                    break;

                case 6: // exit the application

                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("-------------------------------------------Thank You for using Kaivalya Study Log Application------------------------------------------------");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

                    break;

                default:
                    System.out.println("Please Enter Valid Option.");
            } 
        } while(iChoice != 6);
    }
}
