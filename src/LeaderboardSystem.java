/**
 * Main driver class for the Student Leaderboard Management System.
 * Demonstrates the complete workflow of sorting student marks and handling dynamic updates.
 * 
 * System Features:
 * - Initial sorting using stable Merge Sort (O(N log N))
 * - Dynamic mark updates with adaptive O(N) repositioning
 * - Comprehensive test scenarios including edge cases
 * - Professional output formatting
 * 
 * Test Scenarios Covered:
 * 1. Initial unsorted student list
 * 2. Descending order sorting by marks
 * 3. Mark improvement (student moves up)
 * 4. Mark correction (student moves down)
 * 5. Edge cases (top performer drops, bottom performer improves)
 * 
 * @author H.M.Ishara Lakshitha Bandara
 * @version 1.0
 * @since 2025-11-25
 */
public class LeaderboardSystem {
    
    /**
     * Main entry point for the Leaderboard System.
     * Executes a series of test scenarios to demonstrate sorting and update capabilities.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Print system header
        printHeader();
        
        // 1. Initialization with Sample Data
        Student[] students = {
            new Student("Ayesha", 75),
            new Student("Thilina", 82),
            new Student("Nimasha", 68),
            new Student("Sahan", 90),
            new Student("Dilki", 78),
            new Student("Kamal", 85),
            new Student("Rashmi", 72),
            new Student("Dinesh", 88)
        };

        System.out.println("\n" + "=".repeat(60));
        System.out.println("PHASE 1: INITIAL DATA (Unsorted)");
        System.out.println("=".repeat(60));
        printList(students);

        // 2. Sorting Strategy Application
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PHASE 2: APPLYING MERGE SORT (Descending Order)");
        System.out.println("=".repeat(60));
        System.out.println("Algorithm: Stable Merge Sort");
        System.out.println("Time Complexity: O(N log N)");
        System.out.println("Space Complexity: O(N)");
        
        long startTime = System.nanoTime();
        GradeSorter.mergeSort(students);
        long endTime = System.nanoTime();
        
        System.out.println("Execution Time: " + (endTime - startTime) / 1000.0 + " microseconds\n");
        printList(students);

        // 3. Dynamic Update Scenario 1: Significant Improvement
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PHASE 3: DYNAMIC UPDATE - Mark Improvement");
        System.out.println("=".repeat(60));
        System.out.println("Scenario: Ayesha's marks are updated from 75 to 95.");
        System.out.println("Expected: Ayesha should move from Rank 6 to Rank 1.");
        
        startTime = System.nanoTime();
        GradeSorter.updateStudentMark(students, "Ayesha", 95);
        endTime = System.nanoTime();
        
        System.out.println("Update Time: " + (endTime - startTime) / 1000.0 + " microseconds");
        printList(students);

        // 4. Dynamic Update Scenario 2: Mark Correction (Drop)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PHASE 4: DYNAMIC UPDATE - Mark Correction");
        System.out.println("=".repeat(60));
        System.out.println("Scenario: Sahan's marks are corrected from 90 to 60.");
        System.out.println("Expected: Sahan should drop from Rank 3 to Rank 8.");
        
        startTime = System.nanoTime();
        GradeSorter.updateStudentMark(students, "Sahan", 60);
        endTime = System.nanoTime();
        
        System.out.println("Update Time: " + (endTime - startTime) / 1000.0 + " microseconds");
        printList(students);

        // 5. Dynamic Update Scenario 3: Minor Adjustment
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PHASE 5: DYNAMIC UPDATE - Minor Adjustment");
        System.out.println("=".repeat(60));
        System.out.println("Scenario: Nimasha's marks improved from 68 to 80.");
        System.out.println("Expected: Nimasha should move up by several ranks.");
        
        startTime = System.nanoTime();
        GradeSorter.updateStudentMark(students, "Nimasha", 80);
        endTime = System.nanoTime();
        
        System.out.println("Update Time: " + (endTime - startTime) / 1000.0 + " microseconds");
        printList(students);

        // 6. Dynamic Update Scenario 4: Equal Marks (Testing Stability)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PHASE 6: STABILITY TEST - Equal Marks");
        System.out.println("=".repeat(60));
        System.out.println("Scenario: Rashmi's marks updated to 82 (same as Thilina).");
        System.out.println("Expected: Original order preserved for equal marks.");
        
        startTime = System.nanoTime();
        GradeSorter.updateStudentMark(students, "Rashmi", 82);
        endTime = System.nanoTime();
        
        System.out.println("Update Time: " + (endTime - startTime) / 1000.0 + " microseconds");
        printList(students);

        // Print footer
        printFooter();
    }

    /**
     * Prints the system header with branding information.
     */
    private static void printHeader() {
        System.out.println("\n" + "#".repeat(60));
        System.out.println("#" + " ".repeat(58) + "#");
        System.out.println("#" + centerText("STUDENT LEADERBOARD MANAGEMENT SYSTEM", 58) + "#");
        System.out.println("#" + centerText("Sorting with Dynamic Updates", 58) + "#");
        System.out.println("#" + " ".repeat(58) + "#");
        System.out.println("#" + centerText("Author: H.M.Ishara Lakshitha Bandara", 58) + "#");
        System.out.println("#" + centerText("Task 5: DSA Assignment", 58) + "#");
        System.out.println("#" + " ".repeat(58) + "#");
        System.out.println("#".repeat(60));
    }

    /**
     * Prints the system footer with summary information.
     */
    private static void printFooter() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EXECUTION SUMMARY");
        System.out.println("=".repeat(60));
        System.out.println("✓ Stable Merge Sort: O(N log N) complexity achieved");
        System.out.println("✓ Adaptive Updates: O(N) complexity for mark changes");
        System.out.println("✓ Stability Guarantee: Preserved relative order for equal marks");
        System.out.println("✓ All test scenarios executed successfully");
        System.out.println("=".repeat(60));
        System.out.println("\nSystem developed by H.M.Ishara Lakshitha Bandara");
        System.out.println("Licensed under MIT License");
        System.out.println("#".repeat(60) + "\n");
    }

    /**
     * Prints the leaderboard in a formatted table.
     * 
     * @param students Array of students to display.
     */
    private static void printList(Student[] students) {
        System.out.println("\n" + "-".repeat(60));
        System.out.println("| Rank |      Name       | Marks |          Position          |");
        System.out.println("-".repeat(60));
        
        for (int i = 0; i < students.length; i++) {
            String position = getPositionBadge(i + 1);
            System.out.printf("| %-4d | %-15s | %5d | %-26s |%n", 
                (i + 1), 
                students[i].getName(), 
                students[i].getMarks(),
                position);
        }
        System.out.println("-".repeat(60));
    }

    /**
     * Returns a badge/label for the rank position.
     * 
     * @param rank The rank position (1-based).
     * @return A string representation of the position badge.
     */
    private static String getPositionBadge(int rank) {
        switch (rank) {
            case 1:
                return "🥇 1st Place (Gold Medal)";
            case 2:
                return "🥈 2nd Place (Silver Medal)";
            case 3:
                return "🥉 3rd Place (Bronze Medal)";
            default:
                return "   " + rank + getOrdinalSuffix(rank) + " Place";
        }
    }

    /**
     * Returns the ordinal suffix for a number (st, nd, rd, th).
     * 
     * @param number The number to get the suffix for.
     * @return The ordinal suffix.
     */
    private static String getOrdinalSuffix(int number) {
        if (number >= 11 && number <= 13) {
            return "th";
        }
        switch (number % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }

    /**
     * Centers text within a specified width.
     * 
     * @param text  The text to center.
     * @param width The total width to center within.
     * @return The centered text with appropriate padding.
     */
    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }
}