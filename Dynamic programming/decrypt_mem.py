
map = {j:chr(i) for i,j in zip(range(97,123), range(1,27))}

def decrypt(data, k, memo):
	if k == 0:
		return 1
	s = len(data) - k
	if data[s] == '0':
		return 0
	if memo[k] != None:
		return memo[k]
	result = decrypt(data, k - 1, memo)
	if k >= 2 and int(data[s:s+2]) <= 26:
		result = result + decrypt(data, k - 2, memo)
	memo[k] = result
	return result
	
data = input('Enter the string of numbers: ')
memo = [None for i in range(len(data) + 1)]

print(decrypt(data, len(data), memo))