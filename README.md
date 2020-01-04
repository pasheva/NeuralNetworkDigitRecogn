## Neural Network for Digit Recognition.

> In progress...
---
Currently the network has 2 layers. The input, first, layer take a grid(5x3) with a number, which may not be fully or clearly displayed. The weights are generated from the actual correction representation of the number. The number is recognized by the highest activation of the output layer neuron.

###### Example:
```
Input: 
_X_
_X_
XX_
XX_
_XX

Output: 1

Input:
XX_
__X
___
X__
XXX

Output: 2

Input:
XXX
X_X
X_X
__X
XXX

Output: 0
```
### Run:
```
javac Main.java
java Main
```