/*
 * @lc app=leetcode id=393 lang=java
 *
 * [393] UTF-8 Validation
 */
class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0)
            return false;
        for(int i = 0; i < data.length; i++){
            if(data[i] > 255)
                return false;
            int numOfByte = 0;
            if((data[i] & 128) == 0)
                numOfByte = 1;
            else if ((data[i] & 224) == 192)
                numOfByte = 2;
            else if ((data[i] & 240) == 224)
                numOfByte = 3;
            else if ((data[i] & 248) == 240)
                numOfByte = 4;
            else     
                return false;
            
            for(int j = 1; j < numOfByte; j++){
                if((i + j) >= data.length)
                    return false;
                if((data[i + j] & 192) != 128)
                    return false;
            }
            
            i = i + numOfByte - 1;
        }
        return true;
    }
}

