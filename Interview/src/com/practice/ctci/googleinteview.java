//import java.util.Iterator;
//import java.util.NoSuchElementException;YOu have 2 arrays:
//1st array of numbers and second array of number of occurancies of those numbers.
//
//Input:
//1   3    5    2   7   24
//
//2   4    0    1    1   6
//
//
//
//Iterator:
//
//Output sequence: 1  1  3  3  3  3   2  7   24   24  24  24  24  24
//
//
//class MyIterator implements Iterator<Integer>
//{
//
//int [] firstArray;
//int [] secondArray;
//int count=0;
//int cursor = 0;
//public MyIterator(int [] firstArray, int [] secondArray) {
//	this.firstArray = firstArray;
//	this.secondArray = secondArray;
//}
//
//
//
//
//public boolean hasNext()
//{
//	if(cursor>=firstArray.length) {
//	return false;
//}
//while(secondArray[cursor] == count && cursor < firstArray.length) {
//	cursor++;
//    count = 0;
//}
//return cursor < firstArray.length;
//}
//
//public Integer next() {
//
//    if(hasNext()) {
//       count++;
//       return firstArray[cursor];
//    }
//  throw new NoSuchElementException();
//
//}
//
////================
//
//public static void main(String [] args) {
//int [] first = [1   3    5    2   7   24]
//
//int [] second = [2   4    0    1    1   6]
//MyIterator i = new MyIterator(first,second);
//
//while(i.hasNext()) {
//	System.out.print(i.next());
//}
//}
//
//
//
//
//Test Cases :
//
//1st [1 2 3]
//      2nd [0 0 1]
//   2) 1st [1 2 3]
//      2nd [1 1 1]
//   3) 1st [1]
//      2nd [0]
//   4) 1st []
//      2nd []
//
