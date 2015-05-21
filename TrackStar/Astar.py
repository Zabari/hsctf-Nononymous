import math

'''
[
    [cols]
    [cols]
]
cols are lanes
'''
ROWS = 5
COLS = 3
track = [[0]*COLS]*ROWS

class Node:
    row,col = 0,0
    g,h,f = 0,0,0
    def __init__(self, row, col):
        self.row = row
        self.col = col

def puthurdles(f):
    global track
    hurdles = open(f, 'r').readlines()
    for hurdle in hurdles[1:]:
        h = hurdle.strip()
        row,col = h.split(' ')
        row,col = int(row), int(col)
        track[row] = track[row][:col] + [1] + track[row][col+1:]

def solve():
    opens = []
    #opens.append(Node(0,0))
    for i in xrange(COLS):
        opens.append(Node(0, i))
    closes = []
    while len(opens) != 0:
        q = Node(0,0)
        q.f = 999999
        for opt in opens:
            if opt.f < q.f:
                q = opt
        opens.remove(q)
        succs = []
        if track[q.row+1][q.col] == 0:
            succs.append(Node(q.row+1, q.col))
        else:
            succs.append(Node(q.row, q.col+1))
            succs.append(Node(q.row, q.col-1))
        for succ in succs:
            if succ.col < 0 or succ.col > COLS-1:
                continue
            succ.g = q.g + abs(q.col - succ.col)
            obstacles = 0
            tmpcol = succ.col
            for i in xrange(succ.row+1, ROWS):
                if track[i][tmpcol] == 1:
                    obstacles += 1
            succ.h = obstacles
            succ.f = succ.g + succ.h
            #print succ.row, succ.col
            #print succ.row, succ.time
            print succ.row, succ.col, succ.g, succ.h, succ.f
            if succ.row == ROWS-1:
                return "{g:%s, h:%s, f:%s}" % (succ.g, succ.h, succ.f)
            exit = False
            for opnd in opens:
                if opnd.row >= succ.row and opnd.col == succ.col and opnd.f <= succ.f:
                    exit = True
                    break
            if exit: continue
            for closed in closes:
                if closed.row >= succ.row and closed.col == succ.col and closed.f <= succ.f:
                    exit = True
                    break
            if exit: continue
            #print "Appending succ with row:", succ.row
            opens.append(succ)
        closes.append(q)

import sys
prob = sys.argv[1]
puthurdles(prob)
print solve()
