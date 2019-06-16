total = int(input('Enter the result of the subset: '))
a = [1,2,4,6,10]

cache = {}

def subset(a, index, total, cache):

	key = str(index) + ':' + str(total)
	
	if key in cache.keys():
		return cache[key]
	
	if total == 0:
		return 1
	
	if index < 0 or total < 0:
		return 0
		
	if a[index] > total:
		result = subset(a, index - 1, total, cache)
	else:
		result = subset(a, index - 1, total, cache) + subset(a, index - 1, total - a[index], cache)
		
	cache[key] = result
	
	return result
	
	
print('subset: ',a)
print('results: ',subset(a, len(a) - 1, total, cache))
