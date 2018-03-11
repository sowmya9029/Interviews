Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

You are in charge of a doggy daycare. Each dog is assigned to a kennel. Last night, the dogs threw a party, and somehow ended up in the wrong kennels (they’re still good dogs though). Since it’s only you opening, you can only move one dog at a time. You have a list of where the dogs are supposed to be located, write a function that determines how you need to move the dogs

 ideal	   current 		OUTPUT
a -> 1   (b)   		[1
 b -> 2   (a)    		0	
 c ->3    (c)    		2]


input :
Map
Dog1 - Location - 0
Dog2 - Location - 1
Dog3 - Location - 2
Dog4 - Location - 3
Dog5 - Location - 4
Dog6 - Location - 6

Kennels = [Location of kennel 0,...... , Location of kennel n]

Arraysize = number of kennels

currentLocation = [0,1,2] dogs = [dog3,dog5,dog4]
result = [<empty kennel> ,<empty kennel> ,dog3, dog4, dog5,<empty kennel> ]
input:


dog3 is in location 0 but should be in location 2 according to our map

HashMap<String,Integer> dogStore = new HashMap<String,Integer>();
int kennelSize; // number of kennels at our dog store
int[] moveDogToKennel(String [] currentLocation, String[] dogs)
{
   int [] result = new int[kennelSize];
   for(int i=0;i<currentLocation.length;i++)
  {
      
	result[dogStore.get()] = currentLocation[i];

  }
return result;
}



Test Case-provided
Map Desired location
Dog1 - 0
Dog2 - 4
Dog3 - 2

Current location:
[Dog2, empty,empty, Dog1, Dog3]
Output:
 0     1   2    3   4 
[Dog1 , , Dog3, , Dog2]
return [4, 1,3, 0, 2]


Test cases:
all empty kennels
empty kennels upfront and single dog in the last location
all dogs out of order
dogs in the same order
Ideal runtime: O(n)
Space: O(n)


