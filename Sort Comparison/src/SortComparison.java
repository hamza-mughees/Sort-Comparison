// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	for (int i=1; i<a.length; i++)
		{
			double tmp = a[i];
			int j = i-1;
			while (j>=0 && tmp<a[j])
			{
				a[j+1] = a[j--];
			}
			a[j+1] = tmp;
		}
		return a;
        //todo: implement the sort
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	int minIndex;
		for (int i=0; i<a.length-1; i++)
		{
			minIndex = i;
			for (int j=i+1; j<a.length; j++)
				if (a[j] < a[minIndex])
					minIndex = j;
			if (minIndex != i)
				a = swap(a, i, minIndex);
		}
		return a;
         //todo: implement the sort

    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	recQuickSort(a, 0, a.length-1);
    	return a;
		 //todo: implement the sort

    }//end quicksort
    
    private static int partition (double a[], int lo, int hi) 
    {
    	int i = lo;
    	int j = hi+1;
    	double pivot = a[lo];
    	while (true) 
    	{
    		while (a[++i] < pivot)
    			if (i == hi) break;
    		while(a[--j] > pivot)
    			if (j == lo) break;
    		if (i >= j) break;
    		a = swap(a, i, j);
    	}
    	a[lo] = a[j];
    	a[j] = pivot;
    	return j;
    }
    
    private static void recQuickSort (double a[], int lo, int hi) 
    {
    	if (hi <= lo)
    		return;
    	int pivInd = partition(a, lo, hi);
    	recQuickSort(a, lo, pivInd-1);
    	recQuickSort(a, pivInd+1, hi);
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {    	
    	for (int subArrSize = 1; subArrSize < a.length; subArrSize *= 2)
    		for (int leftFirstInd = 0; leftFirstInd < a.length-1; leftFirstInd += subArrSize*2)
    		{
    			int mid = (leftFirstInd + subArrSize - 1 < a.length - 1) ? 
    					(leftFirstInd + subArrSize - 1) : (a.length - 1);
    			int rightLastInd = (leftFirstInd + (subArrSize*2) - 1 < a.length - 1) ?
    					(leftFirstInd + (subArrSize*2) - 1) : (a.length - 1);
    			mergeItr(a, leftFirstInd, mid, rightLastInd);
    		}
    	return a;
		 //todo: implement the sort
	
    }//end mergesortIterative
    
    private static void mergeItr (double a[], int lo, int mid, int hi) {
    	double left[] = new double[mid - lo + 1];
    	double right[] = new double[hi - mid];
    	int i;
    	int j;
    	
    	for (i=0; i<left.length; i++)
    		left[i] = a[lo+i];
    	for (j=0; j<right.length; j++)
    		right[j] = a[mid+j+1];
    	
    	i = 0;
    	j = 0;
    	int k = lo;
    	
    	while (i<left.length && j<right.length)
    	{
    		if (left[i] <= right[j])
    			a[k] = left[i++];
    		else a[k] = right[j++];
    		k++;
    	}
    	
    	while (i<left.length)
    		a[k++] = left[i++];
    	while (j<right.length)
    		a[k++] = right[j++];
    }
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	double aux[] = new double[a.length];
    	recMergeSort(a, aux, a.length-1, 0);
    	return a;
    	//todo: implement the sort
	
    }//end mergeSortRecursive
    	
    private static void recMergeSort (double a[], double aux[], int hi, int lo) 
    {
    	if (hi <= lo) return;
    	int mid = lo + (hi - lo)/2;
    	recMergeSort(a, aux, mid, lo);
    	recMergeSort(a, aux, hi, mid+1);
    	mergeRec(a, aux, hi, mid, lo);
    }

    private static void mergeRec (double a[], double aux[], int hi, int mid, int lo) 
    {
    	for (int k=lo; k<=hi; k++)
    		aux[k] = a[k];
    	int i = lo, j = mid + 1;
    	for (int k=lo; k<=hi; k++)
    	{
    		if (i > mid) a[k] = aux[j++];
    		else if (j > hi) a[k] = aux[i++];
    		else if (aux[j] < aux[i]) a[k] = aux[j++];
    		else a[k] = aux[i++];
    	}
    }
   
    public static double[] swap (double a[], int index1, int index2)
   	{
   		double tmp = a[index1];
   		a[index1] = a[index2];
   		a[index2] = tmp;
   		return a;
   	}

//    public static void main(String[] args) {
//
//        //todo: do experiments as per assignment instructions
//    }

 }//end class
