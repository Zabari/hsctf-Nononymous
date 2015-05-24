


def main():
    f = open("input.txt",'r').read().split("\r\n")[1:-1] # contains coordinates
    l = []
    
    for i in f:
        #print i.split()
        l.append([int(i.split()[0]),int(i.split()[1]),int(i.split()[2])])
    l.sort()
    print l

main()
