package question0537_complex_number_multiplication;

public class Solution {

  public String complexNumberMultiply(String a, String b) {
    String nums1[] = a.split("\\+|i"), nums2[] = b.split("\\+|i");
    int real1 = Integer.parseInt(nums1[0]), img1 = Integer.parseInt(nums1[1]), real2 =
        Integer.parseInt(nums2[0]), img2 = Integer.parseInt(nums2[1]);
    return (real1 * real2 - img1 * img2) + "+" + (real1 * img2 + img1 * real2) + "i";

  }
}