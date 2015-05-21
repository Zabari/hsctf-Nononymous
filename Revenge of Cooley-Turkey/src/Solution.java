import org.apache.commons.math3.transform.*;

public class Solution {
	
	public static DctNormalization dctNormalization = DctNormalization.ORTHOGONAL_DCT_I;
	public static TransformType transformType = TransformType.INVERSE;
	
	public static void main(String[] args) {
		FastCosineTransformer cosine = new FastCosineTransformer(dctNormalization);
		double nums[] = {1653.0, 0.13916760914832338, 58.72838425104149, -29.800988375644806, -64.39696961966996, 77.24677622083472, 29.83855931789015, -62.70175235211251, 42.999999999999986, 65.1382409674247, -21.49541356738255, -67.39554551772046, 54.396969619669974, 40.92032042100787, -39.07153000154913, -15.546218972937488, 65.0 };
		System.out.println(cosine.transform(nums, transformType));
	}
}