# Hashing with open addressing
## Group: HT - Dialytellus
### Final Project

Simple need to run the main function in Hashing_Test.java

If code seems to run to slow, change:
```
int T = 20;
```
to any other value < 20

### How to interpret the data:
First Table represents the data for a "dynamiccally" resized LinearProbingHashST.
This contains:
```
N	 = Number of words
Time to Put(ms)	= Time to put for a size N
Time to Get(ms) = Time to get for a size N     
SDPut(ms) = Standard deviation for 'put' for a size N 
SDGet(ms) = Standard deviation for 'get' for a size N 

```

Second Table represents the data for a "fixed" resized LinearProbingHashST.
```
mf = Multiplication Factor   
Size = Initial size of table	        
Time to Put Constant Size(ms)	= Time to put for a Size of N	with mf
Time to Get Constant Size(ms) = Time to get for a Size of N	with mf    
SDPut(ms) = Standard deviation for 'put' for a size N with mf
SDGet(ms) = Standard deviation for 'get' for a size N with mf
```
