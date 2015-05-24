Challenge


# Explanation for O(n)

**below is the flow of code**

* read the character array one by one 
* assumption is words are seperated by one or more spaces
* as we read the words create a hashmap with word and count. since we only hold unique keys get(key) in hashmap is O(1). If key is duplicate ofcourse we increment the count and update hashmap
* if value is present in hash map increment the value by 1.
* Finally we will have a hashmap with unique words and their frequency
* as we build the hashmap we keep track of maxValue. maxValue is the maximum occuring word.
* The entire operation is O(n) where n is no of characters
* Since print order is not guarenteed in map we need to do some sorting to get the most frequent words
* Any standard sort or collections.sort will be plogp where p is the number of words
* Not sure if O(plogp) < O(n). But we know that O(p) <= O(n) since p <= n and both are linear 
* So we create a reverse map for radix sort. We create an array of size maxValue. maxValue is count of most frequent word. The time to create this array is < O(p) worse case, since we will have maxValue less than the number of words
* the array will contain the list of words of that count. index is the frequency and value at the index is the list of words of that frequency.
* Building this array is O(p). get the value v, O(1) . Add value to list at array[v].. O(1). Do this for all p.. so overall O(p)
* Now we have to just print the array sequentially. However the function must return the list so we need to concat the lists
* If we traverse through the array of size s and concat the list using java concat then it will take O(s*w) where w is the no of words. Since Linked List concat java provides is not O(1). (It will call java toArray to create the spaces and return concat list..so its actually a O(n) operation.) This is fine for generic list implementation, however since we know that we have LinkedList we can just point a lists tail to other list head and do this in O(1) time.
* So instead of calling java concat we create a custom list implementation and go on collecting the word list in constant time. So the time to print in worse case is O(maxValue) and we know O(maxValue) < O(n)
* However we have to trim this list till the number of items we want which will take another O(p).
* since all these operations occur one after another linear time is maintained
* So total time = O(n)[parse words create map] + O(maxValue)[allocate reverse map size] + O(p)[build reverse array] + O(maxValue)[collectlist] + O(p)[print list only till size s , s< no of words] = O(n).
* Note this is not what we implement in production. This App is pointer intensive and is not space effecient. Since we have not space constraint and only time constraint we have this solution specific for challenge. ideally we would just sort the map(maybe use a tree map) and give the output.
* to see all edge cases tested check ChallengeTest and run it as junit

