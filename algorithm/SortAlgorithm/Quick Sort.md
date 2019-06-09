# Quick Sort Algorithm

```java
public static void quickSort(String[] arr, int left, int right) {
		int pivot = left;
		int idxL = pivot;
		int idxR = left+1;
		
		if(left<right) {
			for(;idxR<=right;idxR++)
				if(arr[pivot]>arr[idxR]) {
					idxL++;
					swap(arr, idxL, idxR);
				}
			swap(arr, left, idxL);
			pivot = idxL;
			
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}

	}
	public static void swap(String[] arr, int idxL, int idxR) {
		String temp = arr[idxL];
		arr[idxL] = arr[idxR];
		arr[idxR] = temp;
	}
```