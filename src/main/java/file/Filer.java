package file;

import java.io.*;

/**
 * @author wangYaBin
 * @date 2021/6/4
 */
public class Filer {
    /**
     * 读取
     */
    public static String read(String file) {
        BufferedReader in = null;
        String s = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            s = sb.toString();
            System.out.println(s);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    /**
     * 写文件
     */
    public static void write(String file, String str) {
        BufferedWriter out;
        try {
            File f = new File(file);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
            out.write(str);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
