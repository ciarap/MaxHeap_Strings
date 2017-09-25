public interface MaxHeapInterface < String extends Comparable < ? super String >>
{
    /** Task: Adds a new entry to the heap.
    * @param newEntry an object to be added */
    public void add (String newEntry);
    
    /** Task: Removes and returns the largest item in the heap.
    * @return either the largest object in the heap or,
    * if the heap is empty before the operation, null */
    public String removeMax ();
    
    /** Task: Retrieves the largest item in the heap.
    * @return either the largest object in the heap or,
    * if the heap is empty, null */
    public String getMax ();
    
    /** Task: Detects whether the heap is empty.
    * @return true if the heap is empty, else returns false */
    public boolean isEmpty ();
    
    /** Task: Gets the size of the heap.
    * @return the number of entries currently in the heap */
    public int getSize ();
    
    /** Task: Removes all entries from the heap. */
    public void clear ();
    
} // end MaxHeapInterface