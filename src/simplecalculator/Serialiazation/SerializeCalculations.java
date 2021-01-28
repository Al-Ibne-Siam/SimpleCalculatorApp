package simplecalculator.Serialiazation;

import simplecalculator.Operation.Operations;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class SerializeCalculations {

    public static void Serialize(ArrayList<Operations> obj) throws FileNotFoundException, IOException, URISyntaxException {
        String path = SerializeCalculations.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "CalculationHistoryBin\\CalculationBin";
        File database = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream ous = null;
        fos = new FileOutputStream(database);
        ous = new ObjectOutputStream(fos);
        ous.writeObject(obj);
        fos.close();
        ous.close();
    }

    public static ArrayList<Operations> Deserialize() throws FileNotFoundException, IOException, ClassNotFoundException, URISyntaxException {
        try {
            String path = SerializeCalculations.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "CalculationHistoryBin\\CalculationBin";
            File database = new File(path);
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            ArrayList<Operations> History = null;
            fis = new FileInputStream(database);
            ois = new ObjectInputStream(fis);
            History = (ArrayList<Operations>) ois.readObject();
            fis.close();
            ois.close();
            return History;
        } catch (FileNotFoundException f) {
            FileOutputStream newfile = new FileOutputStream(SerializeCalculations.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "CalculationHistoryBin\\CalculationBin");
            newfile.close();
            return new ArrayList<>();
        }
    }
}
