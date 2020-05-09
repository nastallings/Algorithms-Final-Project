# Hashing with open addressing
## Group: HT - Dialytellus 
### By: Praneeth Appikatla, Troy Mullenberg, Siddhartha Pradhan, and Nathan Stallings 
## Final Project


### How to run
```
Simply need to run the main function in Hashing_Test.java
```

**If code seems to run to slow, change value of T in the main fuction to any other value < 100**
```java

        int T = 20;     // Number of T independent tests  <--- This one here

        timeToGetAndPutDynamic(T);
        boolean deleteSuccessStatic = timeStatic(T);
        boolean deleteSuccess = timeToFillAndDelete(T);
```


### How to interpret the data:

## First Table: Represents the data for a "dynamically" resized LinearProbingHashST.
```
N = Number of Words
Time to Put(ms)	= Average time to put for a size N
Time to Get(ms) = Average time to get for a size N     
SDPut(ms) = Standard deviation for 'put' for a size N 
SDGet(ms) = Standard deviation for 'get' for a size N 

```

## Second Table: Represents the data for a "fixed" resized LinearProbingHashST.
*If incase all the values were not deleted successfully, a warning message will appear*
```
mf = Multiplication Factor   
Size = Initial size of table	        
Time to Put Constant Size(ms)	=  Average time to put for that mF
Time to Get Constant Size(ms) = Average time to get for that mF
SDPut(ms) = Standard deviation for 'put' for that mf 
SDGet(ms) = Standard deviation for 'get' for that mf 
TimeToDelete = Average time to delete all the values in size mF
DeleteSD = Standard deviation of time to delete
```

## Third Table: Represents the data for adding and deleting all the values in the table (Size = 321165)
*If incase all the values were not deleted successfully, a warning message will appear*
```
 TimeToPutAndDelete = Average time to put and delete all values
 TimeToPutAndDeleteSD = Standard deviation to put and delete all values
```
