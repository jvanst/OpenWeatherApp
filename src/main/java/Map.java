import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;
import javax.swing.JLabel;




public class Map {
	private ImageIcon map;
	
	/**
	 * A class to get an image icon of the current weather location
	 * @author	Group10 (James V, Li G, Curtis V, Alec W, Jeremy A)
	 * @version	1.0
	 * @since 	March 23, 2015
	 */
	public Map(String latitude, String longtitude){

	        try {
	            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+URLEncoder.encode(latitude, "UTF-8")+","+URLEncoder.encode(longtitude, "UTF-8")+"&zoom=10&size=355x249";
	            String destinationFile = "image.jpg";
	            System.out.println(imageUrl);
	            URL url = new URL(imageUrl);
	            java.io.InputStream is = url.openStream();
	            OutputStream os = new FileOutputStream(destinationFile);

	            byte[] b = new byte[2048];
	            int length;

	            while ((length = is.read(b)) != -1) {
	                os.write(b, 0, length);
	            }

	            is.close();
	            os.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (NullPointerException e){
	        	System.out.println("Map Not Found");
	        }

	        map = new ImageIcon((new ImageIcon("image.jpg")).getImage());
			}
	
	/**
	 * 
	 * @return An image of the current city 
	 */
	public ImageIcon getMap(){
		return this.map;
	}
	}

