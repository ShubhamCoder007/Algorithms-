
n = int(input('Enter the nth fib you want: '))

cache = [None for i in range(n + 1)]

def fib(n):
	if cache[n] != None:
		return cache[n]
	if n == 0 or n == 1:
		res = 1
	else:
		res = fib(n - 1) + fib(n - 2)
	cache[n] = res
	
	return cache[n]
	
print('num is: ',fib(n))