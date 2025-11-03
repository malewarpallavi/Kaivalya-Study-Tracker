📚 Kaivalya Study Tracker

A Java console-based Study Tracker that helps you log and analyze your daily study sessions.
It allows you to record subjects, durations, and descriptions, and then view summaries or export data to a CSV file.

🧭 Project Overview

Kaivalya Study Tracker is a console-based Java application designed to help students log, track, summarize, and export their study activities.

It supports viewing total study time grouped by date or subject, and exporting all data into a CSV file for offline tracking.

This project demonstrates practical use of Java Collections, File I/O, and Object-Oriented Design.

✨ Key Features

Insert Study Log — Record study sessions with date (auto-generated), subject, duration, and description.

Display Logs — View all stored study logs.

Summary by Date — Total study hours grouped by date.

Summary by Subject — Total study hours grouped by subject.

Export to CSV — Save study logs in KaivalyaStudy.csv for offline access.

User-Friendly Menu — Console-based menu with clear options and navigation.

🛠️ Technologies Used

Language: Java
Packages & APIs:

java.util.* — Collections like ArrayList, TreeMap, user input via Scanner.

java.time.LocalDate — Auto-captures the current date.

java.io.* — File handling and CSV export.

🔄 Project Flow

Launch the app → Main Menu displayed

Choice 1: Insert new study log (auto-generated date)

Choice 2: Display all study logs

Choice 3: Display summary by date

Choice 4: Display summary by subject

Choice 5: Export logs to KaivalyaStudy.csv

Choice 6: Exit

🧩 Classes & Responsibilities
StudyLog

Represents a single study session.
Attributes:

LocalDate date

String subject

double duration

String description

Methods: Constructor, getters, toString()

StudyTracker

Manages all logs in memory.
Attributes:

ArrayList<StudyLog> database

Methods:
InsertLog(), DisplayLog(), SummaryByDate(), SummaryBySubject(), ExportCSV()

StudyTrackerApp

Main class that handles user input and menu navigation.

💻 Example Console Flow
====== Kaivalya Study Tracker ======
1. Insert Study Log
2. Display All Logs
3. Summary By Date
4. Summary By Subject
5. Export to CSV
6. Exit
Enter choice: 1

Enter Subject: Java Programming
Enter Duration (hrs): 2.5
Enter Description: Practiced ArrayList and TreeMap
Study log added successfully for date: 2025-09-13

Sample Exported CSV (KaivalyaStudy.csv):
Date,Subject,Duration,Description
2025-09-13,Java Programming,2.5,Practiced ArrayList and TreeMap
2025-09-13,Database,1.5,Revised SQL Joins
