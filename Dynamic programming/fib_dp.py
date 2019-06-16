n = int(input('Enter the nth fibonacci seq: '))

def fib(n):
	if n == 0 or n == 1:
		return 1
	a = [None] * (n + 1)
	a[1] = a[2] = 1
	
	for i in range(3, n + 1):
		a[i] = a[i - 1] + a[i - 2]
		
	return a[n]
	
print('Number: ',fib(n))