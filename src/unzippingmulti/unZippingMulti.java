package unzippingmulti;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class unZippingMulti {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // ------------------------------------------
        FileInputStream in = new FileInputStream("Ameer.zip");
        ZipInputStream zin = new ZipInputStream(in);
        // ------------------------------------------
        // Zipping REQ.
        ZipEntry ze = null;
        FileOutputStream out = null;
        BufferedOutputStream bout = null;
        // ------------------------------------------
        while (true){
            ze = zin.getNextEntry();
            if (ze == null) break;
            out = new FileOutputStream(ze.getName());
            bout = new BufferedOutputStream(out);
            while (true){
                int b = zin.read();
                if (b == -1) break;
                bout.write(b);
            }
            bout.close();
            out.close();
            zin.closeEntry();
        }
    }    
}
