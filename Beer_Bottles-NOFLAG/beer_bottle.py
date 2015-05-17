#!/usr/bin/env python
#task: "the lowest triangle-square greater than 238...*7 bil"
import math

def perfect_sq(n):
    return n == int(math.sqrt(n)) * int(math.sqrt(n))

def triangular(n):
    return n * (n+1) / 2

limit = 7000000000 * 358000000
summation = []
for i in xrange(limit):
    summation.append(triangular(i))


#I don't know if we need this part
val = 0 
for num in xrange(1, limit):
    if perfect_sq(num) and (num in summation):
        val = num
    else:
        continue

print val
