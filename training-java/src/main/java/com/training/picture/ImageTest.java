package com.training.picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageTest {


    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ganjianxin\\Downloads\\200003279273_00_2_1600151016220.jpg");
        // 将流转换为缓冲区图像类
        BufferedImage image = null;
        try {
            image = ImageIO.read(fileInputStream);
            System.out.println(image);

        }catch(Exception e){
//            try
//            {
//                ThumbnailConvert tc = new ThumbnailConvert();
//                tc.setCMYK_COMMAND(file.getPath());
//                Image image =null;
//                image = Toolkit.getDefaultToolkit().getImage(file.getPath());
//                MediaTracker mediaTracker = new MediaTracker(new Container());
//                mediaTracker.addImage(image, 0);
//                mediaTracker.waitForID(0);
//                image.getWidth(null);
//                image.getHeight(null);
//            }catch (Exception e1){
//                e1.printStackTrace();
//            }
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }
}
