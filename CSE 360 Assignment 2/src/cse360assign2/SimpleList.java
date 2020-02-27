/**
 * @author Paris Brown
 * @classID 216
 * @Assignment #2
 * This file is built to perform simple operations on arrays
 * such as: adding, removing, searching, counting, appending, increasing array 
 * size and displaying the elements in an array. The default 
 * constructor is used to initial-size a new array of length 
 * 10 and count of elements of 0. 
 */

package cse360assign2;

public class SimpleList {

	private int[] list;
	private int count;


	/**
	 * This constructor is used to initialize an array to length 10 and the count of
	 * elements in the array to 0;
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}

	/**
	 * This method adds an element to the front of an array and shifts the rest of
	 * the contents to the right. If the array is full then the element in the last
	 * position is "falls off" and the second to last element takes the last
	 * position. If the array is at full capacity when we try to add the new element
	 * then it will increase the size of the array by 50%
	 * 
	 * @param addedNum is the number the user wants to add to the front of the array
	 */

	public void add(int addedNum) {

		if (count == list.length) {

			double newSize = list.length * 1.5 + 1;

			int[] temp = new int[(int) newSize];

			for (int index = 0; index < list.length; index++) {

				temp[index] = list[index];
			}
			list = temp;

		}

		if (count == 0) {

			list[0] = addedNum;
			count++;

		} else if (count == 1) {

			int temp = list[0];
			list[0] = addedNum;
			list[1] = temp;
			count++;

		} else {

			count++;

			/**
			 * This for loop starts at the end of array (count -1) and decrements by 1 until
			 * it gets to the first index, 0, and performs no action on the first index.
			 * This for loop is shifting all the elements to the right so the new element
			 * can be added to the front of the array.
			 * 
			 * @initialization index = count -1
			 * @condition index > 0
			 * @update index--
			 */

			for (int index = count - 1; index > 0; index--) {

				list[index] = list[index - 1];
			}

			list[0] = addedNum;

		}

	}

	/**
	 * This method removes the first occurrence of a number from an array regardless
	 * of its position in the array. If the array is less than 75% full when an
	 * element is removed the size will be reduced by 25% of its current size.
	 * 
	 * @param removeNum is the number the user wants to remove from the array.
	 */

	public void remove(int removeNum) {
		if (count > 0) {

			boolean found = false;
			int index = -1;

			while (!found) {
				index++;

				if (list[index] == removeNum) {
					list[index] = 0;
					found = true;
				}
			}

			if (list.length > 1) {

				double threeQuarterFull = list.length * (.75);

				if (count < threeQuarterFull) {

					double newSize = list.length - list.length * (.25);

					int[] temp = new int[(int) newSize];

					for (int iter = 0; iter < temp.length; iter++) {

						temp[iter] = list[iter];
					}

					list = temp;

				}
			}

			/**
			 * This for loop starts at the index we found the first occurrence of the number
			 * to remove and increments up to the last element in the array. This for loop
			 * shifts all the remaining elements in the array to the right after the delete
			 * is performed.
			 * 
			 * @initialization index = index
			 * @condition index < count - 1
			 * @update index++
			 */

			for (int currentIndex = index; currentIndex < count - 1; currentIndex++) {

				list[currentIndex] = list[currentIndex + 1];

			}

			list[count - 1] = 0;
			count--;
		}

	}

	/**
	 * This method traverses through the entire array and counts how many non zero
	 * elements are present(count of elements) and returns that value to the
	 * original call
	 * 
	 * @return the amount of non zero elements in the array
	 */

	public int count() {

		return count;
	}

	/**
	 * This method traverses through the entire array and creates a string that will
	 * be returned that contains each element in the array separated by a space.
	 * 
	 * @return is the string that is comprised of all the elements in the array
	 *         separated by a space.
	 */
	public String toString() {
		String str = "";

		if (count != 0) {
			str = String.valueOf(list[0]);
		}

		/**
		 * This for loop starts at the second element in the array and increments to the
		 * last element of the array This for loop creates a string that will be
		 * returned containing all the elements of the array separated by a space.
		 * 
		 * @initialization index = 1
		 * @condition index< count
		 * @update index++
		 */

		for (int index = 1; index < count; index++) {
			str += " " + list[index];
		}

		return str;
	}

	/**
	 * This method traverses through the entire array in search of a specific
	 * element, searchNum. Once it finds the number we are in search of it will
	 * change the stop condition, the boolean found, to true and stop the counter,
	 * index, to keep track of the index where we found the element. If the element
	 * is never found the index is initialized to -1 and is returned as such
	 * signaling that the element was never found
	 * 
	 * @param searchNum is the number the user is searching for in the array.
	 * @return either -1 representing the element was not found or the index of the
	 *         element we were in search of in the array.
	 */

	public int search(int searchNum) {
		boolean found = false;
		int index = -1;
		int iter = -1;
		while (!found && iter < list.length - 1) {
			iter++;
			if (list[iter] == searchNum) {
				found = true;
				index = iter;
			}
		}

		return index;
	}

	/**
	 * This method adds an element to the end of the array and if the array is full
	 * then it will increase the size of the array by 50% and add the element to the
	 * end of the array
	 * 
	 * @param addedNum the number to the added to the end of the array
	 */

	public void append(int addedNum) {

		if (count == list.length) {

			double newSize = list.length * 1.5;

			int[] temp = new int[(int) newSize];

			for (int index = 0; index < list.length; index++) {

				temp[index] = list[index];
			}
			list = temp;

		}

		count++;

		list[count - 1] = addedNum;

	}

	/**
	 * This method returns the first element in the array
	 * 
	 * @return element at index 0 (first element in the array)
	 */

	public int first() {

		return list[0];

	}

	/**
	 * This method finds the last element in the array (length-1) and returns it
	 * 
	 * @return the element at the last index in the array
	 */

	public int last() {

		return list[list.length - 1];
	}

	/**
	 * This method returns the length of the array 'list'
	 * 
	 * @return the length of the array
	 */

	public int size() {

		return list.length;
	}

}
