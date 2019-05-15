package ocr;

import java.io.File;
import net.sourceforge.tess4j.*;
/**
 * 
 * @author wangyan
 * @date 2019年5月15日
 * @Description  识别图片里面的文字。只需要在maven里面添加相应的jar包，并且下载相应的tessdata训练库即可。默认下载库没有中文字符，需要再次下载中文库。
 * @version 2019年5月15日
 */
public class CharacterRecognition {

	public static void main(String[] args) {
		File imageFile = new File("F://Projects//CloudTest//HadoopJavaProject//JavaPractices//src//main//java//ocr//china.jpg");
		ITesseract instance = new Tesseract();
		instance.setLanguage("chi_sim");
		instance.setDatapath("F://Projects//CloudTest//HadoopJavaProject//JavaPractices//src//main//resources//tessdata");
		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch(TesseractException e) {
			System.err.println(e.getMessage());
		}
	}

}
