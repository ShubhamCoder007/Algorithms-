n = input('Enter the encrypt code: ')

map = {j:chr(i) for i,j in zip(range(97,123), range(1,27))}
loc = []

def decrypt(n):

	if len(n) == 0:
		return 0
		
	if int(n) <= 10:
		loc.append(map[int(n)])
		print(loc)
		loc.clear()
		return 1
		
	if int(n) >= 11 and int(n) <= 26:
		loc.append(map[int(n)])
		return decrypt(n[0]) + decrypt(n[1])
		
	if int(n[:2]) <= 26:	
		return decrypt(n[0])*decrypt(n[1:]) + decrypt(n[:2])*decrypt(n[2:])
		
	return decrypt(n[0])*decrypt(n[1:])

	
print('Number of possible strings: ',decrypt(n))