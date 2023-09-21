public class Search {

  public boolean binarySearch(int[] input, int lookingFor){
    int low = 0;
    int high = input.length - 1;

    while (low <= high){
        int i = (low+high)/2; // if double instead of int: double floorValue = Math.floor(divisionResult);
        if (input[i] == lookingFor){
            return true;
        }else if (input[i]<lookingFor){
            low = i+1;
        }else if(input[i]>lookingFor){
            high = i-1;
        }
    }
    return false;
  }  

}
