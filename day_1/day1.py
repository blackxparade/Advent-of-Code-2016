def Day1_part1() :
    f = open('day1.txt', 'r')
    for line in f :
        directions = line.split(", ")

    directions[-1] = directions[-1].split('\n')[0]
    print directions

    actual_direction = "N"
    x = 0
    y = 0
    positions=[]
    positions.append([x,y])

    for d in directions :
        #print d[0]
        if d[0] == "R" and actual_direction == "N" :
            x += int(d[1:])
            actual_direction = "E"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "L" and actual_direction == "N" :
            x -= int(d[1:])
            actual_direction = "W"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "R" and actual_direction == "S" :
            x -= int(d[1:])
            actual_direction = "W"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "L" and actual_direction == "S" :
            x += int(d[1:])
            actual_direction = "E"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "R" and actual_direction == "E" :
            y -= int(d[1:])
            actual_direction = "S"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "L" and actual_direction == "E" :
            y += int(d[1:])
            actual_direction = "N"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "R" and actual_direction == "W" :
            y += int(d[1:])
            actual_direction = "N"
            Day1_part2(positions,x,y)
            continue

        if d[0] == "L" and actual_direction == "W" :
            y -= int(d[1:])
            actual_direction = "S"
            Day1_part2(positions,x,y)
            continue

    print abs(x)+abs(y)































def Day1_part2() :
        mapp = [ [ 0 for y in range( 500 ) ] for x in range( 500 ) ]
        f = open('day1.txt', 'r')
        for line in f :
            directions = line.split(", ")

        directions[-1] = directions[-1].split('\n')[0]
        print directions

        actual_direction = "N"
        x = 0
        y = 0
        positions=[]
        positions.append([x,y])

        for d in directions :
            #print d[0]
            if d[0] == "R" and actual_direction == "N" :
                for i in range(x, x+int(d[1:])+1) :
                    mapp[i][y] += 1
                    if mapp[i][y] == 2 :
                        print abs(i)+abs(y)
                x += int(d[1:])
                actual_direction = "E"
                continue

            if d[0] == "L" and actual_direction == "N" :
                for i in range(x, x-int(d[1:])-1,-1) :
                    mapp[i][y] += 1
                    if mapp[i][y] == 2 :
                        print abs(i)+abs(y)
                x -= int(d[1:])
                actual_direction = "W"
                continue

            if d[0] == "R" and actual_direction == "S" :
                for i in range(x, x-int(d[1:])-1,-1) :
                    mapp[i][y] += 1
                    if mapp[i][y] == 2 :
                        print abs(i)+abs(y)
                x -= int(d[1:])
                actual_direction = "W"
                continue

            if d[0] == "L" and actual_direction == "S" :
                for i in range(x, x+int(d[1:])+1) :
                    mapp[i][y] += 1
                    if mapp[i][y] == 2 :
                        print abs(i)+abs(y)
                x += int(d[1:])
                actual_direction = "E"
                continue

            if d[0] == "R" and actual_direction == "E" :
                for i in range(y, y-int(d[1:])-1,-1) :
                    mapp[x][i] += 1
                    if mapp[x][i] == 2 :
                        print abs(x)+abs(i)
                y -= int(d[1:])
                actual_direction = "S"
                continue

            if d[0] == "L" and actual_direction == "E" :
                for i in range(y, y-int(d[1:])+1) :
                    mapp[x][i] += 1
                    if mapp[x][i] == 2 :
                        print abs(x)+abs(i)
                y += int(d[1:])
                actual_direction = "N"
                continue

            if d[0] == "R" and actual_direction == "W" :
                for i in range(y, y-int(d[1:])+1) :
                    mapp[x][i] += 1
                    if mapp[x][i] == 2 :
                        print abs(x)+abs(i)
                y += int(d[1:])
                actual_direction = "N"
                continue

            if d[0] == "L" and actual_direction == "W" :
                for i in range(y, y-int(d[1:])-1,-1) :
                    mapp[x][i] += 1
                    if mapp[x][i] == 2 :
                        print abs(x)+abs(i)
                y -= int(d[1:])
                actual_direction = "S"
                continue

        #print abs(x)+abs(y)

Day1_part2()
