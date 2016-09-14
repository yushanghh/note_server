package all_servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class uploadfile extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "D:\\images\\";
        try {
            File file_path = new File(path); 
            if (!file_path.exists()){
                file_path.mkdirs();
            }
            InputStream fin = request.getInputStream();
            int count=0,b=0,name_length=0,count1=0;//用于将文件名读出
            byte []length_buffer=new byte[4];//将文件大小读入byte数组
            byte []name_buffer=new byte[1];
            b=fin.read();
            while(b != -1){
            	if(count<4 && count1==0){
            		length_buffer[count]=(byte)b;
            		count++;
            		if(count==4){
            			name_length=(int)length_buffer[0];
	            		name_length &= 0xff;
	            		name_length |= ((int) length_buffer[1] << 8); 
	            		name_length &= 0xffff; 
	            		name_length |= ((int) length_buffer[2] << 16); 
	            		name_length &= 0xffffff; 
	            		name_length |= ((int) length_buffer[3] << 24); 
	            		name_length &= 0xffffffff; //得到文件名大小
	            		System.out.println(name_length);
	            		count++;
	            		name_buffer=new byte[name_length];
            		}
            	}else if(count>=4 && count1<name_length){
            		name_buffer[count1]=(byte)b;
            		count1++;
            	}else if(count1==name_length){
        			String file_name=new String(name_buffer,"utf-8");
        			System.out.println(file_name);
        			file_name=URLDecoder.decode(file_name,"UTF-8");
        			System.out.println(file_name);//通过文件名来解析更多路径
        			path=path+file_name;
        			System.out.println(path);
    	            File file = new File(path);//得到文件名，解析
    	            FileOutputStream file_out = new FileOutputStream(file);
       	            while(b!=-1){
       	            	file_out.write(b);
       	            	b = fin.read();//得到文件流
       	            }
           	        fin.close();
                    file_out.close();
       	            break;
            	}
            	b=fin.read();
            }
            System.out.println("success");
            response.getOutputStream().print("success");
        } catch (Exception e) {
           e.printStackTrace();
           response.getOutputStream().print("failed");
        }
        finally{
        	
        }
	}
}
