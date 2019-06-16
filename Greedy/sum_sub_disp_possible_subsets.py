total = int(input('Enter the result of the subset: '))
a = [1,2,4,6,10]
loc = []

def subset(a, index, total):
	
	if total == 0:
		print(loc)
		loc.clear()
		return 1
		
	if index < 0:
		return 0
		
	if total < 0:
		return 0
		
	if a[index] > total:
		return subset(a, index - 1, total)
	else:
		loc.append(a[index])
		return subset(a, index - 1, total - a[index]) + subset(a, index - 1, total)
		
		
print('set: ',a)
print('Number of subsets: ',subset(a, len(a) - 1, total))

