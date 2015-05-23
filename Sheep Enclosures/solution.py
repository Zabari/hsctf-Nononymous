from math import *

def angle(x1,y1,x2,y2,x3,y3): # (x2,y2) is the vertex
    d1 = (x2 - x1)**2 + (y2 - y1)**2 # squared distances
    d2 = (x2 - x3)**2 + (y2 - y3)**2
    d3 = (x3 - x1)**2 + (y3 - y1)**2
    return acos((d1 + d2 - d3) / (2*sqrt(d1)*sqrt(d2)))


def area(l):
    l.append(l[0])
    sum1 = 0
    sum2 = 0
    count = 1
    while count < len(l):
        sum1 += l[count-1][1] * l[count][0]
        sum2 += l[count][1] * l[count-1][0]
        count += 1
    l.pop()
    return abs(sum1 - sum2) / 2.0
    
def convex(l):
    l.sort()
    m = [[l[0][0] - 1,l[0][1]],l[0]]
    while(True):
        if m[:-1] == m[1]:
            n = m[1:-1]
            break
        minangle = 2 * pi
        mini = []
        for i in l:
            angl = angle(m[:-2][0],m[:-2][1],m[:-1][0],m[:-1][1],i[0],i[1])
            if (i not in m[2:]) and 2*pi - angl < minangle:
                minangle = angl
                mini = i
        m.append(mini)
    return area(n)
            
                        
        
def main():
    f = open("input.txt",'r').read().split("\n") # contains coordinates
    l = []
    for i in f:
        l.append([int(i.split()[0]),int(i.split()[1])])
    areaPoly = area(l) # computes area of the polygon
    print areaPoly
    print sorted(l)
    print convex(l)
    
    
    

main()
