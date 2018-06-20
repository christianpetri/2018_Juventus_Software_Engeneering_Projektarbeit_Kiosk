package ch.juventus.schule.semesterarbeit.exporter;

import ch.juventus.schule.semesterarbeit.business.item.BaseArticle;
import ch.juventus.schule.semesterarbeit.business.kiosk.Kiosk;

import java.io.*;
import java.nio.file.FileSystems;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Map.Entry.comparingByKey;

/**
 * @author : ${user}
 * @since: ${date}
 */


public class ExcelExporter {

    private static final String DEFAULT_SEPARATOR = "\t";

    private void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    private void writeLine(Writer w, List<String> values, String separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators.equals(' ')) {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }

    private String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    private void writeCSV(List<List<String>> data, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath, false);

        for (List<String> row : data) {
            this.writeLine(writer, row);
        }
        writer.flush();
        writer.close();
    }

    private  List<List<String>> readCSV(String filePath) {
        BufferedReader bufferedReader = null;
        List<List<String>> result = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(index, Arrays.asList(line.split(String.valueOf(DEFAULT_SEPARATOR))));
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public void writeStorageToFile(Kiosk kiosk){

        Map<BaseArticle, Integer> storage = kiosk.getInventory();

        List<BaseArticle> itemsInStorage = new ArrayList<>();

        for(Map.Entry<BaseArticle, Integer> pair :  storage.entrySet()){
            itemsInStorage.add(pair.getKey());
        }
        Collections.sort(itemsInStorage, new PriceComparator());

        Map<BaseArticle, Integer> storageSortedByPrice = new LinkedHashMap<>();

        for(BaseArticle item : itemsInStorage){
            storageSortedByPrice.put(item, storage.get(item));
        }

        List<String>   titleForExcelColumns = new ArrayList();

        titleForExcelColumns.add("Bezeichung");
        titleForExcelColumns.add("Preis CHF");
        titleForExcelColumns.add("Stueckzahl");

        List<List<String>> inventoryList = new ArrayList<>();
        inventoryList.add(titleForExcelColumns);

        for(Map.Entry<BaseArticle, Integer> pair :  storageSortedByPrice.entrySet()){
            List<String> item = new ArrayList<>();
            item.add(pair.getKey().getDescription());
            item.add(String.valueOf(pair.getKey().getPrice()));
            item.add(String.valueOf(pair.getValue()));
            inventoryList.add(item);
        }
        // Instantiate a Date object
        Date dateNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd_HHmmss");

        String kioskName = kiosk.getName();
        kioskName = kioskName.replaceAll("[^A-Za-z0-9]", "_").trim();
        try {
            this.writeCSV(inventoryList, FileSystems.getDefault().getPath("").toAbsolutePath() + "\\out\\fileOutput\\" + ft.format(dateNow)+"_"+ kioskName +"_kiosk_inventory.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}