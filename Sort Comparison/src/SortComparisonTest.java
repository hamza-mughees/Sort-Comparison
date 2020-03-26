/*
  TABLE OF RUNNING TIMES:  	
 All times are measured in milliseconds (ms)
 All times are the average outcome of a total of three runs
 .--------------------------------------------------------------------------------.
 |                    ||Insert |Selection|Merge Recursive|Merge Iterative|Quick   |
 |--------------------||-------|---------|---------------|---------------|--------|
 |10 random           ||0.0027 |0.0037   |0.0149         |0.0216         |0.0067  |
 |100 random          ||0.0546 |0.1201   |0.0876         |0.1364         |0.1389  |
 |1000 random         ||3.5626 |4.2806   |0.8307         |1.0701         |3.6446  |
 |1000 few unique     ||5.5462 |3.6925   |0.8248         |1.2351         |2.1204  |
 |1000 nearly ordered ||0.9929 |3.7222   |0.8407         |1.0851         |4.6980  |
 |1000 reverse order  ||6.5071 |3.8414   |0.7224         |1.1582         |3.1764  |
 |1000 sorted         ||0.045  |3.8223   |1.0526         |1.2385         |5.8102  |
 '--------------------------------------------------------------------------------'
 
 QUESTIONS AND ANSWERS:
 
 a. Which of the sorting algorithms does the order of input have an impact on? Why?
 Answer: Insert and Quick. 
         The more shuffled the array is, the longer insertion sort takes
         since it the amount of values to reorder is increased.
         the more sorted the array is, the longer quick sort takes.
 
 b. Which algorithm has the biggest difference between the best and worst performance, based
 on the type of input, for the input of size 1000? Why?
 Answer: Best: Merge Recursive
         Worst: Insert
         Insertion sort varies in running time depending on how sorted the array is while 
         merge sort recursive takes relatively constant amount of time as the amount of data
         moved around stays the same, regardless of how sorted the array is.
         
 c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 based on the input size? Please consider only input files with random order for this answer.
 Answer: Best: Merge Recursive
         Worst: Selection
         
 d. Did you observe any difference between iterative and recursive implementations of merge
 Answer: Yes
 
 e. Which algorithm is the fastest for each of the 7 input files?
 Answer: 10 random: Insert
         100 random: Insert
         1000 random: Merge Recursive
         1000 few unique: Merge Recursive
         1000 nearly ordered: Merge Recursive
         1000 reverse order: Merge Recursive
         1000 sorted: Insert
  */

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

// -------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author Hamza Mughees
 * @version HT 2020
 */

@RunWith(JUnit4.class)
public class SortComparisonTest {
	// For measuring running times
	double startTime;
	double endTime;
	double timeElongated;

	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testEmpty() throws InterruptedException, FileNotFoundException {
		double a[] = {};
		System.out.println("Empty array ([]):");

		startTime = System.nanoTime();
		double sortedA[] = SortComparison.insertionSort(a);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		assertEquals("[]", Arrays.toString(sortedA));
		System.out.println("Time elongated for insertion sort: " + timeElongated + "ms");

		startTime = System.nanoTime();
		sortedA = SortComparison.selectionSort(a);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		assertEquals("[]", Arrays.toString(sortedA));
		System.out.println("Time elongated for selection sort: " + timeElongated + "ms");

		startTime = System.nanoTime();
		sortedA = SortComparison.quickSort(a);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		assertEquals("[]", Arrays.toString(sortedA));
		System.out.println("Time elongated for quick sort: " + timeElongated + "ms");

		startTime = System.nanoTime();
		sortedA = SortComparison.mergeSortRecursive(a);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		assertEquals("[]", Arrays.toString(sortedA));
		System.out.println("Time elongated for merge sort recursive: " + timeElongated + "ms");

		startTime = System.nanoTime();
		sortedA = SortComparison.mergeSortIterative(a);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		assertEquals("[]", Arrays.toString(sortedA));
		System.out.println("Time elongated for merge sort iterative: " + timeElongated + "ms\n");

		System.out.println("Non-empty array ([...]):");
	}

	@Test
	public void testInsertionSort() {
		double array[] = { 5, 2, 7, 8, 1 };
		startTime = System.nanoTime();
		double sortedA[] = SortComparison.insertionSort(array);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;

		assertEquals("[1.0, 2.0, 5.0, 7.0, 8.0]", Arrays.toString(sortedA));
		
		System.out.println("Time elongated for insertion sort: " + timeElongated + "ms");
	}

	@Test
	public void testSelectionSort() {
		double array[] = { 5, 2, 7, 8, 1 };
		startTime = System.nanoTime();
		double sortedA[] = SortComparison.selectionSort(array);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		
		assertEquals("[1.0, 2.0, 5.0, 7.0, 8.0]", Arrays.toString(sortedA));

		System.out.println("Time elongated for selection sort: " + timeElongated + "ms");
	}

	@Test
	public void testQuickSort() {
		double array[] = { 5, 2, 7, 8, 1 };
		startTime = System.nanoTime();
		double sortedA[] = SortComparison.quickSort(array);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;
		
		assertEquals("[1.0, 2.0, 5.0, 7.0, 8.0]", Arrays.toString(sortedA));

		System.out.println("Time elongated for quick sort: " + timeElongated + "ms");
	}

	@Test
	public void testMergeSortRec() {
		double array[] = { 5, 2, 7, 8, 1 };
		startTime = System.nanoTime();
		double sortedA[] = SortComparison.mergeSortRecursive(array);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;

		assertEquals("[1.0, 2.0, 5.0, 7.0, 8.0]", Arrays.toString(sortedA));

		System.out.println("Time elongated for merge sort recursive: " + timeElongated + "ms");
	}

	@Test
	public void testMergeSortItr() {
		double array[] = { 5, 2, 7, 8, 1 };
		startTime = System.nanoTime();
		double sortedA[] = SortComparison.mergeSortIterative(array);
		endTime = System.nanoTime();
		timeElongated = (endTime - startTime) / 1000000;

		assertEquals("[1.0, 2.0, 5.0, 7.0, 8.0]", Arrays.toString(sortedA));

		System.out.println("Time elongated for merge sort iterative: " + timeElongated + "ms");
	}

	// TODO: add more tests here. Each line of code and ech decision in
	// Collinear.java should
	// be executed at least once from at least one test.

	// ----------------------------------------------------------
	/**
	 * Main Method. Use this main method to create the experiments needed to answer
	 * the experimental performance questions of this assignment.
	 *
	 */
//	public static void main(String[] args) throws Exception
//	{
//
//		I did not implement this method and instead read the text file inside the
//		testEmpty() method
//		since the main method wouldn't run simultaneously with the other methods.
//
//		//TODO: implement this method
//	}

}