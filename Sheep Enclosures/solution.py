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
    
def main():
    f = open("input.txt",'r').read().split("\n") # contains coordinates
    l = []
    for i in f:
        l.append([int(i.split()[0]),int(i.split()[1])])
    areaPoly = area(l)
    
    
    
    

main()
