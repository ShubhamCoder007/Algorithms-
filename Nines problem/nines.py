# Enter your code here. Read input from STDIN. Print output to STDOUT

T = int(input())


def balance(n):
    bal = 0
    while n % 10 != 9:
        n = n - 1
        bal = bal + 1
    return bal


def nines(n, l):
    #print(n, l)

    if n <= 0:
        return

    if n % 10 == 9:
        l.append(n)

    if n < 9:
        bal = n
        n = n + l[-1]
        l.pop()
        bal =  balance(n - 10) + 10
        l.append(n - bal)
        nines(bal, l)



    while sum(l) != N and n >= 9:
        bal = balance(n)
        n = n - bal
        l.append(n)
        nines(bal, l)

    

def nine_util(n):
    if n % 10 == 9:
        return 1

    if n < 9:
        return -1

    l = []
    try:
        nines(n, l)
    except RecursionError:
        return -1

    if len(l) == 0:
        return -1

    return len(l)


while T > 0:
    N = int(input())
    print(nine_util(N))
    T = T - 1