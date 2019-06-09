# Merge Sort Algorithm

```java
	public static void mergeSort(String[] arr, int left, int right) {
		if(left< right) {
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			mergeTwoArea(arr, left, mid, right);
		}
	}
	public static void mergeTwoArea(String[] arr, int left, int mid, int right) {
		int idxL = left;
		int idxR = mid+1;
		String temp[] = new String[arr.length];
		int idx = left;
		
		while(idxL<=mid&&idxR<=right) {
			if(arr[idxL]<=arr[idxR]) {
				temp[idx++] = arr[idxL++];
			}else {
				temp[idx++] = arr[idxR++];
			}
		}
		if(idxL>mid)
			for(;idxR<=right; idx++, idxR++)
				temp[idx] = arr[idxR];
		else
			for(;idxL<=mid;idx++, idxL++)
				temp[idx] = arr[idxL];
		
		for(int i = left; i<=right; i++)
			arr[i] = temp[i];
	}
```

